package block;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;


public class Block {
	String openKey;
	String timestamp;
	List<Transaction> tList = new ArrayList<Transaction>();
	String hash;
	int nonce;
	
	public Block(List<Transaction> tList, String key) {
		this.openKey = key;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		this.timestamp = date.format(today);
		this.tList = tList;
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		return DigestUtils.sha256Hex(openKey+timestamp+tList+nonce);
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}
