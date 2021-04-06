package com.gameon.enums;

public enum UserType {
	ADMIN("Admin"),
	CUSTOMER("Customer");
	
	
	private String name;
	
	UserType(String type){
		this.name = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	
}
