package kosaShoppingMall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.service.member.GoodsBuyService;
import kosaShoppingMall.service.member.GoodsCartDelService;
import kosaShoppingMall.service.member.GoodsCartDelsService;
import kosaShoppingMall.service.memberJoin.GoodsCartListService;
import kosaShoppingMall.service.memberJoin.GoodsCartQtyDownService;

@Controller
public class GoodsCartController {
	@Autowired
	GoodsCartListService goodsCartListService;
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@Autowired
	GoodsCartDelService goodsCartDelService;
	@Autowired
	GoodsCartDelsService goodsCartDelsService;
	

	@RequestMapping("/cart/goodsCartList")
	public String goodsCartList(HttpSession session, Model model) {
		goodsCartListService.execute(session, model);
		return "thymeleaf/membership/cartList";
	}
	
	@RequestMapping(value="/cart/goodsCartQtyDown")
	public String goodsCartQtyDown(@RequestParam(value="goodsNum") String goodsNum, HttpSession session) {
		goodsCartQtyDownService.execute(goodsNum, session);
		return "redirect:/cart/goodsCartList";
	}
	
	@RequestMapping(value="/cart/goodsBuy", method=RequestMethod.POST)
	public String goodsBuy(@RequestParam(value="prodCk") String[] goodsNums, HttpSession session, Model model) {
		goodsBuyService.execute(goodsNums, session, model);
		return "thymeleaf/membership/goodsOrder";
	}
	
	@RequestMapping(value="/cart/cartDel")
	public String cartDel(@RequestParam(value="goodsNum") String goodsNum, HttpSession session) {
		goodsCartDelService.execute(goodsNum, session);
		return "redirect:/cart/goodsCartList";
	}
	
	@RequestMapping(value="/cart/cartDels")
	public String cartDels(@RequestParam(value="goodsNum[]") String[] goodsNum) {
		goodsCartDelsService.execute(goodsNum);
		return "redirect:/cart/goodsCartList";
	}
}
