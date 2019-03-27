package com.rewards;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.RewardsVO;
@Service
public class RewardsLogic {
	Logger logger = Logger.getLogger(RewardsLogic.class);
	@Autowired
	RewardsDao rewardsDao = null;
	public int myPoint(RewardsVO rewardsVO) {
		int myPoint=0;
		myPoint = rewardsDao.myPoint(rewardsVO);
				
		return myPoint;
	}

}
