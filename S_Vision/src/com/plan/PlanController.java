package com.plan;

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

import com.vo.MembershipVO;
import com.vo.PlanVO;

@Controller
@RequestMapping(value="/plan/")
public class PlanController {
	Logger logger = Logger.getLogger(PlanController.class);
	PlanLogic planLogic = null;
	public void setPlanLogic(PlanLogic planLogic) {
		this.planLogic = planLogic;
	}
	@GetMapping("spendingMonth")
	public ModelAndView spendingMonth(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("spendingMonth", spendingMonth);
		mav.setViewName("plan/spendingMonth");
		return mav;
	}
	@GetMapping("spendingCategory")
	public ModelAndView spendingCategory(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("spendingCategory", spendingCategory);
		mav.setViewName("plan/spendingCategory");
		return mav;
	}
	@GetMapping("payMethod")
	public ModelAndView payMethod(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("payMethod", payMethod);
		mav.setViewName("plan/payMethod");
		return mav;
	}
	@GetMapping("spendingStore")
	public ModelAndView spendingStore(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("spendingStore", spendingStore);
		mav.setViewName("plan/spendingStore");
		return mav;
	}
	@GetMapping("total_Month")
	public ModelAndView total_Month(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("total_Month", total_Month);
		mav.setViewName("plan/total_Month");
		return mav;
	}
	@GetMapping("total_Week")
	public ModelAndView total_Week(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("total_Week", total_Week);
		mav.setViewName("plan/total_Week");
		return mav;
	}
	@GetMapping("total_Day")
	public ModelAndView total_Day(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("total_Day", total_Day);
		mav.setViewName("plan/total_Day");
		return mav;
	}
	@GetMapping("spendingList")
	public ModelAndView spendingList(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("spendingList", spendingList);
		mav.setViewName("plan/spendingList");
		return mav;
	}
	@GetMapping("total_Budget")
	public ModelAndView total_Budget(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("total_Budget", total_Budget);
		mav.setViewName("plan/total_Budget");
		return mav;
	}
	@GetMapping("card_Budget")
	public ModelAndView card_Budget(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("card_Budget", card_Budget);
		mav.setViewName("plan/card_Budget");
		return mav;
	}
	@GetMapping("otherUsersSpending")
	public ModelAndView otherUsersSpending(@ModelAttribute PlanVO planVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("otherUsersSpending", otherUsersSpending);
		mav.setViewName("plan/otherUsersSpending");
		return mav;
	}

}
