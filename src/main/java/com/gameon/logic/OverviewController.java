package com.gameon.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gameon.beans.Overview;
import com.gameon.dao.IOverviewsDao;
import com.gameon.enums.ErrorType;
import com.gameon.exceptions.ApplicationException;


@Controller
public class OverviewController {
	
	@Autowired
	private IOverviewsDao overviewsDao;
	
	public OverviewController() {
		
	}

	
	public Overview createOverview() throws ApplicationException {

		Overview overview = new Overview();

		try {
			this.overviewsDao.save(overview);
			return overview;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,"Failed to create overview." );
		}
	}

	public void removeOverview(long overviewId) throws ApplicationException {

		try {
			Overview overview = getOverview(overviewId);
			overviewsDao.delete(overview);

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_OVERVIEW,"Failed to remove the overview.");
		}
	}

	public Overview getOverview(long overviewId) throws ApplicationException {

		try {
			Overview overview = overviewsDao.findById(overviewId).get();
			return overview;

		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_OVERVIEW,"No overview has been found.");
		}
	}

	public void updateOverview(Overview overview) throws ApplicationException {

		if (overview == null) {
			throw new ApplicationException(ErrorType.INVALID_OVERVIEW, "A null overview");
		}


		try {
			this.overviewsDao.save(overview);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_OVERVIEW,"Failed to update overview.");
		}
	}

	
}
