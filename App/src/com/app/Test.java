package com.app;

import java.util.UUID;

public class Test {
	public static void main(String[] a){
		UUID ob=UUID.randomUUID();
		String s=ob.toString();
		s=s.replaceAll("_"," ");
		s=s.substring(0,8);
		System.out.println(s);
	}

}
