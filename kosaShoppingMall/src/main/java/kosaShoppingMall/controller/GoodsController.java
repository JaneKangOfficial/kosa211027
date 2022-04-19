package kosaShoppingMall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.command.FileInfo;
import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.service.goods.DeliveryActionService;
import kosaShoppingMall.service.goods.DeliveryUpdateProService;
import kosaShoppingMall.service.goods.GoodsDelService;
import kosaShoppingMall.service.goods.GoodsDelsService;
import kosaShoppingMall.service.goods.GoodsDetailService;
import kosaShoppingMall.service.goods.GoodsInquireAnswerWriteService;
import kosaShoppingMall.service.goods.GoodsInquireDetailService;
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
import kosaShoppingMall.service.goods.GoodsQuestionService;
import kosaShoppingMall.service.goods.PurchaseCancelService;
import kosaShoppingMall.service.goods.PurchaseDetailEmpService;
import kosaShoppingMall.service.goods.PurchaseListService;
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
	@Autowired
	FileDelService fileDelService;
	@Autowired
	PurchaseListService purchaseListService;
	@Autowired
	PurchaseDetailEmpService purchaseDetailEmpService;
	@Autowired
	PurchaseCancelService purchaseCancelService;
	@Autowired
	DeliveryActionService deliveryActionService;
	@Autowired
	DeliveryUpdateProService deliveryUpdateProService;
	@Autowired
	GoodsQuestionService goodsQuestionService;
	@Autowired
	GoodsInquireDetailService goodsInquireDetailService;
	@Autowired
	GoodsInquireAnswerWriteService goodsInquireAnswerWriteService;
	
	@ModelAttribute
	GoodsCommand getGoodsCommand() {
		return new GoodsCommand();
	}
	
	// 포스트맨 사용 연습
	@RequestMapping(value="goodsRegist2", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> goodsRegist1(@RequestBody Map<String, Object> param) {
		// 전달된 값
		Map<String,Object> head = (Map<String, Object>) param.get("head");
		Map<String,Object> body = (Map<String, Object>) param.get("body");
		
		System.out.println("headdddd screen_id " + head.get("screen_id"));
		System.out.println("bodyyyyy goodsNum" + body.get("goodsNum"));
		System.out.println("bodyyyyy goodsName " + body.get("goodsName"));
		System.out.println("bodyyyyy goodsPrice " + body.get("goodsPrice"));
		System.out.println("bodyyyyy goodsContent " + body.get("goodsContent"));
		System.out.println("bodyyyyy deliveryCost " + body.get("deliveryCost"));
		
		// 결과 확인 리턴 값
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> head1 = new HashMap<String, Object>();
		head1.put("screen_id", "174");
		head1.put("result_code", "200");
		Map<String, Object> body1 = new HashMap<String, Object>();
		body1.put("rsltCode", "0000");
		body1.put("rsltMsg", "Success");
		body1.put("userNm", "홍길동");
		
		result.put("head", head1);
		result.put("body", body1);
		result.put("SUCCESS", true);
		
		return result;
	}
	
/* goodsList 페이지와 융합
	@RequestMapping("goodsSearch")
	public String goodsSearch(@RequestParam(value="goodsWord" , required = false) String goodsWord,
			@RequestParam(value="page", defaultValue = "1", required = false) Integer page,
			Model model) {
		searchGoodsService.execute(goodsWord, model, page);
		return "thymeleaf/goods/goodsList";
	}
*/	
	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value="page", defaultValue = "1", required = false) Integer page, 
					@RequestParam(value="goodsWord", required=false)String goodsWord , Model model) {
		goodsListService.execute(model,page,goodsWord);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping(value="goodsRegist", method = RequestMethod.GET)
	public String goodsRegist1(GoodsCommand goodsCommand) {
		goodsNumService.execute(goodsCommand);
//		return "thymeleaf/goods/goodsForm3";
		return "thymeleaf/goods/goodsForm";
	}
	
	/*
	 * 회사에서는 MultipartFile 사용하지 않음(용량이 작고 느림)
	 * command가 아닌 파일만 받을 경우
	 * @RequestParam(value="goodsMain") MultipartFile goodsMain,
				@RequestParam(value="goodsImages") MultipartFile[] goodsImages,
	 */
	@RequestMapping(value="goodsRegist", method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		
		if(goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			result.rejectValue("goodsMain", "goodsCommand.goodsMain", "대문 이미지를 선택해주세요.");
			return "thymeleaf/goods/goodsForm";
		}
		
		goodsInsertService.execute(goodsCommand, request);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsDetail/{id}")
	public String goodsDetail(@PathVariable(value="id") String goodsNum, Model model, HttpSession session) {
		goodsDetailService.execute(goodsNum, model, session);
		model.addAttribute("newLineChar", '\n');
		return "thymeleaf/goods/goodsDetail";
	}
	
	@RequestMapping(value="goodsModify", method=RequestMethod.GET)
	public String goodsModify(@RequestParam(value="num") String goodsNum, Model model, HttpSession session) {
		session.removeAttribute("fileList");
		goodsDetailService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsModify";
	}
	
	@RequestMapping(value="goodsModify", method=RequestMethod.POST)
	public String goodsModifyOk(@Validated GoodsCommand goodsCommand, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsModify";
		}
		goodsModifyService.execute(goodsCommand, session);
		return "redirect:goodsDetail/"+goodsCommand.getGoodsNum();
	}
	
	@RequestMapping("goodsDel")
	public String goodsDel(@RequestParam(value="num") String goodsNum, HttpServletRequest request) {
		goodsDelService.execute(goodsNum, request);
		return "redirect:goodsList";
	}
	
	// 한번에 여러개 삭제
	@RequestMapping(value="goodsDels", method=RequestMethod.POST)
	public String goodsDels(@RequestParam(value="delete") String [] deletes, HttpServletRequest request) {
		goodsDelsService.execute(deletes, request);
		return "redirect:goodsList";
	}
	
	@RequestMapping("fileDel")
	public String fileDel(FileInfo fileInfo, HttpSession session, Model model) {
		fileDelService.fileAdd(fileInfo, session, model);
		return "thymeleaf/goods/delPage";
	}
	
	// 주문 내역
	@RequestMapping("purchaseList")
	public String purchaseList(Model model) {
		purchaseListService.execute(model);
		return "thymeleaf/goods/purchaseList";
	}
	// 주문 상세내역
	@RequestMapping("purchaseDetail")
	public String purchaseDetail(@RequestParam(value="purchaseNum") String purchaseNum, Model model) {
		purchaseDetailEmpService.execute(purchaseNum, model);
		model.addAttribute("newLineChar","\n");
		return "thymeleaf/goods/purchaseDetail";
	}
	
	@RequestMapping("purchaseCancel")
	public String purchaseCancel(@RequestParam(value="purchaseNum") String purchaseNum) {
		purchaseCancelService.execute(purchaseNum);
		return "redirect:purchaseList";
	}
	
	@RequestMapping(value="deliveryAction", method=RequestMethod.POST)
	public String deliveryAction(DeliveryCommand deliveryCommand) {
		deliveryActionService.execute(deliveryCommand);
		return "redirect:purchaseList";
	}
	
	@RequestMapping("deliveryUpdate")
	public String deliveryUpdate() {
		return "thymeleaf/goods/deliveryUpdate";
	}
	
	// 관리자 상품문의
	@RequestMapping("goodsQuestion")
	public String goodsQuestion(Model model) {
		goodsQuestionService.execute(model);
		return "thymeleaf/goods/goodsQuestion";
	}
	
	// 관리자 상품문의 상세페이지
	@RequestMapping("goodsInquireDetail/{id}")
	public String goodsInquireDetail(@PathVariable(value="id") String inquireNum, Model model) {
		goodsInquireDetailService.execute(inquireNum, model);
		return "thymeleaf/goods/goodsInquireDetail";
	}
	
	@RequestMapping("answerWrite")
	public String answerWrite(@RequestParam(value="memberNum") String memberNum,
						@RequestParam(value="inquireNum") Integer inquireNum,
						@RequestParam(value="answerEmail") String answerEmail,
						@RequestParam(value="inquireSubject") String inquireSubject,
						@RequestParam(value="inquireAnswer") String inquireAnswer) {
		goodsInquireAnswerWriteService.execute(memberNum, inquireNum, inquireAnswer, answerEmail, inquireSubject);
		return "redirect:goodsQuestion";
	}
	
	
	
	
	
	// ========================= goodsIpgo
	
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
	public String goodsIpgoList(@RequestParam(value="page", defaultValue = "1", required = false) Integer page, Model model) {
		goodsIpgoListService.execute(model, page);
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
