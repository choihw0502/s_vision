package com.membership;

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

import com.vo.CardVO;
import com.vo.MembershipVO;

@Controller
@RequestMapping(value="/membership/")
public class MembershipController {
	Logger logger = Logger.getLogger(MembershipController.class);
	MembershipLogic membershipLogic = null;
	public void setMembershipLogic(MembershipLogic membershipLogic) {
		this.membershipLogic = membershipLogic;
	}
	@GetMapping("mshipList")
	public ModelAndView mshipList(@ModelAttribute MembershipVO membershipVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("mshipList", mshipList);
		mav.setViewName("membership/mshipList");
		return mav;
	}
	@GetMapping("mshipHistory")
	public ModelAndView mshipHistory(@ModelAttribute MembershipVO membershipVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("mshipHistory", mshipHistory);
		mav.setViewName("membership/mshipHistory");
		return mav;
	}
	@GetMapping("mshipAdd")
	public ModelAndView mshipAdd(@ModelAttribute MembershipVO membershipVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("mshipAdd", mshipAdd);
		mav.setViewName("membership/mshipAdd");
		return mav;
	}
	@GetMapping("mshipBenefit")
	public ModelAndView mshipBenefit(@ModelAttribute MembershipVO membershipVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("mshipBenefit", mshipBenefit);
		mav.setViewName("membership/mshipBenefit");
		return mav;
	}
}
