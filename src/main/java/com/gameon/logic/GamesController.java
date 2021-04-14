package com.gameon.logic;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gameon.beans.Game;
import com.gameon.dao.IGamesDao;
import com.gameon.enums.ErrorType;
import com.gameon.enums.Genre;
import com.gameon.exceptions.ApplicationException;


@Controller
public class GamesController {

	@Autowired
	private IGamesDao gamesDao;


	public GamesController() {

	}


	public void createGame(Game game) throws com.gameon.exceptions.ApplicationException {

		if (game == null) {
			throw new ApplicationException(com.gameon.enums.ErrorType.INVALID_GAME, "A null game");
		}

		if(game.getName()=="") {
			throw new ApplicationException(ErrorType.INVALID_GAME_TITLE,"No title");
		}

		if(game.getPrice()==0) {
			throw new ApplicationException(ErrorType.INVALID_PRICE,"No price input.");
		}
		
		try {
			this.gamesDao.save(game);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,"Failed to create game." );
		}
	}

	public void removeGame(long gameId) throws ApplicationException {

		try {
			Game game = getGame(gameId);
			gamesDao.delete(game);

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_GAME,"Failed to remove the game.");
		}
	}

	public Game getGame(long gameId) throws ApplicationException {

		try {
			Game game = gamesDao.findById(gameId).get();
			return game;

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_GAME,"No game has been found.");
		}
	}

	public void updateGame(Game game) throws ApplicationException {

		if (game == null) {
			throw new ApplicationException(ErrorType.INVALID_GAME, "A null game");
		}


		if(game.getName()=="") {
			throw new ApplicationException(ErrorType.INVALID_GAME_TITLE,"No title");
		}

		if(game.getPrice()==0) {
			throw new ApplicationException(ErrorType.INVALID_PRICE,"No price input.");
		}

		try {
			this.gamesDao.save(game);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_GAME,"Failed to update game.");
		}
	}

//	public List<Game> getAllGames() throws ApplicationException {
//
//		try {
//			return this.gamesDao.getAllGames();
//		}
//		catch (Exception e) {
//			throw new ApplicationException(ErrorType.INVALID_GAME,"Failed to remove games.");
//		}
//	}
//
//	public List<Game> findByGenre(Genre genre) throws ApplicationException {
//
//		try {
//			return this.gamesDao.findByGenre(genre);
//		}
//		catch (Exception e) {
//			throw new ApplicationException(ErrorType.INVALID_GAME,"Failed to find games.");
//		}
//	}


}
