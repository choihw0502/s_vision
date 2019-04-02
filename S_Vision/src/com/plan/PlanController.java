package com.plan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.vo.PlanVO;

@Controller
@RequestMapping(value="/plan/")
public class PlanController {
	Logger logger = Logger.getLogger(PlanController.class);
	@Autowired
	PlanLogic planLogic = null;
	
	@GetMapping("spendingMonth")//URL예시 : http://localhost:9000/plan/spendingMonth?mem_id=Piper Rich&month=20190101
	public ModelAndView spendingMonth(@ModelAttribute PlanVO planVO) throws ServletException, IOException {
		//날짜별 사용금액 
		//파라미터로 아이디값을 받는다.
		//6개월 지출과 평균 지출을 뽑아준다.
		logger.info("spendingMonth 호출 성공");
		ModelAndView mav = new ModelAndView();
		planVO.setMem_id("Nicole Sears");
		List<Map<String, Object>> r_result = planLogic.spendingMonth(planVO);
		
		String [] r_ever = r_result.get(0).get("R_EVER").toString().split("/");
		logger.info("r_ever.length : "+r_ever.length); Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		int y = 1; 
		for(int i=1;i<r_ever.length;i++) {
		
			logger.info("y : "+y+" , r_ever[i] : "+r_ever[i]); map = new
			HashMap<Object,Object>(); map.put("x", y); map.put("y",
			Integer.parseInt(r_ever[i])); list.add(map); y = y+2; 
		}
		mav.addObject("r_ever", list); String [] r1 = r_result.get(0).get("R1").toString().split("/");
		logger.info("r_ever.length : "+r1.length); list = new
		ArrayList<Map<Object,Object>>(); y = 1; for(int i=1;i<r1.length;i++) {
		
		map = new HashMap<Object,Object>(); map.put("x", y); map.put("y",
		Integer.parseInt(r1[i])); list.add(map); y = y+2;
		
		} mav.addObject("r1", list); mav.setViewName("plan/spendingMonth");
		
		return mav;
	}

	@GetMapping("spendingCategory")
	public ModelAndView spendingCategory(@ModelAttribute PlanVO planVO) throws ServletException, IOException {
		//카테고리별 지출 리스트
		//원하는 달과 아이디 값을 받는다.
		//R1~R6 : 건수
		//R7~R12 : 합계금액
		// 교통 01 09 10
		// 편의점 및 마트 08 14
		// 건강 및 의료 16 17
		// 외식 03
		// 커피 및 디저트 11
		// 생활 04 12 13
		// 쇼핑 15 19
		// 뷰티 18
		// 레저 및 여가 생활 02 05 06 07 20
		// 기타 00 
		logger.info("spendingCategory 호출 성공");
		ModelAndView mav = new ModelAndView();
		planVO.setMem_id("Nicole Sears");
		List<Map<String, Object>> r_result = planLogic.spendingCategory(planVO);
		String [] r1 = r_result.get(0).get("R_SUM1").toString().split("/");
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		
		int sumpri = 0;
		for(int i=1;i<r1.length;i++) {
			
			if(!"0".equals(r1[i])) {
				
				switch(i) {
				case 1 :
					map = new HashMap<Object,Object>(); 
					map.put("label", "교통"); 
					map.put("y",  Integer.parseInt(r1[i])); 
					list.add(map);
						break;
				case 2 :
						map = new HashMap<Object,Object>(); map.put("label", "편의점 및 마트"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 3 :
						map = new HashMap<Object,Object>(); map.put("label", "건강 및 의료"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
				
						break;
				case 4 :
						map = new HashMap<Object,Object>(); map.put("label", "외식"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 5 :
						map = new HashMap<Object,Object>(); map.put("label", "커피 및 디저트"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 6 :
						map = new HashMap<Object,Object>(); map.put("label", "생활"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 7 :
						map = new HashMap<Object,Object>(); map.put("label", "쇼핑"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 8 :
						map = new HashMap<Object,Object>(); map.put("label", "뷰티"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 9 :
						map = new HashMap<Object,Object>(); map.put("label", "레저 및 여가싱활"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				case 10 :
						map = new HashMap<Object,Object>(); map.put("label", "기타"); map.put("y", Integer.parseInt(r1[i])); list.add(map);
						break;
				}////////////////////////////////////////end case;
				sumpri = sumpri+Integer.parseInt(r1[i]);
			}////////////////////////////////////////////end if;
			}//end of for;
		String center = "";
		logger.info("list.size : "+list.size());
		if(list.size() == 0) {
			map = new HashMap<Object,Object>(); map.put("label", "지출 없음"); map.put("y", 0); list.add(map);
			center="지출 없음";
		}else {
			center=Integer.toString(sumpri);
		}
		mav.addObject("center", center);
		mav.addObject("r1", list);
		mav.setViewName("plan/spendingCategory");
		return mav;
	}
	@GetMapping("spendingStore")
	public ModelAndView spendingStore(@ModelAttribute PlanVO planVO) throws ServletException, IOException {
		//매장별 지출 (결제 많은순(건 기준) | 지출순(지출합계기준))
		//이것도 6개월치를 뽑아야 한다.
		planVO.setMem_id("Xander Livingston");
		planVO.setP_date("20190305");
		planVO = planLogic.spendingStore(planVO);
		List<Map<String,Object>> r_result = planVO.getR_result();
		List<Map<String,Object>> r_result1 = planVO.getR_result();
		Object[] keys =  r_result.get(0).keySet().toArray();
		for(Object key: keys) {
			
			logger.info("합계순 : key값 : "+key+" , value 값 : "+r_result.get(0).get(key) );
			logger.info("건수순 : key값 : "+key+" , value 값 : "+r_result1.get(0).get(key) );
		}
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("spendingStore", spendingStore);
		mav.setViewName("plan/spendingStore");
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
	public ModelAndView total_Week(@ModelAttribute PlanVO planVO) throws ServletException, IOException {
		//총지출내역(주)
		logger.info("total_Week 호출 성공");
		planVO.setMem_id("Xander Livingston");
		List<Map<String, Object>> r_result = planLogic.total_Week(planVO);
		ModelAndView mav = new ModelAndView();
		String[] r_cnt = r_result.get(0).get("R_CNT1").toString().split("/");
		logger.info("r_cnt.length : " + r_cnt.length);
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		String day = "";
		for (int i = 0; i < r_cnt.length; i++) {

			switch(i) {
				case 0:
					day="일요일";
				break;
				case 1:
					day="월요일";
				break;
				case 2:
					day="화요일";
					break;
				case 3:
					day="수요일";
					break;
				case 4:
					day="목요일";
					break;
				case 5:
					day="금요일";
					break;
				case 6:
					day="토요일";
					break;
			}
			logger.info("day : " + day + " , r_cnt[i] : " + r_cnt[i]);
			map = new HashMap<Object, Object>();
			map.put("label", day);
			map.put("y", Integer.parseInt(r_cnt[i]));
			list.add(map);
			
		}
		mav.addObject("r_cnt", list);
		String[] r_sum = r_result.get(0).get("R_SUM1").toString().split("/");
		logger.info("r_sum.length : " + r_sum.length);
		list = new ArrayList<Map<Object, Object>>();
		
		for (int i = 0; i < r_sum.length; i++) {

			switch(i) {
			case 0:
				day="일요일";
			break;
			case 1:
				day="월요일";
			break;
			case 2:
				day="화요일";
				break;
			case 3:
				day="수요일";
				break;
			case 4:
				day="목요일";
				break;
			case 5:
				day="금요일";
				break;
			case 6:
				day="토요일";
				break;
		}
			logger.info("day : " + day + " , r_sum[i] : " + r_sum[i]);
			map = new HashMap<Object, Object>();
			map.put("label", day);
			map.put("y", Integer.parseInt(r_sum[i]));
			list.add(map);

		}
		mav.addObject("r_sum", list);
		mav.setViewName("plan/total_Week");
		return mav;
	}
	@GetMapping("total_Day")
	public ModelAndView total_Day(@ModelAttribute PlanVO planVO) throws ServletException, IOException {
		//총지출내역(일 - 시간별)
		logger.info("total_Day 호출 완료");
		planVO.setMem_id("Nicole Sears");
		List<Map<String, Object>> r_result = planLogic.total_Day(planVO);
		ModelAndView mav = new ModelAndView();
		String[] r_cnt = r_result.get(0).get("R_CNT1").toString().split("/");
		logger.info("r_cnt.length : " + r_cnt.length);
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		int y = 2;
		for (int i = 0; i < r_cnt.length; i++) {

			logger.info("y : " + y + " , r_cnt[i] : " + r_cnt[i]);
			map = new HashMap<Object, Object>();
			map.put("x", y);
			map.put("y", Integer.parseInt(r_cnt[i]));
			list.add(map);
			y = y + 2;
		}
		mav.addObject("r_cnt", list);
		String[] r_sum = r_result.get(0).get("R_SUM1").toString().split("/");
		logger.info("r_sum.length : " + r_sum.length);
		list = new ArrayList<Map<Object, Object>>();
		y = 2;
		for (int i = 0; i < r_sum.length; i++) {
			
			logger.info("y : " + y + " , r_sum[i] : " + r_sum[i]);
			map = new HashMap<Object, Object>();
			map.put("x", y);
			map.put("y", Integer.parseInt(r_sum[i]));
			list.add(map);
			y = y + 2;

		}
		mav.addObject("r_sum", list);
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
