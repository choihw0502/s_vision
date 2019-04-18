package block;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;


public class Block {
	String openKey;
	String timestamp;
	Map<String,Object> tList = new HashMap<String,Object>();
	String hash;
	int nonce;
	
	public Block(Map<String,Object> tList, String key) { //파라미터 string 브랜드 or 회원 pk
		this.openKey = key;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		this.timestamp = date.format(today);
		this.tList = tList;
		this.hash = calculateHash();
	}
	
	//회원or브랜드 pk , 거래되는 현재 시간 , 보내는사람(회원) , 받는사람(브랜드) , 금액 , 
	public String calculateHash() {
		return DigestUtils.sha256Hex(openKey+timestamp+tList);
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
		System.out.println("target 정보 : "+target);
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	

}
