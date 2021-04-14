package com.gameon.logic;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gameon.beans.Library;
import com.gameon.beans.PostLoginData;
import com.gameon.beans.SuccessfulLoginData;
import com.gameon.beans.User;
import com.gameon.beans.UserLoginDetails;
import com.gameon.beans.Wishlist;
import com.gameon.dao.IUsersDao;
import com.gameon.enums.ErrorType;
import com.gameon.exceptions.ApplicationException;
import com.gameon.utils.Utils;


@Controller
public class UsersController {

	@Autowired
	private IUsersDao usersDao;

	@Autowired
	private CacheController cacheController;

	@Autowired
	private LibraryController libraryController;
	
	@Autowired
	private WishlistController wishlistController;

	public UsersController() {

	}

	public Long createUser(User user) throws ApplicationException{

		if (user == null) {
			throw new ApplicationException(ErrorType.INVALID_USER,"A null user");
		}

		if (user.getPassword().equals("")) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD,"An empty password");
		}

		if (user.getPassword().length() < 6) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD,"Password is too short");
		}

		if (user.getPassword().length() > 10) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD,"Password is too long");
		}
		
		
		try {
			Library library = libraryController.createLibrary();
			user.setLibrary(library);
		}
		catch(Exception e) {
			throw new ApplicationException(ErrorType.INVALID_LIBRARY,"Failed to create a library.");
		}
		
		try {
			Wishlist wishlist = wishlistController.createWishlist();
			user.setWishlist(wishlist);
		}
		catch(Exception e) {
			throw new ApplicationException(ErrorType.INVALID_WISHLIST,"Failed to create a wishlist.");
		}
		
		
		byte[] hashedPassword = Utils.hashPassword(user.getPassword());
		Base64.Encoder enc = Base64.getEncoder();
		user.setPassword(enc.encodeToString(hashedPassword));
	
		try {
			this.usersDao.save(user);
			return user.getId();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_USER,"Failed to create user.");
		}
	}

	public void removeUser(long id) throws ApplicationException {

		try {
			User user = getUser(id);
			usersDao.delete(user);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_USER,"Failed to remove user.");
		}
	}

	public User getUser(long id)  throws ApplicationException {

		try {
			User user = usersDao.findById(id).get();
			return user;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_USER,"Failed to find user.");
		}
	}

	public void updateUser(User user) throws ApplicationException {
		
		if (user == null) {
			throw new ApplicationException(ErrorType.INVALID_USER,"A null user");
		}

		if (user.getPassword().equals("")) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD,"An empty password");
		}

		if (user.getPassword().length() < 6) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD,"Password is too short");
		}

		if (user.getPassword().length() > 10) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD,"Password is too long");
		}

		if (user.getEmail().length() < 2) {
			throw new ApplicationException(ErrorType.INVALID_USER,"Email is too short");
		}

		try {
			this.usersDao.save(user);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_USER,"Failed to update user.");
		}
	}

	public SuccessfulLoginData login(UserLoginDetails userLoginDetails) throws ApplicationException {
		
		User user = this.usersDao.findByEmail(userLoginDetails.getEmail());
		if (user == null) {
			throw new ApplicationException(ErrorType.FAILED_LOGIN, "Invalid email or password");
		}
		if(!this.comparePassword(user.getPassword(), userLoginDetails.getPassword())) {
			throw new ApplicationException(ErrorType.FAILED_LOGIN, "Invalid email or password");
		}
		PostLoginData postLoginData;
		
		postLoginData = new PostLoginData(user.getId(), user.getType());
		String token = Utils.generateToken();
		cacheController.put(token, postLoginData);
		return new SuccessfulLoginData(token, postLoginData.getUserType());

	}

	public List<User> getAllUsers() throws ApplicationException {

		try {
			return this.usersDao.getAllUsers();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_USER,"Failed to find users.");
		}
	}


	public void changePassword(String email, String oldPassword, String newPassword) throws ApplicationException {

		User user = usersDao.findByEmail(email);

		if(user == null) {
			throw new ApplicationException(ErrorType.INVALID_USER, "User has not been found");
		}
		if(!this.comparePassword(user.getPassword(), oldPassword)) {
			throw new ApplicationException(ErrorType.INVALID_PASSWORD, "Password does not match");
		}

		byte[] hashedPassword = Utils.hashPassword(newPassword);

		Base64.Encoder enc = Base64.getEncoder();
		user.setPassword(enc.encodeToString(hashedPassword));
		this.usersDao.save(user);
	}

	private boolean comparePassword(String existingPassword, String userInput) {

		byte[] userInputHash = Utils.hashPassword(userInput);
		Base64.Encoder enc = Base64.getEncoder();
		return existingPassword.equals(enc.encodeToString(userInputHash));

	}

	public PostLoginData getPostLoginDataByToken(String token) throws ApplicationException {

		PostLoginData postLoginData = cacheController.get(token);
		if(postLoginData == null) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR, "User is not logged in");
		}
		return postLoginData;
		
	}

	
	
}