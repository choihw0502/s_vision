package block;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/block/")
public class BlockController extends Wellet{
	Logger logger = Logger.getLogger(BlockController.class);
	@Autowired
	BlockLogic blockLogic = null;
	String path = "";
	HttpSession session = null;
	
	@RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
	public Map<String,Object> payment(@RequestParam Transaction tr, Model model, HttpServletRequest req) throws ServletException, IOException{
		constructor();
		return info;
	}
	
	
	
//	@GetMapping("paymentPW")
//	public String payment(@RequestParam Map<String,Object> pMap, Model model
//							, HttpServletRequest req) throws ServletException, IOException {
//		logger.info("breandInfo 호출 성공");
//		session = req.getSession();
//		session.setAttribute("mem_id", "cgd0502");
//		logger.info(session.getAttribute("mem_id"));
//		if(pMap.get("mem_id")==null) {
//			pMap.put("mem_id", session.getAttribute("mem_id"));
//		}
//		list= blockLogic.payMap(pMap);
//		logger.info(list);
//		model.addAttribute("list", list);
//		path="pay/paymentPW";
//		return path;
//	}
	
//	//결제하기
//	@GetMapping("succeed")
//	public String payMent(@RequestParam Map<String,Object> pMap, Model model
//			, HttpServletRequest req) throws ServletException, IOException{
//		logger.info("payMent 호출 성공");
//		String mem_id = "";
//		for(int i=0;i<Wellet.payList.size();i++){
//			if(store_name.equals(Wellet.payList.get(i).get("STORE_NAME"))){
//				mem_id=(String)Wellet.payList.get(i).get("mem_id");
//			}
//		}
//		Transaction tr = new Transaction(mem_id,store_name,amount);
//		if(list.get("mem_id").equals(session.getAttribute("mem_id"))) {
//			if() {
//				
//			}
//		}
//		blockLogic.succeed(pMap);
//		path="member/index";
//		return path;
//	}
}
