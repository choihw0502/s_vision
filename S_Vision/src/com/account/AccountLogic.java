package com.account;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.vo.AccountVO;

public class AccountLogic {
	@Autowired
	AccountDao accountDao = null;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public List<Map<String, Object>> accountList(AccountVO accountVO) {//계좌리스트
		List<Map<String,Object>> accountList = null;
		accountList = accountDao.accountList(accountVO);
		return accountList;
	}
	public int accountAdd(AccountVO accountVO) {
		int accountAdd = accountDao.accountAdd(accountVO);
		return accountAdd;
	}
	

}
