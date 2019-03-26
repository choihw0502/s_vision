package com.membership;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.rewards.RewardsLogic;

public class MembershipLogic {
	Logger logger = Logger.getLogger(MembershipLogic.class);
	MembershipDao membershipDao = null;
	public void setMembershipDao(MembershipDao membershipDao) {
		this.membershipDao = membershipDao;
	}

}
