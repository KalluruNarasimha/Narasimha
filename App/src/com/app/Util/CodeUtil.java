package com.app.Util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	private String getCommonStr(int len){
		return UUID.randomUUID().toString().replaceAll("_"," ").substring(0,len).toUpperCase();
	}
	private String getCommonStr(){
		return getCommonStr(6);
	}
	public String genToken(){
		return getCommonStr(8);
	}
	public String genpwd(){
		return getCommonStr();
	}


}
