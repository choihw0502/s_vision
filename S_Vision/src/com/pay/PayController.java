package com.pay;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.util.HangulConversion;


@Controller
@RequestMapping(value="/pay/")
public class PayController {
	Logger logger = Logger.getLogger(PayController.class);
	@Autowired
	PayLogic payLogic = null;
	String path = "";
	String card_num = null;
	
	@RequestMapping(value = "payment", method = {RequestMethod.GET, RequestMethod.POST})
	public String payment(Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("payment 호출 성공");
		logger.info("card정보값"+pMap);
		model.addAttribute("cardInfo", pMap);
		path = "pay/payment";
		return path;
	}
	
	@RequestMapping(value = "paymentPW", method = {RequestMethod.GET, RequestMethod.POST})
	public String paymentPW(Model model, HttpServletResponse res, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("paymentPW 호출 성공");
		pMap.put("card_num","4077851424567894");
		card_num = pMap.get("card_num").toString();
		String card_pw = payLogic.card_pw(pMap);
		logger.info(card_pw);
		path = "pay/paymentPW";
		model.addAttribute("card_pw",card_pw);
		return path;
	}
	@RequestMapping(value = "store", method = {RequestMethod.GET, RequestMethod.POST})
	public String store(Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("storeInfo 호출 성공");
//		pMap.put("store_name", "GS칼텍스");
		if(pMap.get("store_name").equals("GS칼텍스")) {
			path="pay/GS";
		}else if(pMap.get("store_name").equals("CGV구로")) {
			path="pay/CGV";
		}else if(pMap.get("store_name").equals("starbucks")) {
			path="pay/starbucks";
		}else if(pMap.get("store_name").equals("뚜레쥬르가산디폴리스점")) {
			path="pay/tous";
		}
		logger.info(pMap);
		return path;
	}
	@RequestMapping(value = "complete", method = {RequestMethod.GET, RequestMethod.POST})
	public String complete(Model model, HttpServletRequest req,HttpServletResponse res, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info("complete 호출 성공");
		card_num = "3773461234576954";
		pMap.put("card_num",card_num);
		pMap.put("store_name", HangulConversion.toUTF(pMap.get("store_name").toString()));
		pMap.put("product", HangulConversion.toUTF(pMap.get("product").toString()));
//		pMap.put("amount", gmap.get("amount"));
		String paypw =payLogic.complete(pMap);
		String paypws[] = paypw.split("\0");
		paypw=paypw.replace('\0', '!');
		String chainno = paypws[0];
		logger.info(chainno);
		logger.info(paypw);
		int result=0;
		if(chainno!=null&&chainno.length()>0) {
			Cookie cook = new Cookie("bk_"+chainno,paypw);
			cook.setPath("/");
			cook.setMaxAge(60*60*10);
			res.addCookie(cook);
			result=payLogic.result();
		}
		model.addAttribute("complete",pMap);
		path="pay/complete";
		return path;
	}
	@RequestMapping(value = "info", method = {RequestMethod.GET, RequestMethod.POST})
	public String info(Model model, HttpServletRequest req, @RequestParam Map<String,Object> pMap) throws ServletException, IOException {
		logger.info(" 쿠키 값 확인하는 창 호출");
//		pMap.put("", );
//		pMap.put("", );
		model.addAttribute("idcard",pMap);
		path="pay/info";
		return path;
	}
}
