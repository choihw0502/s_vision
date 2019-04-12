package block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;


public class BlockDao {
	Logger logger = Logger.getLogger(BlockDao.class);
	
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public Map<String, Object> cardInfo(Map<String, Object> pMap) {
		logger.info("storList 호출 성공");
		Map<String, Object> storeInfo = new HashMap<String, Object>();
		storeInfo = sqlSessionTemplate.selectOne("cardInfo",pMap);
		logger.info(storeInfo);
		return storeInfo;
	}
	
	public Map<String, Object> storeList(Map<String, Object> pMap) {
		logger.info("storList 호출 성공");
		logger.info(pMap.get("store_name"));
		Map<String, Object> map = new HashMap<String, Object>();
		map = sqlSessionTemplate.selectOne("storeInfo",pMap);
		logger.info(map);
		return map;
	}


	public Map<String, Object> payList(Map<String, Object> pMap) {
		logger.info("storList 호출 성공");
		Map<String, Object> cardInfo = new HashMap<String, Object>();
		cardInfo = sqlSessionTemplate.selectOne("cardInfo",pMap);
		logger.info(cardInfo);
		return cardInfo;
	}

}
