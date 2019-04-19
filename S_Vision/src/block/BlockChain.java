package block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blockchain")
public class BlockChain {
	public static List<Block> chain;
	public static int difficulty = 3;
	public static List<Transaction> pendingTransactions;
	public int miningReward = 1000;
	public String key = "brand";
	

	}
	
