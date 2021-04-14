package com.gameon.enums;

public enum ErrorType {
	
	GENERAL_ERROR(551, "General error.", true),
	INVALID_PASSWORD(553, "Invalid Password.", false),
	INVALID_WISHLIST(554, "Wishlist doesn't exist.", false),
	INVALID_GAME(557, "Game doesn't exist.", false),
	INVALID_EMAIL(558, "Invalid Email.", false),
	INVALID_PRICE(559, "Price must be above 0.", false),
	INVALID_OVERVIEW(560, "Overview doesn't exist.", false),
	INVALID_LIBRARY(561, "Library doesn't exist.", false),
	INVALID_GENRE(562, "Must choose a category.", false),
	INVALID_GAME_TITLE(563, "Must type a game name.", false),
	INVALID_PURCHASE(564, "Purchase doesn't exist.", false),
	INVALID_USER(566, "User doesn't exist.", false),
	FAILED_LOGIN(567, "Failed login", false),
	INVALID_DATE(568, "Date has already passed.", false);
	
	
	private int errorID;
	private String errorMessage;
	private boolean isShowTrace;
	
	ErrorType(int errorID, String errorMessage, boolean isShowTrace){
		this.errorID = errorID;
		this.errorMessage = errorMessage;
		this.isShowTrace = isShowTrace;
	}

	public int getErrorID() {
		return errorID;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isShowTrace() {
		return isShowTrace;
	}

}
