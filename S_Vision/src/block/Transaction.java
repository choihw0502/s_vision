package block;

import java.util.HashMap;
import java.util.Map;

public class Transaction {
	String mem_id  =null;
	String store_name =null; 
	int amount = 0;
//결제 insert가 진행될때 값 저장
	public Transaction(String mem_id, String store_name, int amount) {
		this.mem_id = mem_id;
		this.store_name=store_name;
		this.amount = amount;
	}
}
