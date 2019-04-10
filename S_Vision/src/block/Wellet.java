package block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DB에서 불러낸 정보와 결제가 일어날때의 비교 및 결제내역에 뿌리기 위한 정보 위한 지갑 생성
public class Wellet {
	public static List<Map<String,Object>> cardInfo = null;		//회원 카드의 정보 - to지갑
	public static List<Map<String,Object>> storeInfo = null; 	//브랜드의 정보 - from지갑
	public static List<Map<String,Object>> payList  = null;		//결제 내역 - to가 from에게 보낸 정보
	
//카드 번호에 대한 결제내역 뿌리기
	public static Map<String,Object> memPayList(String card_num){
		Map<String,Object> myList = new HashMap<String,Object>();
		if(payList!=null) {
			for(int i=0;i<payList.size();i++) {
				if(card_num.equals(payList.get(0).get("card_num"))) {
					myList = payList.get(i);
				}
			}
			return myList;
		}else {
			return null;
		}
	}
}
