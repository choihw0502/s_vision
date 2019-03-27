package com.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;
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
import com.vo.MemberVO;

@Controller
@RequestMapping(value="/member/")
public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	private MemberLogic memberLogic = null;
	//멤버는 나중에 해야댈듯
	
	@GetMapping("login")
	public String login(@ModelAttribute MemberVO mbVO,
							HttpServletRequest request,
							Model model) {
		logger.info("login 호출 성공");
		List<Map<String,Object>> login = memberLogic.login(mbVO);
		String path = "";
		String gubun = request.getParameter("gubun");//조회버튼을 눌렀을 때 | 입력처리 후 결과 처리페이지 인지 결정
		model.addAttribute("login",login);
//		jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
//		WebContent이면 반환타입은 String
//		WEB-INF이면 반환타입은 void, ModelAndView
		if("INS".equals(gubun)) {
			path = "forward:./boardList.jsp";
		}else {
			path = "forward:./jsonBoardList.jsp";
		}
		return path;
		
	}
	@GetMapping("memberFind")
	public String memberFind(@ModelAttribute MemberVO mbVO,
							HttpServletRequest request,
							Model model) {
								return null;
		
	}
	@GetMapping("memberList")
	public String memberIns(@ModelAttribute MemberVO mbVO,
							HttpServletRequest request,
							Model model) {
								return null;
		
	}
}
