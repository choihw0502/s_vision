package com.card;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CardLogic {
	Logger logger = Logger.getLogger(CardLogic.class);
	@Autowired
	CardDao cardDao = null;
	
	

}
