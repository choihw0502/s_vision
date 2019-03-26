package com.recommend;

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

import com.vo.PlanVO;
import com.vo.RecommendVO;

@Controller
@RequestMapping(value="/recommend/")
public class RecommendController {
	Logger logger = Logger.getLogger(RecommendController.class);
	RecommendLogic recommendLogic = null;
	public void setRecommendLogic(RecommendLogic recommendLogic) {
		this.recommendLogic = recommendLogic;
	}
	@GetMapping("allCards")
	public ModelAndView otherUsersSpending(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("allCards", allCards);
		mav.setViewName("recommend/allCards");
		return mav;
	}
	@GetMapping("eatCard")
	public ModelAndView eatCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("eatCard", eatCard);
		mav.setViewName("recommend/eatCard");
		return mav;
	}
	@GetMapping("communityCard")
	public ModelAndView communityCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("communityCard", communityCard);
		mav.setViewName("recommend/communityCard");
		return mav;
	}
	@GetMapping("cultureCard")
	public ModelAndView cultureCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("cultureCard", cultureCard);
		mav.setViewName("recommend/cultureCard");
		return mav;
	}
	@GetMapping("tripCard")
	public ModelAndView tripCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("tripCard", tripCard);
		mav.setViewName("recommend/tripCard");
		return mav;
	}
	@GetMapping("convenCard")
	public ModelAndView convenCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("convenCard", convenCard);
		mav.setViewName("recommend/convenCard");
		return mav;
	}
	@GetMapping("oilCard")
	public ModelAndView oilCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("oilCard", oilCard);
		mav.setViewName("recommend/oilCard");
		return mav;
	}
	@GetMapping("myRecommendCard")
	public ModelAndView myRecommendCard(@ModelAttribute RecommendVO recommendVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("myRecommendCard", myRecommendCard);
		mav.setViewName("recommend/myRecommendCard");
		return mav;
	}

}
