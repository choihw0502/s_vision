package com.rewards;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vo.RewardsVO;

public class RewardsLogic {
	Logger logger = Logger.getLogger(RewardsLogic.class);
	@Autowired
	RewardsDao rewardsDao = null;
	public void setRewardsDao(RewardsDao rewardsDao) {
		this.rewardsDao = rewardsDao;
	}
	public int myPoint(RewardsVO rewardsVO) {
		int myPoint=0;
		myPoint = rewardsDao.myPoint(rewardsVO);
				
		return myPoint;
	}

}
