package block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

//DB에서 불러낸 정보와 결제가 일어날때의 비교 및 결제내역에 뿌리기 위한 정보 위한 지갑 생성
public class Wellet {
	Logger logger = Logger.getLogger(Wellet.class);
	public static List<Map<String,Object>> payList  = new ArrayList<Map<String,Object>>();		//결제 내역 - to가 from에게 보낸 정보
	String store_name;
	
	public String storeName() {
		String store_name="";
		if(payList.size()!=0) {
			for(int i=0;i<payList.size();i++) {
				store_name = (String)payList.get(i).get("store_name");
			}
		}else {
			return store_name;
		}
		return store_name;
	}
}
