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
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> accountList(AccountVO accountVO) {
		logger.info("accountDao accountList 호출성공");
		List<Map<String,Object>> accountList = new ArrayList<Map<String,Object>>();
		accountList = sqlSessionTemplate.selectList("accountList",accountVO);
		// TODO Auto-generated method stub
		return accountList;
	}
	public int accountAdd(AccountVO accountVO) {
		logger.info("accountDao accountAdd 호출성공");
		Map<String, Object> pMap = new HashMap<String,Object>();
		pMap.put("mem_id", accountVO.getMem_id());
		pMap.put("acc_num", accountVO.getAcc_num());
		pMap.put("acc_bank", accountVO.getAcc_bank());
		pMap.put("acc_name", accountVO.getAcc_name());
		int accountAdd = sqlSessionTemplate.insert("accountAdd",accountVO);
		// TODO Auto-generated method stub
		return accountAdd;
	}

	/*
	 * public List<Map<String, Object>> accountAdd() { List<Map<String,Object>>
	 * accountAdd = new ArrayList<Map<String,Object>>(); // TODO Auto-generated
	 * method stub return accountAdd; }
	 */

}
