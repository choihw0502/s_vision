package com.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.rewards.RewardsDao;
import com.util.MyBatisCommonFactory;
import com.vo.AccountVO;

public class AccountDao {
	Logger logger = Logger.getLogger(AccountDao.class);

	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> accountList(Map<String, Object> pMap) {
		logger.info("accountDao accountList 호출성공");
		List<Map<String,Object>> accountList = new ArrayList<Map<String,Object>>();
		accountList = sqlSessionTemplate.selectList("accountList2",pMap);
		// TODO Auto-generated method stub
		return accountList;
	}
	public int accountAdd(AccountVO accountVO) {
		logger.info("accountDao accountAdd 호출성공");
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("P_MEM_ID", accountVO.getMem_id());
		pMap.put("P_ACC_NUM", accountVO.getAcc_num());
		pMap.put("P_ACC_BANK", accountVO.getAcc_bank());
		pMap.put("P_ACC_NAME", accountVO.getAcc_name());
		logger.info(pMap.get("P_MEM_ID"));
		int accountAdd = sqlSessionTemplate.insert("proc_accountAdd",pMap);
		// TODO Auto-generated method stub
		return accountAdd;
	}
	public Map<String, List<Map<String, Object>>> accHistory(Map<String, Object> pMap) {
		logger.info("Account-accHistory 호출성공");
		Map<String, List<Map<String, Object>>> accHistory = new HashMap<String,List<Map<String,Object>>>();
		List<Map<String,Object>> acchistoryToday = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> acchistory1 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> acchistory3 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> acchistory6 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> acchistory12 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> acchistory3day = new ArrayList<Map<String,Object>>();
		acchistoryToday = sqlSessionTemplate.selectList("acchistoryToday",pMap);
		acchistory1 = sqlSessionTemplate.selectList("acchistory1",pMap);
		acchistory3 = sqlSessionTemplate.selectList("acchistory3",pMap);
		acchistory6 = sqlSessionTemplate.selectList("acchistory6",pMap);
		acchistory12 = sqlSessionTemplate.selectList("acchistory12",pMap);
		acchistory3day = sqlSessionTemplate.selectList("acchistory3day",pMap);
		accHistory.put("today", acchistoryToday);
		accHistory.put("1", acchistory1);
		accHistory.put("3", acchistory3);
		accHistory.put("6", acchistory6);
		accHistory.put("12", acchistory12);
		accHistory.put("3day", acchistory3day);
		return accHistory;
	}
	public int accTransfer(Map<String, Object> pMap) {
		logger.info("이체 sql호출직전");
		sqlSessionTemplate.selectOne("accTransfer2",pMap);
		int accTransfer = (Integer)pMap.get("result");
		logger.info(accTransfer);
		return accTransfer;
	}
	public List<Map<String, Object>> accountList3(String mem_id) {
		logger.info("accountList3 호출 성공");
		List<Map<String,Object>> accountList = new ArrayList<Map<String,Object>>();
		accountList = sqlSessionTemplate.selectList("accountList3",mem_id);
		return accountList;
	}

	/*
	 * public List<Map<String, Object>> accountAdd() { List<Map<String,Object>>
	 * accountAdd = new ArrayList<Map<String,Object>>(); // TODO Auto-generated
	 * method stub return accountAdd; }
	 */

}
