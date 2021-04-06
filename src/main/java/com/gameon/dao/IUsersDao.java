package com.gameon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gameon.beans.User;

public interface IUsersDao extends CrudRepository<User, Long> {

	public User findByUsername(@Param("username") String username);

	@Query("SELECT u FROM User u")
	public List<User> getAllUsers();


}

