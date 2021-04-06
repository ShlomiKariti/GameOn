package com.gameon.beans;

public class UserLoginDetails {
	
	private String email;
	private String password;
	
	public UserLoginDetails() {
		
	}

	@Override
	public String toString() {
		return "UserLoginDetails [email=" + email + ", password=" + password + "]";
	}

	public UserLoginDetails(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
