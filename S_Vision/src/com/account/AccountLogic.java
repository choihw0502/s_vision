package com.account;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.AccountVO;
@Service
public class AccountLogic {
	@Autowired
	AccountDao accountDao = null;

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
