package block;

import java.util.ArrayList;
import java.util.List;

public class testsimulation {

	public static void main(String[] args) {
		String to = "me";
		String from = "you";
		int pay = 10000;
		String key = "asdnkasdfl";
		List<Transaction> tList = new ArrayList<Transaction>();
		Transaction tr = new Transaction(to, from, pay);
		tList.add(tr);
		Block bl = new Block(tList,key);
		key=bl.calculateHash();
		System.out.println(key);
	}

}
