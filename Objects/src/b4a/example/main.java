package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.EditTextWrapper _firstnum = null;
public anywheresoftware.b4a.objects.ButtonWrapper _seven = null;
public anywheresoftware.b4a.objects.ButtonWrapper _eight = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nine = null;
public anywheresoftware.b4a.objects.ButtonWrapper _divide = null;
public anywheresoftware.b4a.objects.ButtonWrapper _multiply = null;
public anywheresoftware.b4a.objects.ButtonWrapper _six = null;
public anywheresoftware.b4a.objects.ButtonWrapper _five = null;
public anywheresoftware.b4a.objects.ButtonWrapper _four = null;
public anywheresoftware.b4a.objects.ButtonWrapper _one = null;
public anywheresoftware.b4a.objects.ButtonWrapper _two = null;
public anywheresoftware.b4a.objects.ButtonWrapper _three = null;
public anywheresoftware.b4a.objects.ButtonWrapper _plus = null;
public anywheresoftware.b4a.objects.ButtonWrapper _equals = null;
public anywheresoftware.b4a.objects.ButtonWrapper _dot = null;
public anywheresoftware.b4a.objects.ButtonWrapper _zero = null;
public anywheresoftware.b4a.objects.ButtonWrapper _c = null;
public static String _checkoperator = "";
public static int _num1 = 0;
public static boolean _operationclicked = false;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button2_click", null));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub Button2_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="OperationClicked = True";
_operationclicked = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="CheckOperator = \"minus\"";
mostCurrent._checkoperator = "minus";
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="num1 = FirstNum.Text";
_num1 = (int)(Double.parseDouble(mostCurrent._firstnum.getText()));
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Number invalid"),BA.ObjectToCharSequence("INVALID"));
 };
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="End Sub";
return "";
}
public static String  _c_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "c_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "c_click", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub C_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _compute() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "compute", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "compute", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Compute";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Select Case CheckOperator";
switch (BA.switchObjectToInt(mostCurrent._checkoperator,"divide","multiply","Add","minus")) {
case 0: {
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="FirstNum.Text = num1 / FirstNum.Text";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(_num1/(double)(double)(Double.parseDouble(mostCurrent._firstnum.getText()))));
 break; }
case 1: {
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="FirstNum.Text = num1 * FirstNum.Text";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(_num1*(double)(Double.parseDouble(mostCurrent._firstnum.getText()))));
 break; }
case 2: {
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="FirstNum.Text = num1 + FirstNum.Text";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(_num1+(double)(Double.parseDouble(mostCurrent._firstnum.getText()))));
 break; }
case 3: {
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="FirstNum.Text = num1 - FirstNum.Text";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(_num1-(double)(Double.parseDouble(mostCurrent._firstnum.getText()))));
 break; }
}
;
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="End Sub";
return "";
}
public static String  _divide_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "divide_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "divide_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub Divide_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Try";
try {RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="OperationClicked = True";
_operationclicked = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="CheckOperator = \"divide\"";
mostCurrent._checkoperator = "divide";
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="num1 = FirstNum.Text";
_num1 = (int)(Double.parseDouble(mostCurrent._firstnum.getText()));
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Number invalid"),BA.ObjectToCharSequence("INVALID"));
 };
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="End Sub";
return "";
}
public static String  _dot_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dot_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "dot_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub Dot_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="FirstNum.Text = FirstNum.Text & \".\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"."));
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _eight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "eight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "eight_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub Eight_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="FirstNum.Text = FirstNum.Text & \"8\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"8"));
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="End Sub";
return "";
}
public static String  _equals_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "equals_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "equals_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub Equals_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Compute";
_compute();
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _five_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "five_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "five_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub Five_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="FirstNum.Text = FirstNum.Text & \"5\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"5"));
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="End Sub";
return "";
}
public static String  _four_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "four_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "four_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub Four_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="FirstNum.Text = FirstNum.Text & \"4\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"4"));
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="End Sub";
return "";
}
public static String  _multiply_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "multiply_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "multiply_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub Multiply_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Try";
try {RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="OperationClicked = True";
_operationclicked = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="CheckOperator = \"multiply\"";
mostCurrent._checkoperator = "multiply";
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="num1 = FirstNum.Text";
_num1 = (int)(Double.parseDouble(mostCurrent._firstnum.getText()));
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Number invalid"),BA.ObjectToCharSequence("INVALID"));
 };
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="End Sub";
return "";
}
public static String  _nine_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nine_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nine_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub Nine_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="FirstNum.Text = FirstNum.Text & \"9\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"9"));
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="End Sub";
return "";
}
public static String  _one_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "one_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "one_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub One_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="FirstNum.Text = FirstNum.Text & \"1\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"1"));
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="End Sub";
return "";
}
public static String  _plus_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "plus_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "plus_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub Plus_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Try";
try {RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="OperationClicked = True";
_operationclicked = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="CheckOperator = \"Add\"";
mostCurrent._checkoperator = "Add";
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="num1 = FirstNum.Text";
_num1 = (int)(Double.parseDouble(mostCurrent._firstnum.getText()));
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Number invalid"),BA.ObjectToCharSequence("INVALID"));
 };
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="End Sub";
return "";
}
public static String  _seven_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "seven_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "seven_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub Seven_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="FirstNum.Text = FirstNum.Text & \"7\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"7"));
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="End Sub";
return "";
}
public static String  _six_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "six_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "six_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub Six_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="FirstNum.Text = FirstNum.Text & \"6\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"6"));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="End Sub";
return "";
}
public static String  _three_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "three_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "three_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub Three_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="FirstNum.Text = FirstNum.Text & \"3\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"3"));
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="End Sub";
return "";
}
public static String  _total_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "total_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "total_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub Total_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Try";
try {RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Compute";
_compute();
 } 
       catch (Exception e4) {
			processBA.setLastException(e4);RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Number invalid"),BA.ObjectToCharSequence("INVALID"));
 };
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="End Sub";
return "";
}
public static String  _two_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "two_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "two_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub Two_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="FirstNum.Text = FirstNum.Text & \"2\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"2"));
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="End Sub";
return "";
}
public static String  _zero_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "zero_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "zero_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub Zero_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If OperationClicked Then";
if (_operationclicked) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="FirstNum.Text = \"\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(""));
 };
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="FirstNum.Text = FirstNum.Text & \"0\"";
mostCurrent._firstnum.setText(BA.ObjectToCharSequence(mostCurrent._firstnum.getText()+"0"));
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="OperationClicked = False";
_operationclicked = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="End Sub";
return "";
}
}