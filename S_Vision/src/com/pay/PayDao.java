package com.pay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class PayDao {
	Logger logger = Logger.getLogger(PayDao.class);
	
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	Map<String,Object> payment = new HashMap<String,Object>();
	
	public Map<String,Object> complete(Map<String,Object> pMap){
		logger.info("paypw 호출 성공");
		Map<String,Object> paypw = sqlSessionTemplate.selectOne("card",pMap);
		return paypw;
	}

	public String storeNum(String pMap) {
		logger.info("complete 호출 성공");
		String storeNum = sqlSessionTemplate.selectOne("store", pMap);
		return storeNum;
	}

	public String card_pw(Map<String, Object> pMap) {
		logger.info("");
		String card_pw = sqlSessionTemplate.selectOne("paypw",pMap);
		return card_pw;
	}
}
