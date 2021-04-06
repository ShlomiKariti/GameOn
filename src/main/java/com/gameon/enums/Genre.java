package com.gameon.enums;

public enum Genre {
	
	ACTION("Action"),
	ADVENTURE("Adventure"),
	MMO("MMO"),
	PUZZLE("Puzzle"),
	RACING("Racing"),
	RPG("RPG"),
	SHOOTER("Shooter"),
	SIMULATION("Simulation"),
	SPORTS("Sports"),
	STRATEGY("Strategy");
	
	private String genre;
	
	Genre(String genre){
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	
}

