package com.gameon.enums;

public enum UserType {
	ADMIN("Admin"),
	USER("User");
	
	
	private String name;
	
	UserType(String type){
		this.name = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	
}
