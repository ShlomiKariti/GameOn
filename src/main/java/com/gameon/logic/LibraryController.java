package com.gameon.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gameon.beans.Library;
import com.gameon.dao.ILibraryDao;
import com.gameon.enums.ErrorType;
import com.gameon.exceptions.ApplicationException;

@Controller
public class LibraryController {

	@Autowired
	private ILibraryDao libraryDao;
	
	public LibraryController() {
		
	}

	
	public Library createLibrary() throws ApplicationException {

		Library library = new Library();
		
		try {
			this.libraryDao.save(library);
			return library;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,"Failed to create library." );
		}
	}

	public void removeLibrary(long libraryId) throws ApplicationException {

		try {
			Library library = getLibrary(libraryId);
			libraryDao.delete(library);

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_LIBRARY,"Failed to remove the library.");
		}
	}

	public Library getLibrary(long libraryId) throws ApplicationException {

		try {
			Library library = libraryDao.findById(libraryId).get();
			return library;

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_LIBRARY,"No library has been found.");
		}
	}

	public void updateLibrary(Library library) throws ApplicationException {

		if (library == null) {
			throw new ApplicationException(ErrorType.INVALID_LIBRARY, "A null library");
		}


		try {
			this.libraryDao.save(library);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_LIBRARY,"Failed to update library.");
		}
	}
	
	
}
