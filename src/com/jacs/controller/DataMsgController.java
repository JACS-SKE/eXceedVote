package com.jacs.controller;

import java.util.HashMap;

public class DataMsgController {
	
	HashMap map;
	
	public DataMsgController(){
		map = new HashMap<String, String>();
	}
	
	public void addMsg(String key, String value){
		map.put(key, value);
	}
	
}
