package com.card;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vo.CardVO;

@Controller
@RequestMapping(value="/card/")
public class CardController {

	Logger logger = Logger.getLogger(CardController.class);
	@Autowired
	CardLogic cardLogic = null;
	@GetMapping("card")
	public String cardAllList(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path ="";
		String mem_id = (String)session.getAttribute("mem_id");
		cardVO.setMem_id(mem_id);
		logger.info(mem_id);
		List<Map<String,Object>> cardAllList = cardLogic.cardAllList(cardVO);
		List<Map<String,Object>> allCard = cardLogic.allCard(cardVO);
		logger.info(allCard);
		//String mem_id = req.getParameter("mem_id");
		cardVO.setMem_id(mem_id);
		model.addAttribute("cardAllList", cardAllList);
		model.addAttribute("allCard", allCard);
		path = "card/card";
		
		return path;
	}
	public String detail_card(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException{
		logger.info("detail카드 호출성공");
		String path ="";
		List<Map<String,Object>> detail_card= null;
		detail_card=cardLogic.detail_card(cardVO);
		model.addAttribute("detail_card", detail_card);
		path = "card/card";
		
	return path;	
	}
	@RequestMapping(value = "allCard", method = RequestMethod.POST)
	public String allCard(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req)throws ServletException, IOException{
	logger.info("allCard 호출 성공");
	List<Map<String,Object>> allCard = null;
	String path = "";
	allCard = cardLogic.allCard(cardVO);
	model.addAttribute("allCard", allCard);
	path = "card/card";
	return path;
	}
	@GetMapping("cardList")
	public ModelAndView cardList(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException {
		cardVO.setP_mem_id(req.getParameter("mem_id"));
		//insert here
		//메소드이름으로 알맞게 타입정하고		
		//메소드이름=로직.같은이름메소드(VO);
	List<Map<String,String>> cardList = cardLogic.cardList(cardVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cardList", cardList);
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
	@ResponseBody
  @RequestMapping(value = "cardAdd", method = RequestMethod.POST)
   public int cardAdd(@ModelAttribute CardVO cardVO, Model model, HttpServletRequest req) throws ServletException, IOException {
      logger.info("cardAdd 나옴");
      
      Map<String,Object>pMap = new HashMap<String,Object>();
      pMap.put("P_MEM_ID",req.getParameter("mem_id"));
      pMap.put("P_CARD_NUM",req.getParameter("cardnum"));
      logger.info(req.getParameter("mem_id"));
   
      int result = cardLogic.cardAdd(pMap);
      logger.info(result);
      return result;
   }
      

}


















