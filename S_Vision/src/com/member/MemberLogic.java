package com.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.MemberVO;

@Service
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	@Autowired
	MemberDao memberDao = null;
	
	public List<Map<String, Object>> login(MemberVO mbVO) {
		Map<String, Object> logMap = new HashMap<String,Object>();
		mbVO.setMem_id("elesex");
		mbVO.setMem_pw("12345");
		
		return null;
	}
	

}
