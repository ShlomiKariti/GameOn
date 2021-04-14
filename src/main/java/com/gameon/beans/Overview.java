package com.gameon.beans;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "overviews")
public class Overview {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(unique = false, nullable = false)
	private Date releaseDate;
	
	@Column(unique = false, nullable = false)
	private String genre;
	
	@Column(unique = false, nullable = false)
	private String rating;
	
	@Column(unique = false, nullable = false)
	private String publisher;
	
	@Column(unique = false, nullable = false)
	private String platform;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}
	

	
	

}
