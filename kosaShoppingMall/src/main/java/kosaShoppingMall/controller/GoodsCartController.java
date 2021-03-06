package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.PurchaseCommand;
import kosaShoppingMall.service.goods.GoodsReviewUpdateService;
import kosaShoppingMall.service.goods.ReviewDelService;
import kosaShoppingMall.service.goods.ReviewWriteService;
import kosaShoppingMall.service.member.GoodsBuyService;
import kosaShoppingMall.service.member.GoodsCartDelService;
import kosaShoppingMall.service.member.GoodsCartDelsService;
import kosaShoppingMall.service.memberJoin.DoPaymentService;
import kosaShoppingMall.service.memberJoin.GoodsCartListService;
import kosaShoppingMall.service.memberJoin.GoodsCartQtyDownService;
import kosaShoppingMall.service.memberJoin.GoodsOrderService;
import kosaShoppingMall.service.memberJoin.OrderProcessListService;
import kosaShoppingMall.service.memberJoin.PaymentCancelService;
import kosaShoppingMall.service.memberJoin.PaymentDelService;
import kosaShoppingMall.service.memberJoin.PurchaseDetailService;

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
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	OrderProcessListService orderProcessListService;
	@Autowired
	DoPaymentService doPaymentService;
	@Autowired
	PaymentCancelService paymentCancelService;
	@Autowired
	PaymentDelService paymentDelService;
	@Autowired
	PurchaseDetailService purchaseDetailService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	GoodsReviewUpdateService goodsReviewUpdateService;
	@Autowired
	ReviewDelService reviewDelService;
	

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
	public String cartDels(@RequestParam(value="goodsNum[]") String[] goodsNum, HttpSession session) {
		goodsCartDelsService.execute(goodsNum, session);
		return "redirect:/cart/goodsCartList";
	}
	
	@RequestMapping(value="/cart/goodsOrder", method=RequestMethod.POST)
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session) {
		// ?????? ?????? ??????
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session);
		// ?????? ???????????? ??????
		return "redirect:paymentOk?purchaseNum="+purchaseNum + "&totalPrice="+purchaseCommand.getTotalPrice();
	}
	
	@RequestMapping(value="/cart/paymentOk")
	public String paymentOk(@ModelAttribute(value="purchaseNum") String purchaseNum,
						@ModelAttribute(value="totalPrice") String totalPrice) {
		return "thymeleaf/purchase/payment";
	}
	
	@RequestMapping(value="/cart/orderList")
	public String orderList(HttpSession session, Model model) {
		orderProcessListService.execute(session, model);
		return "thymeleaf/purchase/orderList";
	}
	
	@RequestMapping(value="/cart/doPayment")
	public String doPayment(@RequestParam(value="purchaseNum") String purchaseNum,
						@RequestParam(value="totalPrice") String totalPrice,
						@RequestParam(value="cardNumber") String cardNumber, Model model) {
		doPaymentService.execute(purchaseNum, totalPrice, cardNumber, model);
		return "thymeleaf/purchase/buyFinished";
	}
	
	@RequestMapping("/cart/paymentCancel")
	public String paymentCancel(@RequestParam(value="purchaseNum") String purchaseNum) {
		paymentCancelService.execute(purchaseNum);
		return "redirect:orderList";
	}
	@RequestMapping("/cart/paymentDel")
	public String paymentDel(@RequestParam(value="purchaseNum") String purchaseNum) {
		paymentDelService.execute(purchaseNum);
		return "redirect:orderList";
	}
	
	@RequestMapping("/cart/purchaseDetail")
	public String purchaseDetail(@RequestParam(value="purchaseNum") String purchaseNum, Model model, HttpSession session) {
		purchaseDetailService.execute(purchaseNum, model, session);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/purchase/purchaseDetail";
	}
	
	@RequestMapping("/cart/goodsReview")
	public String goodsReview(@ModelAttribute(value="goodsNum") String goodsNum,
						@ModelAttribute(value="purchaseNum") String purchaseNum) {
		return "thymeleaf/purchase/goodsReview";
	}
	
	@RequestMapping(value="/cart/reviewWrite", method=RequestMethod.POST)
	public String reviewWrite(@RequestParam(value="goodsNum") String goodsNum,
					@RequestParam(value="reviewContent") String reviewContent,
					@RequestParam(value="purchaseNum") String purchaseNum) {
		reviewWriteService.execute(goodsNum, reviewContent, purchaseNum);
		return "redirect:orderList";
	}
	
	@RequestMapping(value="/cart/goodsReviewUpdate", method = RequestMethod.GET)
	public String goodsReviewUpdate(@RequestParam(value="purchaseNum") String purchaseNum,
								@RequestParam(value="goodsNum") String goodsNum, 
								HttpSession session, Model model) {
		goodsReviewUpdateService.execute(purchaseNum, goodsNum, session, model);
		return "thymeleaf/purchase/goodsReviewUpdate";
	}
	
	@RequestMapping(value="/cart/goodsReviewUpdate", method = RequestMethod.POST)
	public String goodsReviewUpdate(@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="reviewContent") String reviewContent) {
		goodsReviewUpdateService.execute(purchaseNum, goodsNum, reviewContent);
		
		return "redirect:orderList";
	}
	
	@RequestMapping(value="/cart/reviewDel")
	public String reviewDel(@RequestParam(value="purchaseNum") String purchaseNum,
					@RequestParam(value="goodsNum") String goodsNum) {
		reviewDelService.execute(purchaseNum, goodsNum);
		return "redirect:orderList";
	}
	
}
