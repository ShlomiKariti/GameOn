package com.gameon.beans;

import com.gameon.enums.UserType;

public class PostLoginData {
	
	private long id;
	private UserType userType;
	
	public PostLoginData(long id, UserType userType) {
		this.id = id;
		this.userType = userType;
		
	}

	public long getId() {
		return id;
	}


	public UserType getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return "PostLoginData [id=" + id + ", userType=" + userType + "]";
	}


}
