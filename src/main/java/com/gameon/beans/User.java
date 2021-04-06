package com.gameon.beans;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gameon.enums.UserType;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = false, nullable = false)
	private String password;

	@Column(unique = false, nullable = false)
	private Date birthday;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@MapsId
	private Library library;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@MapsId
	private Wishlist wishlist;

	@Enumerated(EnumType.STRING)
	@Column(unique = false, nullable = false)
	private UserType type;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//	@ManyToOne(fetch = FetchType.LAZY)
	//	@JoinColumn(name = "company_id")
	//	private Company company;


	//
	//	public void setCompany(Company company) {
	//		this.company = company;
	//	}




}

