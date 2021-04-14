package com.gameon.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wishlists")
public class Wishlist {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "wishlist", cascade = CascadeType.REMOVE)
	private List<Game>games;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	
	
}
