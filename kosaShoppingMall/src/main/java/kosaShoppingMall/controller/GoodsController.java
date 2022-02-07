package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.service.goods.GoodsDelService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsInsertService;
import kosaShoppingMall.service.goods.GoodsListService;
import kosaShoppingMall.service.goods.GoodsModifyService;
import kosaShoppingMall.service.goods.GoodsNumService;
import kosaShoppingMall.service.goods.SearchGoodsService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsInsertService goodsInsertService;
	@Autowired
	GoodsNumService goodsNumService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsModifyService goodsModifyService;
	@Autowired
	GoodsDelService goodsDelService;
	@Autowired
	SearchGoodsService searchGoodsService;

	@RequestMapping("goodsSearch")
	public String goodsSearch(@RequestParam(value="goodsWord") String goodsWord, Model model) {
		searchGoodsService.execute(goodsWord, model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping(value="goodsRegist", method = RequestMethod.GET)
	public String goodsRegist1(GoodsCommand goodsCommand) {
		goodsNumService.execute(goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	
	@RequestMapping(value="goodsRegist", method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		
		goodsInsertService.execute(goodsCommand);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsDetail/{id}")
	public String goodsDetail(@PathVariable(value="id") String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	@RequestMapping(value="goodsModify", method=RequestMethod.GET)
	public String goodsModify(@RequestParam(value="num") String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsModify";
	}
	
	@RequestMapping(value="goodsModify", method=RequestMethod.POST)
	public String goodsModifyOk(@Validated GoodsCommand goodsCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsModify";
		}
		goodsModifyService.execute(goodsCommand);
		return "redirect:goodsDetail/"+goodsCommand.getGoodsNum();
	}
	
	@RequestMapping("goodsDel")
	public String goodsDel(@RequestParam(value="num") String goodsNum) {
		goodsDelService.execute(goodsNum);
		return "redirect:goodsList";
	}
	
}
