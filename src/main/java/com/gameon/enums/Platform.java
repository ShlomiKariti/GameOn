package com.gameon.enums;

public enum Platform {
	
	WINDOWS("Windows"),
	XBOX("Xbox"),
	PLAYSTATION("PlayStation"),
	MAC("Mac"),
	SWITCH("Switch");
	
	private String platform;
	
	Platform(String platform){
		this.platform = platform;
	}
	
	public String getPlatform() {
		return this.platform;
	}

}
