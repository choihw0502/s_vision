package com.card;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.member.MemberLogic;

public class CardLogic {
	Logger logger = Logger.getLogger(CardLogic.class);
	CardDao cardDao = null;
	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}
	

}
