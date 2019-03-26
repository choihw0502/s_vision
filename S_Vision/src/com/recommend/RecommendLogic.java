package com.recommend;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.plan.PlanDao;

public class RecommendLogic {
	Logger logger = Logger.getLogger(RecommendLogic.class);
	RecommendDao recommendDao = null;
	public void setRecommendDao(RecommendDao recommendDao) {
		this.recommendDao = recommendDao;
	}

}
