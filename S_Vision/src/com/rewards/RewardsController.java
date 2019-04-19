package com.rewards;

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

import com.vo.RewardsVO;



@Controller
@RequestMapping(value="/rewards/")
public class RewardsController {
	Logger logger = Logger.getLogger(RewardsController.class);
	@Autowired
	RewardsLogic rewardsLogic = null;
	
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
	@ResponseBody
	@RequestMapping(value = "exCoupon", method = {RequestMethod.GET,RequestMethod.POST})
	public int exCoupon(@RequestParam Map<String,Object> pMap, Model model, HttpServletRequest req) throws ServletException, IOException {
		logger.info("쿠폰샵 호출성공");
		
		HttpSession session = req.getSession();
		String path ="";
		String mem_id = (String)session.getAttribute("mem_id");
		pMap.put("mem_id",mem_id);
		logger.info(pMap);
		int exCoupon =  rewardsLogic.exCoupon(pMap);
		//List<Map<String, Object>> couponInven = rewardsLogic.exCoupon(pMap);
		
		//model.addAttribute("couponInven",couponInven);
		//path = "rewards/exCoupon";
		return exCoupon;
	}
	@RequestMapping(value = "couponInven", method = {RequestMethod.GET,RequestMethod.POST})
	public String couponInven(@RequestParam Map<String,Object> pMap, Model model, HttpServletRequest req) throws ServletException, IOException {
		logger.info("쿠폰함 호출성공");
		
		HttpSession session = req.getSession();
		String path ="";
		String mem_id = (String)session.getAttribute("mem_id");
		pMap.put("mem_id",mem_id);
		logger.info(pMap);
		List<Map<String, Object>> couponInven = rewardsLogic.couponInven(pMap);
		
		model.addAttribute("couponInven",couponInven);
		path = "rewards/exCoupon";
		return path;
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
	//쿠폰 목록보기 화면으로 이동 처리
	@GetMapping("exCouponView")
	public String exCouponView()throws ServletException
	{
		logger.info("exCouponView 호출 성공");
		return "rewards/exCoupon";
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

	@GetMapping("pointSave")
	public ModelAndView pointSave(@RequestParam Map<String,Object> pMap , Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("pointSave", pointSave);
		mav.setViewName("rewards/pointSave");
		return mav;
	}

	@RequestMapping(value = "couponShop", method = {RequestMethod.GET,RequestMethod.POST})
	public String couponShop(@RequestParam Map<String,Object> pMap, Model model, HttpServletRequest req) throws ServletException, IOException {
		logger.info("쿠폰샵 호출성공");
		HttpSession session = req.getSession();
		String path ="";
		String mem_id = (String)session.getAttribute("mem_id");
		pMap.put("mem_id",mem_id);
		List<Map<String,Object>> couponShop = rewardsLogic.couponShop(pMap);
		
		model.addAttribute("couponShop",couponShop);
		path = "rewards/couponShop";
		return path;
	}
}
