package com.rewards;

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

import com.vo.RewardsVO;



@Controller
@RequestMapping(value="/rewards/")
public class RewardsController {
	Logger logger = Logger.getLogger(RewardsController.class);
	@Autowired
	RewardsLogic rewardsLogic = null;
	public void setRewardsLogic(RewardsLogic rewardsLogic) {
		this.rewardsLogic = rewardsLogic;
	}
	@GetMapping("myPoint")
	public ModelAndView myPoint(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		rewardsVO.setMem_id(req.getParameter("mem_id"));
		int myPoint = 0;
		myPoint = rewardsLogic.myPoint(rewardsVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("myPoint", myPoint);
		mav.setViewName("rewards/myPoint");
		return mav;
	}
	@GetMapping("exCoupon")
	public ModelAndView exCoupon(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("exCoupon", exCoupon);
		mav.setViewName("rewards/exCoupon");
		return mav;
	}
	@GetMapping("recentPoint")
	public ModelAndView recentPoint(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("recentPoint", recentPoint);
		mav.setViewName("rewards/recentPoint");
		return mav;
	}
	@GetMapping("removePoint")  
	public ModelAndView removePoint(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("removePoint", removePoint);
		mav.setViewName("rewards/removePoint");
		return mav;
	}
	@GetMapping("myCoupon")
	public ModelAndView myCoupon(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("myPoint", myCoupon);
		mav.setViewName("rewards/myCoupon");
		return mav;
	}
	@GetMapping("couponShop")
	public ModelAndView couponShop(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("couponShop", couponShop);
		mav.setViewName("rewards/couponShop");
		return mav;
	}
	@GetMapping("pointSave")
	public ModelAndView pointSave(@ModelAttribute RewardsVO rewardsVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("pointSave", pointSave);
		mav.setViewName("rewards/pointSave");
		return mav;
	}
	

}
