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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gameon.beans.Game;
import com.gameon.beans.PostLoginData;
import com.gameon.enums.Genre;
import com.gameon.exceptions.ApplicationException;
import com.gameon.logic.GamesController;


@RestController
@RequestMapping("/game")
public class GamesApi {

	@Autowired
	private GamesController gamesController;
	

	@PostMapping
	public void createGame(@RequestBody Game game, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		this.gamesController.createGame(game);

	}
	@PutMapping
	public void updateGame(@RequestBody Game game) throws ApplicationException {
		this.gamesController.updateGame(game);
	}

	@GetMapping("/{id}")
	public Game getGame(@PathVariable("id") long id) throws ApplicationException {
		return this.gamesController.getGame(id);
	}

	@DeleteMapping("/{id}")
	public void removeGame(@PathVariable("id") long id) throws ApplicationException {
		this.gamesController.removeGame(id);
	}

	@GetMapping
	public List<Game> getAllGames() throws ApplicationException {
		return this.gamesController.getAllGames();
	}

	@GetMapping("/byGenre/{genre}")
	public List<Game> findByGenre(@PathVariable("genre")String genre) throws ApplicationException {
		Genre genreName = Genre.valueOf(genre.toUpperCase());
		return this.gamesController.findByGenre(genreName);

	}


}