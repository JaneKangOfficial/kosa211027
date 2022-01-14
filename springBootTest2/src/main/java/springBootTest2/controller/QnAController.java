package springBootTest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.QnaCommand;
import springBootTest2.service.qna.QnaDelService;
import springBootTest2.service.qna.QnaDetailService;
import springBootTest2.service.qna.QnaInfoService;
import springBootTest2.service.qna.QnaListService;
import springBootTest2.service.qna.QnaModifyService;
import springBootTest2.service.qna.QnaWriteService;

@Controller
@RequestMapping("qna")
public class QnAController {
	@Autowired
	QnaWriteService qnaWriteService;
	@Autowired
	QnaListService qnaListService;
	@Autowired
	QnaDetailService qnaDetailService;
	@Autowired
	QnaDelService qnaDelService;
	@Autowired
	QnaInfoService qnaInfoService;
	@Autowired
	QnaModifyService qnaModifyService;
	
	@RequestMapping("qnaList")
	public String qnaHome(Model model) {
		qnaListService.execute(model);
		return "thymeleaf/qna/qnaList";
	}
	
	@RequestMapping("qnaWrite")
	public String qnaForm() {
		return "thymeleaf/qna/qnaForm";
	}
	
	@RequestMapping(value="qnaRegist", method=RequestMethod.POST)
	public String qnaReigst(QnaCommand qnaCommand) {
		qnaWriteService.execute(qnaCommand);
		return "redirect:qnaList";
	}
	
	@RequestMapping("qnaDetail")
	public String qnaDetail(@RequestParam(value="num") Integer qnaNum, Model model) {
		qnaDetailService.execute(qnaNum, model);
		return "thymeleaf/qna/qnaInfo";
	}
	
	@RequestMapping("qnaDel")
	public String qnaDel(@RequestParam(value="num") Integer qnaNum) {
		qnaDelService.execute(qnaNum);
		return "redirect:qnaList";
	}
	
	@RequestMapping("qnaUpdate")
	public String qnaUpdate(@RequestParam(value="num") Integer qnaNum, Model model) {
		qnaInfoService.execute(qnaNum, model);
		return "thymeleaf/qna/qnaDetail";
	}
	
	@RequestMapping(value="qnaModify", method=RequestMethod.POST)
	public String qnaModify(QnaCommand qnaCommand) {
		qnaModifyService.execute(qnaCommand);
		return "redirect:qnaDetail?num="+qnaCommand.getQnaNum();
	}
}
