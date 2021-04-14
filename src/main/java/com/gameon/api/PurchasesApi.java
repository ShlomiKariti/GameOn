package com.gameon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gameon.beans.PostLoginData;
import com.gameon.beans.Purchase;
import com.gameon.beans.User;
import com.gameon.exceptions.ApplicationException;
import com.gameon.logic.PurchasesController;


@RestController
@RequestMapping("/purchase")
public class PurchasesApi {

	@Autowired
	private PurchasesController purchasesController;


	@PostMapping
	public void createPurchase(@RequestBody Purchase purchase, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		purchase.setUser(new User());
		purchase.getUser().setId(postLoginData.getId());
		this.purchasesController.createPurchase(purchase);
	}

	@DeleteMapping("/{id}")
	public void removePurchase(@PathVariable("id") long id) throws ApplicationException {
		this.purchasesController.removePurchase(id);

	}
	@GetMapping("/{id}")
	public Purchase getPurchaseByPurchaseID(@PathVariable("id")long id) throws ApplicationException {
		return this.purchasesController.getPurchase(id);

	}
	@GetMapping("/user")
	public List<Purchase> getAllPurchasesByUserID(@RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		return this.purchasesController.getAllPurchasesByUserID(postLoginData.getId());
	}

	@GetMapping("/game/{game_id}")
	public List<Purchase> getAllPurchasesByGameID(@RequestParam("game_id")long gameId) throws ApplicationException {
		return this.purchasesController.getAllPurchasesByGameID(gameId);
	}
	
	@GetMapping
	public List<Purchase> getAllPurchases() throws ApplicationException {
		return this.purchasesController.getAllPurchases();
	}
	
	
}