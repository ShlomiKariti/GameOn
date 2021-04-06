package com.gameon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gameon.beans.Game;
import com.gameon.enums.Genre;


public interface IGamesDao extends CrudRepository<Game, Long> {

	@Query("SELECT g FROM Game g WHERE g.genre = :genre")
	public List<Game> findByGenre(@Param("genre")Genre genre);

	@Query("SELECT g from Game g")
	public List<Game> getAllGames();


}