package com.plan;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class PlanLogic {
	Logger logger = Logger.getLogger(PlanLogic.class);
	PlanDao planDao = new PlanDao();
	public void setPlanDao(PlanDao planDao) {
		this.planDao = planDao;
	}


}
