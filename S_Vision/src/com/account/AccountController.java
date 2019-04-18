package com.account;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vo.AccountVO;

import block.Transaction;

@Controller
@RequestMapping(value="/account/")
public class AccountController {
	Logger logger = Logger.getLogger(AccountController.class);
	@Autowired
	AccountLogic accountLogic = null;
	String path = "";
	HttpSession session = null;
	String openKey;
	String timestamp;
	String hash;
	
	@GetMapping("account")
	public String accountList(Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("accountList 호출 성공");
		session = req.getSession();
		String mem_id = (String)session.getAttribute("mem_id");
		pMap.put("mem_id", mem_id);
		List<Map<String,Object>> accountList = null;
		String path = "";
		accountList = accountLogic.accountList(pMap);
		model.addAttribute("accountList", accountList);
		path = "account/account";
		return path;
	}
	@RequestMapping(value = "accHistory", method = RequestMethod.POST)
	public String accHistory(Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("accHistory 호출 성공");
		Map<String,List<Map<String,Object>>> accHistory = null;
		String path = "";
		accHistory = accountLogic.accHistory(pMap);
		model.addAttribute("accHistory", accHistory);
		path = "account/accHistory";
		return path;
	}
	@ResponseBody
    @RequestMapping(value = "accountAdd", method = RequestMethod.POST)
	public int accountAdd(Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("accountAdd 호출 성공");
		int result = 0;
		String acc_num = (String)pMap.get("acc_num");
		String hash = Block(acc_num);
		pMap.put("hash", hash);
		result = accountLogic.accountAdd(pMap);
		return result;
	}
	@ResponseBody
    @RequestMapping(value = "accTransfer", method = RequestMethod.POST)
	public int accTransfer(@RequestParam Map<String,Object> pMap, HttpServletRequest req,	Model model) {
		logger.info("이체 시도");
		String hash = Block("이체");
		pMap.put("hash", hash);
		logger.info(pMap);
		int accTransfer = 0;
		accTransfer = accountLogic.accTransfer(pMap);
		return accTransfer;
	}
	public String Block(String key) { //파라미터 string 브랜드 or 회원 pk
		this.openKey = key;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		this.timestamp = date.format(today);
		this.hash = calculateHash();
		return this.hash;
	}
	public String calculateHash() {
		return DigestUtils.sha256Hex(openKey+timestamp);
	}

}



















