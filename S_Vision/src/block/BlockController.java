package block;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vo.BrandVO;
import com.vo.CreditcardVO;

@Controller
@RequestMapping(value="/block/")
public class BlockController extends Wellet{
	Logger logger = Logger.getLogger(BlockController.class);
	@Autowired
	BlockLogic blockLogic = null;
	String path = "";
	HttpSession session = null;
	
	//브랜드 정보
	@GetMapping("b_info")
	public String breandInfo(@ModelAttribute BrandVO  brandVO, Model model
							, HttpServletRequest req) throws ServletException, IOException {
		logger.info("breandInfo 호출 성공");
		session = req.getSession();
		String store_name = (String) session.getAttribute("store_name");
		storeInfo = blockLogic.storeInfo(brandVO);
		Map<String,Object> sessionInfo = new HashMap<String,Object>();
		for(int i=0;storeInfo.size()>i;i++) {
			if(store_name.equals(storeInfo.get(i).get("store_name"))) {
				sessionInfo.put("amount", (String)session.getAttribute("amount")); 	//결제금액
				sessionInfo.put("product", (String)session.getAttribute("product"));//상품명
				storeInfo.add(sessionInfo);
			}
		}
		model.addAttribute("storeInfo", storeInfo);
		path = "";
		return path;
	}
	//카드 정보
	@GetMapping("c_info")
	public String cardInfo(@ModelAttribute CreditcardVO  creditcardVO, Model model
							, HttpServletRequest req) throws ServletException, IOException {
		logger.info("cardInfo 호출 성공");
		cardInfo = blockLogic.cardInfo(creditcardVO);
		return path;
	}
	//결제하기
	@GetMapping("payment")
	public String payMent(@ModelAttribute Transaction tr, Model model
			, HttpServletRequest req) throws ServletException, IOException{
		logger.info("payMent 호출 성공");
		payList = blockLogic.payMent(tr);
		return path;
	}
}
