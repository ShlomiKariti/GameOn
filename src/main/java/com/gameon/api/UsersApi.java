package com.gameon.api;

import java.util.List;

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

import com.gameon.beans.ChangePasswordDetails;
import com.gameon.beans.PostLoginData;
import com.gameon.beans.SuccessfulLoginData;
import com.gameon.beans.User;
import com.gameon.beans.UserLoginDetails;
import com.gameon.exceptions.ApplicationException;
import com.gameon.logic.UsersController;


@RestController
@RequestMapping("/user")
public class UsersApi {

	@Autowired
	private UsersController usersController;

	@PostMapping
	public void createUser(@RequestBody User user) throws ApplicationException {
		this.usersController.createUser(user);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) throws ApplicationException {
		this.usersController.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") long id) throws ApplicationException {
		this.usersController.removeUser(id);

	}
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") long id) throws ApplicationException {
		return this.usersController.getUser(id);

	}
	@PostMapping("/login")
	public SuccessfulLoginData login(@RequestBody UserLoginDetails userLoginDetails) throws ApplicationException {
		return this.usersController.login(userLoginDetails);
	}
	@GetMapping
	public List<User> getAllUsers() throws ApplicationException {
		return this.usersController.getAllUsers();
	}

	
	@PutMapping("/changePassword")
	public void changePassword(@RequestBody ChangePasswordDetails changePasswordDetails, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		User user = this.usersController.getUser(postLoginData.getId());
		this.usersController.changePassword(user.getEmail(), changePasswordDetails.getOldPassword(), changePasswordDetails.getNewPassword());
	}

}
