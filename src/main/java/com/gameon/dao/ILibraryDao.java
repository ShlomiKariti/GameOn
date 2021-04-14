package com.gameon.dao;

import org.springframework.data.repository.CrudRepository;

import com.gameon.beans.Library;


public interface ILibraryDao extends CrudRepository<Library, Long>{

}
