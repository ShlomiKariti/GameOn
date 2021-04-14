package com.gameon.dao;

import org.springframework.data.repository.CrudRepository;

import com.gameon.beans.Overview;

public interface IOverviewsDao extends CrudRepository<Overview, Long> {

}
