package com.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String index(@ModelAttribute MemberVO memberVO,
							HttpServletRequest req,
							Model model) {
		path = "member/main";
		model.addAttribute("mem_id",null);
		return path;
		
	}
	@GetMapping("login")
	public String login(@ModelAttribute MemberVO memberVO,
							HttpServletRequest req,
							Model model) {
		this.session = req.getSession();
		if(session.getAttribute("mem_id")==null) {
			logger.info(req.getParameter("id"));
			logger.info(req.getParameter("password"));
			memberVO.setMem_id(req.getParameter("id"));
			memberVO.setMem_pw(req.getParameter("password"));
			path = memberLogic.login(memberVO);
			
			if(path.equals("member/main")) {
				this.session.setAttribute("mem_id", memberVO.getMem_id());
			}
		}
		else if(session.getAttribute("mem_id")!=null) {
			logger.info("이미 로그인중");
			String status = "1";
			this.session.setAttribute("status", status);
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
	public String crew(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		path = "member/crew";
		return path;
		
	}
	@GetMapping("logout")
	public String logout(@ModelAttribute MemberVO memberVO, HttpServletRequest req, Model model) {
		session.invalidate();
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
    public String check_id(HttpServletRequest req, Model model) {
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
