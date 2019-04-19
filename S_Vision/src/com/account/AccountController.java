package com.account;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vo.AccountVO;
import com.vo.MemberVO;

@Controller
@RequestMapping(value="/account/")
public class AccountController {
	Logger logger = Logger.getLogger(AccountController.class);
	@Autowired
	AccountLogic accountLogic = null;
	String path = "";

	
	@GetMapping("account")
	public String accountList(@ModelAttribute AccountVO accountVO, Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("accountList 호출 성공");
		List<Map<String,Object>> accountList = null;
		String path = "";
		logger.info("mem_id:"+pMap.get("mem_id"));
		accountList = accountLogic.accountList(pMap);
		model.addAttribute("accountList", accountList);
		//insert here - 응답페이지 호출 하기
		//jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
		//WebContent이면 반환타입은 String
		//WEB-INF이면 반환타입은 void, ModelAndView 이겠지.....
		
		path = "account/account";
		//path = "forward:./accountList.jsp";
		return path;
		//return path;
	}
	@PostMapping("accountList3")
	@ResponseBody
	public List<Map<String,Object>> accountList3(HttpServletRequest req) throws ServletException, IOException {
		logger.info("accountList3 호출 성공");
		HttpSession session = req.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		List<Map<String,Object>> accountList = null;
		logger.info("mem_id:"+mem_id);
		accountList = accountLogic.accountList3(mem_id);
		logger.info(accountList.size());
		return accountList;
	}
	@RequestMapping(value = "accHistory", method = RequestMethod.POST)
	public String accHistory(@ModelAttribute AccountVO accountVO, Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("accHistory 호출 성공");
		Map<String,List<Map<String,Object>>> accHistory = null;
		String path = "";
		accHistory = accountLogic.accHistory(pMap);
		model.addAttribute("accHistory", accHistory);
		//insert here - 응답페이지 호출 하기
		//jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
		//WebContent이면 반환타입은 String
		//WEB-INF이면 반환타입은 void, ModelAndView 이겠지.....
		path = "account/accHistory";
		//path = "forward:./accountList.jsp";
		return path;
		//return path;
	}
	@ResponseBody
    @RequestMapping(value = "accountAdd", method = RequestMethod.POST)
	public int accountAdd(@ModelAttribute AccountVO accountVO, Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("accountAdd 호출 성공");
		int result = 0;
		String mem_id = req.getParameter("mem_id"); 
		String acc_num = req.getParameter("acc_num");
		String acc_bank = req.getParameter("acc_bank");
		String acc_name = req.getParameter("acc_name");
		logger.info("mem_id:"+mem_id);
		logger.info("acc_num:"+acc_num);
		logger.info("acc_bank:"+acc_bank);
		logger.info("acc_name:"+acc_name);
		accountVO.setMem_id(mem_id);
		accountVO.setAcc_num(acc_num);
		accountVO.setAcc_bank(acc_bank);
		accountVO.setAcc_name(acc_name);
		//accountVO.set//조회버튼을 눌렀을 때|입력처리 후 결과 처리페이지인지
		result = accountLogic.accountAdd(accountVO);
		//insert here - 응답페이지 호출 하기
		//jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
		//WebContent이면 반환타입은 String
		//WEB-INF이면 반환타입은 void, ModelAndView 이겠지.....
		
		//path = "forward:./accountList.jsp";
		return result;
	}
	@ResponseBody
    @RequestMapping(value = "accTransfer", method = RequestMethod.POST)
	public int accTransfer(@RequestParam Map<String,Object> pMap, HttpServletRequest req,	Model model) {
		logger.info("이체 시도");
		logger.info(pMap);
		int accTransfer = 0;
		accTransfer = accountLogic.accTransfer(pMap);
		return accTransfer;
	}
		

}



















