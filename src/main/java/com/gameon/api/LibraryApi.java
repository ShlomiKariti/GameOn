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

import com.gameon.beans.Library;
import com.gameon.beans.PostLoginData;
import com.gameon.exceptions.ApplicationException;
import com.gameon.logic.LibraryController;

@RestController
@RequestMapping("/library")
public class LibraryApi {
	
	@Autowired
	private LibraryController libraryController;
	

//	@PostMapping
//	public void createLibrary(@RequestBody Library library, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
//		this.libraryController.createLibrary();
//
//	}
	@PutMapping
	public void updateLibrary(@RequestBody Library library) throws ApplicationException {
		this.libraryController.updateLibrary(library);
	}

	@GetMapping("/{id}")
	public Library getLibrary(@PathVariable("id") long id) throws ApplicationException {
		return this.libraryController.getLibrary(id);
	}

	@DeleteMapping("/{id}")
	public void removeLibrary(@PathVariable("id") long id) throws ApplicationException {
		this.libraryController.removeLibrary(id);
	}
}
