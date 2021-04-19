package com.gameon.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(unique = false, nullable = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@MapsId
	private Overview overview;
	
	@Column(unique = false, nullable = false)
	private String systemRequirements;
	
	@Column(unique = false, nullable = false)
	private float price;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Wishlist>wishlist;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Library>library;
	
	
	//ADD IMAGES VARIABLE HERE - TBD

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Overview getOverview() {
		return overview;
	}

	public void setOverview(Overview overview) {
		this.overview = overview;
	}

	public String getSystemRequirements() {
		return systemRequirements;
	}

	public void setSystemRequirements(String systemRequirements) {
		this.systemRequirements = systemRequirements;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Wishlist> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}

	public List<Library> getLibrary() {
		return library;
	}

	public void setLibrary(List<Library> library) {
		this.library = library;
	}


}
