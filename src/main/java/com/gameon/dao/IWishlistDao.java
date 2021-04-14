package com.gameon.dao;

import org.springframework.data.repository.CrudRepository;

import com.gameon.beans.Wishlist;


public interface IWishlistDao extends CrudRepository<Wishlist, Long> {

}
