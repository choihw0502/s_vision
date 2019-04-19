package block;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BrandVO;
import com.vo.CreditcardVO;

@Service
public class BlockLogic {
	Logger logger = Logger.getLogger(BlockLogic.class);
	@Autowired
	BlockDao blockDao = null;
	
	public List<Map<String, Object>> storeInfo(BrandVO brandVO) {
		logger.info("storeInfo 호출 성공");
		List<Map<String, Object>> storeInfo = blockDao.storeList(brandVO);
		return storeInfo;
	}

	public List<Map<String, Object>> cardInfo(CreditcardVO creditcardVO) {
		logger.info("storeInfo 호출 성공");
		List<Map<String, Object>> cardInfo = blockDao.cardInfo(creditcardVO);
		return cardInfo;
	}

	public List<Map<String, Object>> payMent(Transaction tr) {
		// TODO Auto-generated method stub
		return null;
	}

}
