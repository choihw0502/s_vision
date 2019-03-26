package com.member;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.membership.MembershipLogic;


public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberDao = null;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
