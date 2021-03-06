package kosaShoppingMall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdCheckService;
import kosaShoppingMall.service.employees.EmpEmailCheckService;
import kosaShoppingMall.service.employees.EmpIdCheckService;
import kosaShoppingMall.service.goods.DeliveryDelService;
import kosaShoppingMall.service.goods.DeliveryUpdateProService;
import kosaShoppingMall.service.goods.GoodsCartAddService;
import kosaShoppingMall.service.goods.GoodsListService;
import kosaShoppingMall.service.goods.GoodsWishService;
import kosaShoppingMall.service.member.MemberEmailCheckService;
import kosaShoppingMall.service.member.MemberIdCheckService;
import kosaShoppingMall.service.memberJoin.DelpurchaseService;

@RestController
public class CheckController {
	@Autowired
	IdCheckService idCheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmpIdCheckService empIdCheckService;
	@Autowired
	EmpEmailCheckService empEmailCheckService;
	@Autowired
	MemberIdCheckService memberIdCheckService;
	@Autowired
	MemberEmailCheckService memberEmailCheckService;
	@Autowired
	GoodsWishService goodsWishService;
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@Autowired
	DelpurchaseService delpurchaseService;
	@Autowired
	DeliveryUpdateProService deliveryUpdateProService;
	@Autowired
	DeliveryDelService deliveryDelService;
	@Autowired
	GoodsListService goodsListService;
	
	
	@RequestMapping(value="/register/idCheck", method=RequestMethod.POST)
	public String idCheck(@RequestParam(value="memberId") String memberId) {
		
		Integer i = idCheckService.execute(memberId);
		if(i == 0) {
			return "?????? ????????? id?????????.";
		}else {
			return "?????? ?????? id?????????.";
		}
	}
	
	@RequestMapping(value="/register/emailCheck", method=RequestMethod.POST)
	public String emailCheck(@RequestParam(value="memberEmail") String memberEmail ) {
		Integer i = emailCheckService.execute(memberEmail);
		if(i == 0) {
			return "?????? ????????? email?????????.";
		}else {
			return "?????? ?????? email?????????.";
		}
	}
	
	@RequestMapping(value="/emp/empIdCheck", method=RequestMethod.POST)
	public String empIdCheck(@RequestParam(value="empId") String empId) {
		
		Integer i = empIdCheckService.execute(empId);
		
		if(i == 0) {
			return "?????? ????????? id?????????.";
		}else {
			return "?????? ?????? id?????????.";
		}
	}
	
	@RequestMapping(value="/emp/empEmailCheck", method=RequestMethod.POST)
	public String empEmailCheck(@RequestParam(value="empEmail") String empEmail) {
		Integer i = empEmailCheckService.execute(empEmail);
		if(i == 0) {
			return "?????? ????????? email?????????.";
		}else {
			return "?????? ?????? email?????????.";
		}
	}
	
	@RequestMapping(value="/empMypage/empEmailCheck", method=RequestMethod.POST)
	public String empEmailCheck2(@RequestParam(value="empEmail") String empEmail) {
		Integer i = empEmailCheckService.execute(empEmail);
		if(i == 0) {
			return "?????? ????????? email?????????.";
		}else {
			return "?????? ?????? email?????????.";
		}
	}
	
	@RequestMapping(value="/mem/memIdCheck", method=RequestMethod.POST)
	public String memIdCheck(@RequestParam(value="memberId") String memberId) {
		Integer i = memberIdCheckService.execute(memberId);
		if(i == 0) {
			return "?????? ????????? id?????????.";
		}else {
			return "?????? ?????? id?????????.";
		}
	}
	
	@RequestMapping(value="/mem/memEmailCheck", method=RequestMethod.POST)
	public String memEmailCheck(@RequestParam(value="memberEmail") String memberEmail, 
							@RequestParam(value="memberId") String memberId) {
		Integer i = memberEmailCheckService.execute(memberEmail, memberId);
		if(i == 0) {
			return "?????? ????????? email?????????.";
		}else {
			return "?????? ?????? email?????????.";
		}
	}
	
	@RequestMapping(value="/mypage/memEmailCheck", method=RequestMethod.POST)
	public String memEmailCheck2(@RequestParam(value="memberEmail") String memberEmail ,
				@RequestParam(value = "memberId")String memberId) {
		Integer i = memberEmailCheckService.execute(memberEmail ,memberId);
		if(i == 0) {
			return "?????? ????????? email?????????.";
		}else {
			return "?????? ?????? email?????????.";
		}
	}
	
	@RequestMapping(value="/cart/goodsWishAdd")
	public String goodsWishAdd(@RequestParam(value="goodsNum") String goodsNum, HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
	
	@RequestMapping(value="/cart/goodsCartAdd" )
	public String goodsCartAdd(@RequestParam(value="goodsNum") String goodsNum,
							@RequestParam(value="goodsQty") Integer goodsQty, HttpSession session) {
		return goodsCartAddService.execute(goodsNum, goodsQty, session);
	}
	
	@RequestMapping(value="/cart/delPurchase")
	public Integer delPurchase(HttpServletRequest request ,
				@RequestParam (value = "purchaseNum") String purchaseNum) {
		//System.out.println(purchaseNum);
		Integer i = delpurchaseService.execute(purchaseNum);
		
		return i;
	}
	
	@RequestMapping(value="/goods/deliveryUpdatePro")
	public Integer deliveryUpdatePro(DeliveryCommand deliveryCommand) {
		return deliveryUpdateProService.execute(deliveryCommand);
	}
	
	@RequestMapping(value="/goods/deliveryDel")
	public Integer deliveryDel(@RequestParam(value="purchaseNum") String purchaseNum) {
		return deliveryDelService.execute(purchaseNum);
	}
	
	@RequestMapping(value="/android", produces="application/json;charset=utf-8")
	public @ResponseBody String json(Model model) {
		Gson gson = new Gson();
		List<GoodsDTO> dailyBoxOfficeList = goodsListService.execute(model,1,null);
		return gson.toJson(dailyBoxOfficeList);
	}
}