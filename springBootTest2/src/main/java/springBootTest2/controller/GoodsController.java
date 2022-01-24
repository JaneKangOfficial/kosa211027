package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.GoodsCommand;
import springBootTest2.service.goods.GoodsDelService;
import springBootTest2.service.goods.GoodsInfoService;
import springBootTest2.service.goods.GoodsListService;
import springBootTest2.service.goods.GoodsRegistService;
import springBootTest2.service.goods.GoodsUpdateService;
import springBootTest2.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsRegistService goodsRegistService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsInfoService goodsInfoService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDelService goodsDelService;
	@Autowired
	GoodsWriteService goodsWriteService;
	
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping("goodsWrite")
	public String goodsWrite(Model model) {
		goodsWriteService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	
	@RequestMapping(value="goodsRegist", method=RequestMethod.POST)
	public String goodsRegist(GoodsCommand goodsCommand, HttpSession session, HttpServletRequest request) {
		goodsRegistService.execute(goodsCommand, session, request);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsInfo")
	public String goodsInfo(@RequestParam(value="num") String goodsNum, Model model) {
		goodsInfoService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsInfo";
	}
	
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(@RequestParam(value="num") String goodsNum, Model model) {
		goodsInfoService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsUpdate";
	}
	
	@RequestMapping(value="goodsUpdateOk", method=RequestMethod.POST)
	public String goodsUpdateOk(GoodsCommand goodsCommand, HttpServletRequest request) {
		goodsUpdateService.execute(goodsCommand, request);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsDelete")
	public String goodsDelete(@RequestParam(value="num") String goodsNum, HttpSession session) {
		goodsDelService.execute(goodsNum, session);
		return "redirect:goodsList";
	}
}
