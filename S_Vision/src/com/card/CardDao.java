package com.card;

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

import com.recommend.RecommendDao;
import com.util.MyBatisCommonFactory;
import com.vo.CardVO;
import com.vo.RecommendVO;

public class CardDao {
	Logger logger = Logger.getLogger(CardDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String,String>> cardList(CardVO cardVO){
		  String p_mem_id = cardVO.getP_mem_id();	
		  List<Map<String,String>> cardList = new ArrayList<Map<String,String>>();
		  System.out.println(cardVO.getR_list());
		  sqlSessionTemplate.selectList("cardList",cardVO);
		  System.out.println(cardVO.getR_list());
		  cardList.add(cardVO.getR_list().get(0));
		  return cardList;
	}
	public int cardAdd(Map<String, Object> pMap) {
		int result=sqlSessionTemplate.insert("cardAdd",pMap);
		return result;
	}

}
