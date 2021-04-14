package com.gameon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gameon.beans.Purchase;

public interface IPurchasesDao extends CrudRepository<Purchase, Long> {

	@Query("SELECT p FROM Purchase p WHERE p.user.id = :userId")
	public List<Purchase> getAllPurchasesByUserID(@Param("userId")long userId);

	@Query("SELECT p FROM Purchase p WHERE gameId = :gameId")
	public List<Purchase> getAllPurchasesByGameID(long gameId);

	@Query("SELECT p FROM Purchase p")
	public List<Purchase> getAllPurchases();
	
}
