package block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/blockchain")
public class BlockChain {
	public static List<Block> chain;
	public static int difficulty = 3;
	public static List<Transaction> pendingTransactions;
	public int miningReward = 1000;
	public String key = "brand";
	
	public BlockChain() {
		chain = new ArrayList<Block>();						//블럭정보 List
		pendingTransactions = new ArrayList<Transaction>();	//트랜잭션 List
		Block block = createGenesisBlock(key);				//블럭생성
		chain.add(block);									//List에 블럭 연결
		minePendingTransactions("Master");
	}

	public Block createGenesisBlock(String key) {//새로운 블럭 생성 후 연결 
		return new Block(pendingTransactions, key);
	}

	public Block getLatestBlock() {//이전 블럭 불러오기
		return chain.get(chain.size() - 1);
	}
	
//hash값이 맞는지 확인
	public boolean isChainValid() {
		for (int i = 1; i < chain.size(); i++) {
			Block currentBlock = chain.get(i);
			Block previousBlock = chain.get(i - 1);

			if (!currentBlock.hash.equals(currentBlock.calculateHash()))
				return false;
			if (!currentBlock.openKey.equals(previousBlock.hash))
				return false;
		}
		return true;
	}
	
	@RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
	public List<Transaction> createTransaction(@RequestParam Map<String, Object> pMap) {
		System.out.println(pMap);
		Transaction transaction = new Transaction((String) pMap.get("from"),
												  (String) pMap.get("to"),
								 Integer.parseInt((String) pMap.get("amount")));
		if (getBalance((String) pMap.get("from")) < Integer.parseInt((String) pMap.get("amount"))) {
			System.out.println("적당한 금액을 입력해주세요");
			return null;
		} else {
			pendingTransactions.add(transaction);
			return pendingTransactions;
		}
	}

	// 거래내역을 넣고나서 체이닝
	public void minePendingTransactions(String miningRewardAddress) {//파라미터 받는사람의 주소
		Block newBlock = new Block(pendingTransactions, chain.get(chain.size() - 1).hash);
		chain.add(newBlock);
		pendingTransactions = new ArrayList<Transaction>();
		Transaction newTran = new Transaction("CoinManager", miningRewardAddress, miningReward);
		pendingTransactions.add(newTran);
	}
	
	//추가 금액인지 차감 금액인지 체크
	public int getBalance(String address) {
		int balance = 0;
		// Loop over each block and each transaction inside the block
		for (Block block : chain) {
			for (Transaction trans : block.tList) {
				// If the given address is the sender -> reduce the balance
				if (trans.info.get("from").equals(address)) {
					balance -= Integer.getInteger((String) trans.info.get("amount"));
				}
				// If the given address is the receiver -> increase the balance
				if (trans.info.get("to").equals(address)) {
					balance += Integer.getInteger((String) trans.info.get("amount"));
				}
			}
		}
		return balance;
	}
	
	@RequestMapping(value = "mining", method = RequestMethod.POST)
	public List<Block> miningpage() {
		minePendingTransactions("Master");
		return chain;
	}


	@RequestMapping(value="myCoin", method = RequestMethod.POST)
	public int myCoin(@RequestParam("email") String email) {
		int coin = 0;
		coin = getBalance(email);
		return coin;
	}
	
//거래 내역 페이지로 호출될 값들	
	@RequestMapping(value="/trans",method=RequestMethod.POST)
	public List<Map<String,Object>> transactions(@RequestParam("address") String address){//나인지 너인지의 정보 불러오기
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		int balance = 0;
		for (Block block : chain) { //block에 List<chain>의 정보를 넣는다.
			for (Transaction trans : block.tList) {//block에 담긴 트랜잭션의 정보를 담는다.
				Map<String,Object> inputCoin = new HashMap<String,Object>(); //나에게서 나가는돈 
				Map<String,Object> outputCoin = new HashMap<String,Object>(); //너에게 들어가는 돈
				if (trans.info.get("from").equals(address)) {//나에게서 나가는돈 
					balance -= Integer.getInteger((String) trans.info.get("amount"));
					inputCoin.put("from", trans.info.get("from"));
					inputCoin.put("to", trans.info.get("to"));
					inputCoin.put("amount", trans.info.get("amount"));
					inputCoin.put("date", block.timestamp);
					inputCoin.put("balance", balance);
					list.add(inputCoin);
				}
				if (trans.info.get("to").equals(address)) {//너에게 들어가는 돈
					balance += Integer.getInteger((String) trans.info.get("amount"));
					outputCoin.put("from", trans.info.get("from"));
					outputCoin.put("to", trans.info.get("to"));
					outputCoin.put("amount", trans.info.get("amount"));
					outputCoin.put("date", block.timestamp);
					outputCoin.put("balance", balance);
					list.add(outputCoin);
				}
			}
		}
		return list;
	}
}
