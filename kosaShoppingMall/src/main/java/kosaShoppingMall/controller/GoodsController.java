package kosaShoppingMall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.service.goods.GoodsDelService;
import kosaShoppingMall.service.goods.GoodsDelsService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsInsertService;
import kosaShoppingMall.service.goods.GoodsIpgoDelService;
import kosaShoppingMall.service.goods.GoodsIpgoDelsService;
import kosaShoppingMall.service.goods.GoodsIpgoDetailService;
import kosaShoppingMall.service.goods.GoodsIpgoListService;
import kosaShoppingMall.service.goods.GoodsIpgoModifyService;
import kosaShoppingMall.service.goods.GoodsIpgoService;
import kosaShoppingMall.service.goods.GoodsIpgoUpdateService;
import kosaShoppingMall.service.goods.GoodsItemService;
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
	@Autowired
	GoodsItemService goodsItemService;
	@Autowired
	GoodsIpgoService goodsIpgoService;
	@Autowired
	GoodsIpgoListService goodsIpgoListService;
	@Autowired
	GoodsIpgoDetailService goodsIpgoDetailService;
	@Autowired
	GoodsIpgoModifyService goodsIpgoModifyService;
	@Autowired
	GoodsIpgoUpdateService goodsIpgoUpdateService;
	@Autowired
	GoodsIpgoDelService goodsIpgoDelService;
	@Autowired
	GoodsDelsService goodsDelsService;
	@Autowired
	GoodsIpgoDelsService goodsIpgoDelscService;
	
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
	
	// 한번에 여러개 삭제
	@RequestMapping(value="goodsDels", method=RequestMethod.POST)
	public String goodsDels(@RequestParam(value="delete") String [] deletes) {
		goodsDelsService.execute(deletes);
		return "redirect:goodsList";
	}
	
	
	//============== goodsIpgo
	
	@RequestMapping("goodsIpgo")
	public String goodsIpgo(GoodsIpgoCommand goodsIpgoCommand) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ipgoDate = sdf.format(now);
		goodsIpgoCommand.setIpgoDate(now);
		return "thymeleaf/goods/goodsIpgo";
	}
	
	@RequestMapping(value="goodsItem", method=RequestMethod.GET)
	public String goodsItem1() {
		return "thymeleaf/goods/goodsItem";
	}
	
	@RequestMapping(value="goodsItem", method=RequestMethod.POST)
	public String goodsItem(@RequestParam(value="goodsName") String goodsName, Model model) {
		goodsItemService.execute(goodsName, model);
		return "thymeleaf/goods/goodsItem";
	}
	
	@RequestMapping(value="ipgoRegist", method=RequestMethod.GET)
	public String ipgoRegist1() {
		return "redirect:/";
	}
	
	@RequestMapping(value="ipgoRegist", method=RequestMethod.POST)
	public String ipgoRegist(@Validated GoodsIpgoCommand goodsIpgoCommand, BindingResult result) {
		if(result.hasErrors()) { 
			return "thymeleaf/goods/goodsIpgo"; 
		}
		goodsIpgoService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}
	
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList(Model model) {
		goodsIpgoListService.execute(model);
		return "thymeleaf/goods/goodsIpgoList";
	}
	
	@RequestMapping("goodsIpgoDetail")
	public String goodsIpgoDetail(@RequestParam(value="goodsNum") String goodsNum,
									@RequestParam(value="ipgoDate") String ipgoDate, Model model) {
		goodsIpgoDetailService.execute(goodsNum, ipgoDate, model);
		return "thymeleaf/goods/goodsIpgoDetail";
	}
	
	//
	@RequestMapping(value="goodsIpgoModify", method=RequestMethod.GET)
	public String goodsIpgoModify(@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="ipgoDate") String ipgoDate, Model model, GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoModifyService.execute(goodsNum, ipgoDate, model);
		return "thymeleaf/goods/goodsIpgoModify";
	}
	
	@RequestMapping(value="goodsIpgoModify", method=RequestMethod.POST)
	public String goodsIpgoModifyOk(@Validated GoodsIpgoCommand goodsIpgoCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsIpgoModify";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(goodsIpgoCommand.getIpgoDate());
		goodsIpgoUpdateService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoDetail?goodsNum="+goodsIpgoCommand.getGoodsNum()+"&ipgoDate="+date;
	}
	
	@RequestMapping("goodsIpgoDel")
	public String goodsIpgoDel(GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoDelService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}
	
	// 한번에 여러개 삭제
	@RequestMapping(value="goodsIpgoDels", method=RequestMethod.POST)
	public String goodsIpgoDels(@RequestParam(value="delete") String[] deletes) {
		goodsIpgoDelscService.execute(deletes);
		return "redirect:goodsIpgoList";
	}
	
}
