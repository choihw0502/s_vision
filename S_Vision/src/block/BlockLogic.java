package block;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockLogic {
	Logger logger = Logger.getLogger(BlockLogic.class);
	@Autowired
	BlockDao blockDao = null;
	Wellet wellet = new Wellet();
	
	public Map<String, Object> payMap(Map<String, Object> pMap) {
		logger.info("storeInfo 호출 성공");
		Map<String, Object> payMap = null;
		payMap = blockDao.cardInfo(pMap);
		return payMap;
	}
	public Map<String,Object> storeList(Map<String,Object> pMap){
		Map<String, Object> storeMap = null;
		pMap.put("store_name", wellet.storeName());
		logger.info("store_name"+pMap.get("store_name"));
		storeMap = blockDao.storeList(pMap);
		logger.info(Wellet.payList.get(0).get("store_name"));
		return storeMap;
	}

}
