package com.account;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vo.AccountVO;

@Controller
@RequestMapping(value="/account/")
public class AccountController {
	Logger logger = Logger.getLogger(AccountController.class);
	@Autowired
	AccountLogic accountLogic = null;
	public void setAccountLogic(AccountLogic accountLogic) {
		this.accountLogic = accountLogic;
	}
	
	@GetMapping("accountList")
	public ModelAndView accountList(@ModelAttribute AccountVO accountVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		logger.info("accountList 호출 성공");
		List<Map<String,Object>> accountList = null;
		String path = "";
		String mem_id = req.getParameter("mem_id");//조회버튼을 눌렀을 때|입력처리 후 결과 처리페이지인지
		logger.info("mem_id:"+mem_id);
		accountVO.setMem_id(mem_id);
		accountList = accountLogic.accountList(accountVO);
		model.addAttribute("accountList", accountList);
		//insert here - 응답페이지 호출 하기
		//jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
		//WebContent이면 반환타입은 String
		//WEB-INF이면 반환타입은 void, ModelAndView 이겠지.....
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("accountList", accountList);
		mav.setViewName("account/accountList");
		//path = "forward:./accountList.jsp";
		return mav;
		//return path;
	}
	@GetMapping("accountAdd")
	public ModelAndView accountAdd(@ModelAttribute AccountVO accountVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		logger.info("accountAdd 호출 성공");
		int accountAdd = 0;
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
		accountAdd = accountLogic.accountAdd(accountVO);
		model.addAttribute("accountAdd", accountAdd);
		//insert here - 응답페이지 호출 하기
		//jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
		//WebContent이면 반환타입은 String
		//WEB-INF이면 반환타입은 void, ModelAndView 이겠지.....
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("accountAdd", accountAdd);
		mav.setViewName("account/accountAdd");
		//path = "forward:./accountList.jsp";
		return mav;
	}
		

}



















