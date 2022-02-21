package kosaShoppingMall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.GoodsInquireCommand;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.InquireInfoService;
import kosaShoppingMall.service.goods.InquireListService;
import kosaShoppingMall.service.goods.InquireWriteService;
import kosaShoppingMall.service.goods.ReviewListService;

@Controller
public class CornerController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	ReviewListService reviewListService;
	@Autowired
	InquireListService inquireListService;
	@Autowired
	InquireWriteService inquireWriteService;
	@Autowired
	InquireInfoService inquireInfoService;
	@ModelAttribute
	public GoodsInquireCommand setGoodsInquireCommand() {
		return new GoodsInquireCommand();
	}
	
	@RequestMapping("/corner/prodInfo")
	public String prodInfo(@RequestParam(value="goodsNum") String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/goods/prodInfo";
	}
	
	@RequestMapping("/corner/reviewList")
	public String reviewList(@RequestParam(value="goodsNum") String goodsNum, Model model) {
		reviewListService.execute(goodsNum, model);
		return "thymeleaf/purchase/reviewList";
	}
	
	@RequestMapping("/corner/inquireList")
	public String inquireList(@ModelAttribute(value="goodsNum") String goodsNum, Model model) {
		inquireListService.execute(goodsNum,model);
		return "thymeleaf/purchase/inquireList";
	}
	
	@RequestMapping(value="/corner/inquireWrite", method = RequestMethod.GET)
	public String inquireWrite1(@ModelAttribute(value="goodsNum") String goodsNum, Model model) {
		inquireInfoService.execute(goodsNum, model);
		return "thymeleaf/purchase/inquireWrite";
	}
	
	@RequestMapping(value="/corner/inquireWrite", method = RequestMethod.POST)
	public String inquireWrite(GoodsInquireCommand goodsInquireCommand, HttpSession session, HttpServletResponse response) {
		inquireWriteService.execute(goodsInquireCommand, session);
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
			          +  "opener.location.reload();"
			          + "				window.self.close();"
			          + "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return "thymeleaf/purchase/inquireWrite";
		return null;
	}
	
}
