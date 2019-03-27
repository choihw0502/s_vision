package com.plan;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlanLogic {
	Logger logger = Logger.getLogger(PlanLogic.class);
	@Autowired
	PlanDao planDao = new PlanDao();
	


}
