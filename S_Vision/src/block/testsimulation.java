package block;

import java.util.ArrayList;
import java.util.List;

public class testsimulation {

	public static void main(String[] args) {
		String to = "me";				// 보내는 사람 	: 나(회원)
		String from = "you";			// 받는 사람	: 너(브랜드)
		int pay = 10000;				// 보낼 금액 	: 10000
		String mem = "최형원";			// 
		String brand = "CJ푸드빌";
		List<Transaction> tList = new ArrayList<Transaction>();
//		============================================================================
		Transaction tr = new Transaction(to, from, pay); // 나, 구매하는 업체, 금액 정보
		tList.add(tr);									 // 트랜잭션을 List로 관리
		Block bl = new Block(tList,mem);				 
		// 트랜잭션 List를 넣음, 회원정보 블럭생성
		BlockChain bc = new BlockChain();					
//		============================================================================
		System.out.println(bc.pendingTransactions.size());
		mem=bl.calculateHash(); // 회원 해쉬값 생성
		System.out.println("회원 해쉬값 :"+mem);
		bc.minePendingTransactions(brand);
		System.out.println(bc.isChainValid());
		System.out.println(bc.getLatestBlock());
	}

}
