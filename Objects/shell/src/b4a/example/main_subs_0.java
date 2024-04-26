package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,212);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button2_click");}
 BA.debugLineNum = 212;BA.debugLine="Private Sub Button2_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 214;BA.debugLine="OperationClicked = True";
Debug.ShouldStop(2097152);
main._operationclicked = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 215;BA.debugLine="CheckOperator = \"minus\"";
Debug.ShouldStop(4194304);
main.mostCurrent._checkoperator = BA.ObjectToString("minus");
 BA.debugLineNum = 216;BA.debugLine="num1 = FirstNum.Text";
Debug.ShouldStop(8388608);
main._num1 = BA.numberCast(int.class, main.mostCurrent._firstnum.runMethod(true,"getText"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e6.toString()); BA.debugLineNum = 218;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
Debug.ShouldStop(33554432);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Number invalid")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INVALID"))));
 };
 BA.debugLineNum = 220;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _c_click() throws Exception{
try {
		Debug.PushSubsStack("C_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("c_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","c_click");}
 BA.debugLineNum = 72;BA.debugLine="Private Sub C_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(256);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _compute() throws Exception{
try {
		Debug.PushSubsStack("Compute (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,52);
if (RapidSub.canDelegate("compute")) { return b4a.example.main.remoteMe.runUserSub(false, "main","compute");}
 BA.debugLineNum = 52;BA.debugLine="Sub Compute";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Select Case CheckOperator";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(main.mostCurrent._checkoperator,BA.ObjectToString("divide"),BA.ObjectToString("multiply"),BA.ObjectToString("Add"),BA.ObjectToString("minus"))) {
case 0: {
 BA.debugLineNum = 55;BA.debugLine="FirstNum.Text = num1 / FirstNum.Text";
Debug.ShouldStop(4194304);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {main._num1,BA.numberCast(double.class, main.mostCurrent._firstnum.runMethod(true,"getText"))}, "/",0, 0)));
 break; }
case 1: {
 BA.debugLineNum = 58;BA.debugLine="FirstNum.Text = num1 * FirstNum.Text";
Debug.ShouldStop(33554432);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {main._num1,BA.numberCast(double.class, main.mostCurrent._firstnum.runMethod(true,"getText"))}, "*",0, 0)));
 break; }
case 2: {
 BA.debugLineNum = 61;BA.debugLine="FirstNum.Text = num1 + FirstNum.Text";
Debug.ShouldStop(268435456);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {main._num1,BA.numberCast(double.class, main.mostCurrent._firstnum.runMethod(true,"getText"))}, "+",1, 0)));
 break; }
case 3: {
 BA.debugLineNum = 63;BA.debugLine="FirstNum.Text = num1 - FirstNum.Text";
Debug.ShouldStop(1073741824);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {main._num1,BA.numberCast(double.class, main.mostCurrent._firstnum.runMethod(true,"getText"))}, "-",1, 0)));
 break; }
}
;
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _divide_click() throws Exception{
try {
		Debug.PushSubsStack("Divide_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,167);
if (RapidSub.canDelegate("divide_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","divide_click");}
 BA.debugLineNum = 167;BA.debugLine="Private Sub Divide_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 169;BA.debugLine="OperationClicked = True";
Debug.ShouldStop(256);
main._operationclicked = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 170;BA.debugLine="CheckOperator = \"divide\"";
Debug.ShouldStop(512);
main.mostCurrent._checkoperator = BA.ObjectToString("divide");
 BA.debugLineNum = 171;BA.debugLine="num1 = FirstNum.Text";
Debug.ShouldStop(1024);
main._num1 = BA.numberCast(int.class, main.mostCurrent._firstnum.runMethod(true,"getText"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e6.toString()); BA.debugLineNum = 173;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
Debug.ShouldStop(4096);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Number invalid")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INVALID"))));
 };
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dot_click() throws Exception{
try {
		Debug.PushSubsStack("Dot_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,85);
if (RapidSub.canDelegate("dot_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","dot_click");}
 BA.debugLineNum = 85;BA.debugLine="Private Sub Dot_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="FirstNum.Text = FirstNum.Text & \".\"";
Debug.ShouldStop(2097152);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("."))));
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _eight_click() throws Exception{
try {
		Debug.PushSubsStack("Eight_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,186);
if (RapidSub.canDelegate("eight_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","eight_click");}
 BA.debugLineNum = 186;BA.debugLine="Private Sub Eight_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 187;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(67108864);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 188;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(134217728);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 191;BA.debugLine="FirstNum.Text = FirstNum.Text & \"8\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("8"))));
 BA.debugLineNum = 192;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(-2147483648);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _equals_click() throws Exception{
try {
		Debug.PushSubsStack("Equals_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,89);
if (RapidSub.canDelegate("equals_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","equals_click");}
 BA.debugLineNum = 89;BA.debugLine="Private Sub Equals_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="Compute";
Debug.ShouldStop(33554432);
_compute();
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _five_click() throws Exception{
try {
		Debug.PushSubsStack("Five_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,139);
if (RapidSub.canDelegate("five_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","five_click");}
 BA.debugLineNum = 139;BA.debugLine="Private Sub Five_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(2048);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 141;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(4096);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 144;BA.debugLine="FirstNum.Text = FirstNum.Text & \"5\"";
Debug.ShouldStop(32768);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("5"))));
 BA.debugLineNum = 145;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(65536);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _four_click() throws Exception{
try {
		Debug.PushSubsStack("Four_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,130);
if (RapidSub.canDelegate("four_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","four_click");}
 BA.debugLineNum = 130;BA.debugLine="Private Sub Four_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(4);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 132;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(8);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 135;BA.debugLine="FirstNum.Text = FirstNum.Text & \"4\"";
Debug.ShouldStop(64);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("4"))));
 BA.debugLineNum = 136;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(128);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private FirstNum As EditText";
main.mostCurrent._firstnum = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private Seven As Button";
main.mostCurrent._seven = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Eight As Button";
main.mostCurrent._eight = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Nine As Button";
main.mostCurrent._nine = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Divide As Button";
main.mostCurrent._divide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Multiply As Button";
main.mostCurrent._multiply = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Six As Button";
main.mostCurrent._six = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Five As Button";
main.mostCurrent._five = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Four As Button";
main.mostCurrent._four = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private One As Button";
main.mostCurrent._one = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Two As Button";
main.mostCurrent._two = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private Three As Button";
main.mostCurrent._three = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private Plus As Button";
main.mostCurrent._plus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Equals As Button";
main.mostCurrent._equals = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private Dot As Button";
main.mostCurrent._dot = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private Zero As Button";
main.mostCurrent._zero = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private C As Button";
main.mostCurrent._c = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Dim CheckOperator As String";
main.mostCurrent._checkoperator = RemoteObject.createImmutable("");
 //BA.debugLineNum = 42;BA.debugLine="Dim num1 As Int";
main._num1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 43;BA.debugLine="Dim OperationClicked As Boolean = False";
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _multiply_click() throws Exception{
try {
		Debug.PushSubsStack("Multiply_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,157);
if (RapidSub.canDelegate("multiply_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","multiply_click");}
 BA.debugLineNum = 157;BA.debugLine="Private Sub Multiply_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 159;BA.debugLine="OperationClicked = True";
Debug.ShouldStop(1073741824);
main._operationclicked = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 160;BA.debugLine="CheckOperator = \"multiply\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._checkoperator = BA.ObjectToString("multiply");
 BA.debugLineNum = 161;BA.debugLine="num1 = FirstNum.Text";
Debug.ShouldStop(1);
main._num1 = BA.numberCast(int.class, main.mostCurrent._firstnum.runMethod(true,"getText"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e6.toString()); BA.debugLineNum = 163;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
Debug.ShouldStop(4);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Number invalid")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INVALID"))));
 };
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nine_click() throws Exception{
try {
		Debug.PushSubsStack("Nine_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,177);
if (RapidSub.canDelegate("nine_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","nine_click");}
 BA.debugLineNum = 177;BA.debugLine="Private Sub Nine_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(131072);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 179;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(262144);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 182;BA.debugLine="FirstNum.Text = FirstNum.Text & \"9\"";
Debug.ShouldStop(2097152);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("9"))));
 BA.debugLineNum = 183;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(4194304);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _one_click() throws Exception{
try {
		Debug.PushSubsStack("One_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,121);
if (RapidSub.canDelegate("one_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","one_click");}
 BA.debugLineNum = 121;BA.debugLine="Private Sub One_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 122;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(33554432);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 123;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 126;BA.debugLine="FirstNum.Text = FirstNum.Text & \"1\"";
Debug.ShouldStop(536870912);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("1"))));
 BA.debugLineNum = 127;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(1073741824);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _plus_click() throws Exception{
try {
		Debug.PushSubsStack("Plus_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,93);
if (RapidSub.canDelegate("plus_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","plus_click");}
 BA.debugLineNum = 93;BA.debugLine="Private Sub Plus_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 95;BA.debugLine="OperationClicked = True";
Debug.ShouldStop(1073741824);
main._operationclicked = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 96;BA.debugLine="CheckOperator = \"Add\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._checkoperator = BA.ObjectToString("Add");
 BA.debugLineNum = 97;BA.debugLine="num1 = FirstNum.Text";
Debug.ShouldStop(1);
main._num1 = BA.numberCast(int.class, main.mostCurrent._firstnum.runMethod(true,"getText"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e6.toString()); BA.debugLineNum = 99;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
Debug.ShouldStop(4);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Number invalid")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INVALID"))));
 };
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _seven_click() throws Exception{
try {
		Debug.PushSubsStack("Seven_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,195);
if (RapidSub.canDelegate("seven_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","seven_click");}
 BA.debugLineNum = 195;BA.debugLine="Private Sub Seven_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 196;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(8);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 197;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(16);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 200;BA.debugLine="FirstNum.Text = FirstNum.Text & \"7\"";
Debug.ShouldStop(128);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("7"))));
 BA.debugLineNum = 201;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(256);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _six_click() throws Exception{
try {
		Debug.PushSubsStack("Six_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,148);
if (RapidSub.canDelegate("six_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","six_click");}
 BA.debugLineNum = 148;BA.debugLine="Private Sub Six_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(1048576);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 150;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 153;BA.debugLine="FirstNum.Text = FirstNum.Text & \"6\"";
Debug.ShouldStop(16777216);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("6"))));
 BA.debugLineNum = 154;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(33554432);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _three_click() throws Exception{
try {
		Debug.PushSubsStack("Three_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,103);
if (RapidSub.canDelegate("three_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","three_click");}
 BA.debugLineNum = 103;BA.debugLine="Private Sub Three_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(128);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 105;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(256);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 108;BA.debugLine="FirstNum.Text = FirstNum.Text & \"3\"";
Debug.ShouldStop(2048);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("3"))));
 BA.debugLineNum = 109;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(4096);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _total_click() throws Exception{
try {
		Debug.PushSubsStack("Total_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,204);
if (RapidSub.canDelegate("total_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","total_click");}
 BA.debugLineNum = 204;BA.debugLine="Private Sub Total_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 205;BA.debugLine="Try";
Debug.ShouldStop(4096);
try { BA.debugLineNum = 206;BA.debugLine="Compute";
Debug.ShouldStop(8192);
_compute();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e4) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e4.toString()); BA.debugLineNum = 208;BA.debugLine="xui.MsgboxAsync(\"Number invalid\",\"INVALID\")";
Debug.ShouldStop(32768);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Number invalid")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INVALID"))));
 };
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _two_click() throws Exception{
try {
		Debug.PushSubsStack("Two_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,112);
if (RapidSub.canDelegate("two_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","two_click");}
 BA.debugLineNum = 112;BA.debugLine="Private Sub Two_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(65536);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 114;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(131072);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 117;BA.debugLine="FirstNum.Text = FirstNum.Text & \"2\"";
Debug.ShouldStop(1048576);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("2"))));
 BA.debugLineNum = 118;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(2097152);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _zero_click() throws Exception{
try {
		Debug.PushSubsStack("Zero_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,76);
if (RapidSub.canDelegate("zero_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","zero_click");}
 BA.debugLineNum = 76;BA.debugLine="Private Sub Zero_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="If OperationClicked Then";
Debug.ShouldStop(4096);
if (main._operationclicked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 78;BA.debugLine="FirstNum.Text = \"\"";
Debug.ShouldStop(8192);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 81;BA.debugLine="FirstNum.Text = FirstNum.Text & \"0\"";
Debug.ShouldStop(65536);
main.mostCurrent._firstnum.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._firstnum.runMethod(true,"getText"),RemoteObject.createImmutable("0"))));
 BA.debugLineNum = 82;BA.debugLine="OperationClicked = False";
Debug.ShouldStop(131072);
main._operationclicked = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}