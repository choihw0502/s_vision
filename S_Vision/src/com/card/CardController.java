package com.card;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vo.CardVO;

@Controller
@RequestMapping(value="/card/")
public class CardController {
	Logger logger = Logger.getLogger(CardController.class);
	@Autowired
	CardLogic cardLogic = null;
	@GetMapping("cardList")
	public ModelAndView cardList(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("cardList", cardList);
		mav.setViewName("card/cardList");
		return mav;
	}
	@GetMapping("cardUseList")
	public ModelAndView cardUseList(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("cardUseList", cardUseList);
		mav.setViewName("card/cardUseList");
		return mav;
	}
	@GetMapping("cardAdd")
	public ModelAndView cardAdd(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		//insert here
		//메소드이름으로 알맞게 타입정하고
		//메소드이름=로직.같은이름메소드(VO or 본인이 정해서);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("cardAdd", cardAdd);
		mav.setViewName("card/cardAdd");
		return mav;
	}
		

}



















