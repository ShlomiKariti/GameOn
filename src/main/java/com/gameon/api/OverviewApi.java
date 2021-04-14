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

import com.gameon.beans.Overview;
import com.gameon.beans.PostLoginData;
import com.gameon.exceptions.ApplicationException;
import com.gameon.logic.OverviewController;


@RestController
@RequestMapping("/overview")
public class OverviewApi {
	
	@Autowired
	private OverviewController overviewsController;
	

	@PostMapping
	public void createOverview(@RequestBody Overview overview, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		this.overviewsController.createOverview(overview);

	}
	@PutMapping
	public void updateOverview(@RequestBody Overview overview) throws ApplicationException {
		this.overviewsController.updateOverview(overview);
	}

	@GetMapping("/{id}")
	public Overview getOverview(@PathVariable("id") long id) throws ApplicationException {
		return this.overviewsController.getOverview(id);
	}

	@DeleteMapping("/{id}")
	public void removeOverview(@PathVariable("id") long id) throws ApplicationException {
		this.overviewsController.removeOverview(id);
	}





}
