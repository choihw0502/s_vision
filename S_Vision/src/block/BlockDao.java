package block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.BrandVO;
import com.vo.CreditcardVO;

public class BlockDao {
	Logger logger = Logger.getLogger(BlockDao.class);
	
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<Map<String, Object>> storeList(BrandVO brandVO) {
		logger.info("storList 호출 성공");
		List<Map<String, Object>> storeInfo = new ArrayList<Map<String,Object>>();
		storeInfo = sqlSessionTemplate.selectList("storeInfo",brandVO);
		return storeInfo;
	}

	public List<Map<String, Object>> cardInfo(CreditcardVO creditcardVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
