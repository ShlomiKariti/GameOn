package com.gameon.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gameon.beans.PostLoginData;


@Component
public class CacheController {
	
	private Map<String, PostLoginData> dataMap;
	
	public CacheController() {
		this.dataMap = new HashMap<>();
	}

	public void put(String key, PostLoginData value) {
		this.dataMap.put(key, value);
	}
	
	public PostLoginData get(String key) {
		return this.dataMap.get(key);
	}
	
}
