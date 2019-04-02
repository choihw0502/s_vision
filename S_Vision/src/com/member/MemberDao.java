package com.member;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> login(MemberVO memberVO) {
		logger.info("다오호출성공");
		List<Map<String, Object>> login = new ArrayList<Map<String,Object>>();
		login = sqlSessionTemplate.selectList("login",memberVO);
		logger.info(login);
		return login;
	}
	public int check_id(String id) {
		int rowcount = sqlSessionTemplate.selectOne("check_id",id);
		return rowcount;
	}
	public int join(Map<String, Object> pMap) {
		sqlSessionTemplate.insert("proc_register",pMap);
		int result = (Integer)pMap.get("R_RESULT");
		return result;
	}

}
