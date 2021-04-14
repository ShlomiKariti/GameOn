package com.gameon.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gameon.beans.Wishlist;
import com.gameon.dao.IWishlistDao;
import com.gameon.enums.ErrorType;
import com.gameon.exceptions.ApplicationException;

@Controller
public class WishlistController {

	@Autowired
	private IWishlistDao wishlistDao;
	
	public WishlistController() {
		
	}

	
	public Wishlist createWishlist() throws ApplicationException {

		Wishlist wishlist = new Wishlist();
		
		try {
			this.wishlistDao.save(wishlist);
			return wishlist;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,"Failed to create wishlist." );
		}
	}

	public void removeWishlist(long wishlistId) throws ApplicationException {

		try {
			Wishlist wishlist = getWishlist(wishlistId);
			wishlistDao.delete(wishlist);

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_WISHLIST,"Failed to remove the wishlist.");
		}
	}

	public Wishlist getWishlist(long wishlistId) throws ApplicationException {

		try {
			Wishlist wishlist = wishlistDao.findById(wishlistId).get();
			return wishlist;

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_WISHLIST,"No wishlist has been found.");
		}
	}

	public void updateWishlist(Wishlist wishlist) throws ApplicationException {

		if (wishlist == null) {
			throw new ApplicationException(ErrorType.INVALID_WISHLIST, "A null wishlist");
		}


		try {
			this.wishlistDao.save(wishlist);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_WISHLIST,"Failed to update wishlist.");
		}
	}
	
	
}
