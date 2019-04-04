package com.card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.CardVO;
@Service
public class CardLogic {
	Logger logger = Logger.getLogger(CardLogic.class);
	@Autowired
	CardDao cardDao = null;
	public List<Map<String, String>> cardList(CardVO cardVO) {
		List<Map<String, String>> cardList = null; 
				cardList = cardDao.cardList(cardVO);
		   return cardList;
	}
	public int cardAdd(Map<String, Object> pMap) {
		int result=cardDao.cardAdd(pMap);
		return result;
	}
	
	

}
