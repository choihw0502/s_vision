package com.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.util.HangulConversion;
import com.vo.MemberVO;

@Controller
@RequestMapping(value="/member/" , method = {RequestMethod.GET, RequestMethod.POST})
public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);
	@Autowired
	MemberLogic memberLogic = null;
	HttpSession session = null;
	String path = "";
	@GetMapping("index")
	public String index(@RequestParam Map<String,Object> pMap, HttpServletRequest req,	Model model) {
		path = "member/main";
	
	
		return path;
		
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> pMap, HttpServletRequest req,	Model model) {
		if(pMap.get("mem_id")==null) {
			path = "member/login";
		}
		else if(pMap.get("mem_id")!=null) {
			Map<String,Object> login = memberLogic.login(pMap);
			session = req.getSession();
			if(login.get("MEM_ID")!=null) {
				path = "member/main";
				String r_card = String.valueOf(login.get("R_CARD"));
				String r_account = String.valueOf(login.get("R_ACCOUNT"));
				String r_point = String.valueOf(login.get("R_POINT"));
				String r_mship = String.valueOf(login.get("R_MSHIP"));
				String mem_id = (String)login.get("MEM_ID");
				session.setAttribute("mem_id", mem_id);
				session.setAttribute("r_card", r_card);
				session.setAttribute("r_account", r_account);
				session.setAttribute("r_point", r_point);
				session.setAttribute("r_mship", r_mship);
			}
			else if(login.get("MEM_ID")==null) {
				req.setAttribute("mem_id", null);
				path = "member/login";
			}
		}
		return path;
	}		
	@GetMapping("register")
	public String register(@ModelAttribute MemberVO memberVO,
							HttpServletRequest req,
							Model model) {
		path = "member/register";
		return path;
	}
	@GetMapping("crew")
	public String crew(@RequestParam Map<String,Object> pMap, HttpServletRequest req,	Model model) {
		path = "member/crew";
		return path;
		
	}
	@GetMapping("logout")
	public String logout(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		session = req.getSession();
		if(session.getAttribute("mem_id")!=null) {
			session.invalidate();
		}
		else if(session.getAttribute("mem_id")==null) {
		}
		path = "member/main";
		return path;
		
	}	
	@ResponseBody
    @RequestMapping(value = "join", method = RequestMethod.POST)
	public String memberIns(@ModelAttribute MemberVO memberVO,
							HttpServletRequest req,
							Model model) {
		
			logger.info("join호출");
			memberVO.setMem_id(req.getParameter("mem_id"));
			memberVO.setMem_pw(req.getParameter("mem_pw"));
			memberVO.setMem_addr(req.getParameter("mem_addr1")+req.getParameter("mem_addr2"));
			memberVO.setMem_birthday(req.getParameter("mem_birth"));
			memberVO.setMem_email(req.getParameter("mem_email"));
			memberVO.setMem_name(req.getParameter("mem_name"));
			memberVO.setMem_phone(req.getParameter("phon1")+"-"+req.getParameter("phon2")+"-"+req.getParameter("phon3"));
			if(req.getParameter("chk_info").equals("남")) {
				memberVO.setMem_gen("1");
			}
			else if(req.getParameter("chk_info").equals("여")) {
				memberVO.setMem_gen("0");
			}
//			logger.info(memberVO.getMem_id());
//			logger.info(memberVO.getMem_pw());
//			logger.info(memberVO.getMem_birthday());
//			logger.info(memberVO.getMem_email());
//			logger.info(memberVO.getMem_gen());
//			logger.info(memberVO.getMem_name());
//			logger.info(memberVO.getMem_phone());
//			logger.info(memberVO.getMem_addr());
			int result = memberLogic.join(memberVO);
			logger.info(result);
			return String.valueOf(result);
		
	}
	@ResponseBody
    @RequestMapping(value = "check_id", method = RequestMethod.POST)
    public String check_id(@RequestParam Map<String,Object> pMap, HttpServletRequest req, Model model) {
        String id = req.getParameter("mem_id");
        logger.info(id);
        int rowcount = memberLogic.check_id(id);
        return String.valueOf(rowcount);
    }
	@GetMapping("account")
	public String account(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		path = "account/account";
		return path;
	}	
	@GetMapping("card")
	public String card(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		path = "card/card";
		return path;
	}	
	@GetMapping("recommend")
	public String recommend(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		path = "recommend/recommend";
		return path;
	}	
	@GetMapping("plan")
	public String plan(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		path = "plan/plan";
		return path;
	}	
	@GetMapping("rewards")
	public String rewards(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		path = "rewards/rewards";
		return path;
	}
		


}
