using System;
private static bool Foo(string msg){
		if(msg.length==1) return true;
		if(msg[0]!=msg[msg.length-1])return false;
		if(msg.length==2) return true;
		Foo(msg.Substring(1,msg.length-2);
}