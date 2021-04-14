package com.gameon.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gameon.beans.Purchase;
import com.gameon.dao.IPurchasesDao;
import com.gameon.enums.ErrorType;
import com.gameon.exceptions.ApplicationException;


@Controller
public class PurchasesController {

	@Autowired
	private IPurchasesDao purchasesDao;

	public PurchasesController() {

	}

	public void createPurchase(Purchase purchase) throws ApplicationException {
		if (purchase == null) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"A null purchase");
		}
		try {
			this.purchasesDao.save(purchase);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"Failed to attempt purchase.");
		}
	}

	public void removePurchase(long id) throws ApplicationException {

		try {
			Purchase purchase = getPurchase(id);
			purchasesDao.delete(purchase);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"Failed to remove purchase.");
		}
	}

	public Purchase getPurchase(long id)  throws ApplicationException {

		try {
			Purchase purchase = purchasesDao.findById(id).get();
			return purchase;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"Could not find a purchase.");
		}
	}

	public List<Purchase> getAllPurchasesByUserID(long userId) throws ApplicationException {

		try {
			return this.purchasesDao.getAllPurchasesByUserID(userId);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"No purchases have been found.");
		}

	}

	public List<Purchase> getAllPurchasesByGameID(long gameId) throws ApplicationException {
		try {
			return this.purchasesDao.getAllPurchasesByGameID(gameId);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"No purchases have been found.");
		}
	}

	public List<Purchase> getAllPurchases() throws ApplicationException {

		try {
			return this.purchasesDao.getAllPurchases();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"No purchases have been found.");
		}
	}
}
