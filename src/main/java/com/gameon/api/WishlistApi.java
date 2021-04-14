package com.gameon.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gameon.beans.Wishlist;
import com.gameon.beans.PostLoginData;
import com.gameon.exceptions.ApplicationException;
import com.gameon.logic.WishlistController;

@RestController
@RequestMapping("/wishlist")
public class WishlistApi {
	
	@Autowired
	private WishlistController wishlistController;
	

//	@PostMapping
//	public void createWishlist(@RequestBody Wishlist wishlist, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
//		this.wishlistController.createWishlist();
//
//	}
	@PutMapping
	public void updateWishlist(@RequestBody Wishlist wishlist) throws ApplicationException {
		this.wishlistController.updateWishlist(wishlist);
	}

	@GetMapping("/{id}")
	public Wishlist getWishlist(@PathVariable("id") long id) throws ApplicationException {
		return this.wishlistController.getWishlist(id);
	}

	@DeleteMapping("/{id}")
	public void removeWishlist(@PathVariable("id") long id) throws ApplicationException {
		this.wishlistController.removeWishlist(id);
	}
}
