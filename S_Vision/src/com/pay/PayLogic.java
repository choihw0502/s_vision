package com.pay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import block.Wellet;

@Service
public class PayLogic {
	Logger logger = Logger.getLogger(PayLogic.class);
	@Autowired
	PayDao payDao = null;
	Map<String,Object> payment;
	
	List<Wellet> wellList = new ArrayList<Wellet>();
	Wellet w = null;
	
	public String complete(Map<String, Object> pMap) {
		logger.info("payPw호출 성공");
		logger.info(pMap);
		logger.info("카드 정보"+pMap.values().toString());
		String storeNum = payDao.storeNum(pMap.get("store_name").toString());
		pMap.put("STORE_NAME", storeNum);
		Map<String,Object> paypw = payDao.complete(pMap);
		logger.info(paypw);
		w = new Wellet(paypw);
		wellList.add(w);
			if(wellList.size()==1) {
				logger.info("info :" + wellList.get(0).info.get("CARD_PAY_PW"));
				logger.info("info :" + wellList.get(0).info.get("MEM_ID"));
				logger.info("info :" + wellList.get(0).info.get("CARD_NUM"));
				logger.info("info :" + wellList.get(0).info.get("CARD_LIMIT"));
				logger.info("info :" + wellList.get(0).info.get("CHAINNO"));
			}
		int balance = Integer.parseInt(paypw.get("CARD_LIMIT").toString())-Integer.parseInt(pMap.get("amount").toString());
		logger.info("남은 금액 "+ balance);
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd\0hh:mm:ss");
		String day = date.format(today);
		String hash = DigestUtils.sha256Hex(paypw.get("MEM_ID").toString()+day);
		StringBuilder sb = new StringBuilder();
		sb.append(paypw.get("CHAINNO").toString()+"\0");
		sb.append(hash+"\0");
		sb.append(paypw.get("MEM_ID").toString()+"\0");
		sb.append(pMap.get("store_name").toString()+"\0");
		sb.append(balance+"\0");
		sb.append(pMap.get("amount").toString()+"\0");
		sb.append(day);
		sb.append(paypw.get("CARD_NUM"));
		logger.info(sb.toString());
		return sb.toString();
	}

	public int result() {
		
		return 0;
	}

	public String card_pw(Map<String, Object> pMap) {
		logger.info("");
		String card_pw = payDao.card_pw(pMap);
		return card_pw;
	}

}
