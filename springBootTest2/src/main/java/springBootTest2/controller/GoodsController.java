package springBootTest2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand, HttpSession session) {
		goodsRegistService.execute(goodsCommand, session);
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
	
	@RequestMapping("goodsUpdateOk")
	public String goodsUpdateOk(GoodsCommand goodsCommand) {
		goodsUpdateService.execute(goodsCommand);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsDelete")
	public String goodsDelete(@RequestParam(value="num") String goodsNum) {
		goodsDelService.execute(goodsNum);
		return "redirect:goodsList";
	}
}
