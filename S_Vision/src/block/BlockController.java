package block;

import java.io.IOException;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/block/")
public class BlockController extends Wellet{
	Logger logger = Logger.getLogger(BlockController.class);
	@Autowired
	BlockLogic blockLogic = null;
	String path = "";
	Map<String,Object> list= null;
	HttpSession session = null;
	
	@GetMapping("payment")
	public String payment( Model model) {
		path="block/payment";
		return path;
	}
	
	@GetMapping("paris")
	public String path( Model model) {
		Map<String,Object> wmap = new HashMap<String,Object>();
	    wmap.put("store_name","잔칫집");
	    wmap.put("product","국수");
	    wmap.put("amount",15000);
		path="block/PARIS";
		model.addAttribute("wmap",wmap);
		return path;
	}
	
	@GetMapping("payPw")
	public String payment(@RequestParam Map<String,Object> pMap, Model model
							, HttpServletRequest req) throws ServletException, IOException {
		logger.info("breandInfo 호출 성공");
		session = req.getSession();
		session.setAttribute("mem_id", "cgd0502");
		logger.info(session.getAttribute("mem_id"));
		if(pMap.get("mem_id")==null) {
			pMap.put("mem_id", session.getAttribute("mem_id"));
		}
		list= blockLogic.payMap(pMap);
		logger.info(list);
		model.addAttribute("list", list);
		path="block/paymentPW";
		return path;
	}
	
//	//결제하기
//	@GetMapping("payPw")
//	public String payMent(@RequestParam Map<String,Object> pMap, Model model
//			, HttpServletRequest req) throws ServletException, IOException{
//		logger.info("payMent 호출 성공");
//		path="block/paymentPW";
//		return path;
//	}
}
