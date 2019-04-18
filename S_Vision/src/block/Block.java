package block;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;


public class Block {
	List<Transaction> tList = new ArrayList<Transaction>();
	Map<String,Object> map = new HashMap<String,Object>();
	String openKey;
	String timestamp;
	String hash;
	
	public Block(Map<String,Object> pMap, String key) { //거래에 대한 hash값 이전 거래
		this.openKey = key;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("|yyyy/MM/dd|hh:mm:ss a|");
		this.timestamp = date.format(today);
		this.hash = calculateHash();
	}
	//카드번호or브랜드 pk , 거래되는 현재 시간 , 보내는사람(카드번호) , 받는사람(브랜드) , 금액 , 
	public String calculateHash() {
		for(int i=0;i<tList.size();i++) {
			tList.get(i);
			System.out.println(tList.get(i).info);
			if(tList.get(i).info.get("from")=="me") {
				map = tList.get(i).info;
			}
			else {
				System.out.println("회원정보가 틀림 Block 생성 실패");
				return null;
			}
		}
		System.out.println(openKey+timestamp+map);
		return DigestUtils.sha256Hex(openKey+timestamp+map);
	}
	public static void main(String[] args) {
		String from = "me";
		String to = "your";
		int amount = 2500;
		String key = "";
		Transaction tr = new Transaction(from,to,amount);
		List<Transaction> tt = new ArrayList<Transaction>();
		tt.add(tr);
		Block bl = new Block(tt,key);
		System.out.println(bl.hash);
	}
}
