package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.BoardCommand2;
import springBootTest2.service.board2.BoardDelService2;
import springBootTest2.service.board2.BoardDetailService2;
import springBootTest2.service.board2.BoardInsertService2;
import springBootTest2.service.board2.BoardListService2;
import springBootTest2.service.board2.BoardUpdateService2;

@Controller
@RequestMapping("board2")
public class BoardController2 {
	@Autowired
	BoardInsertService2 boardInsertService;
	@Autowired
	BoardListService2 boardListService;
	@Autowired
	BoardDetailService2 boardDetailService;
	@Autowired
	BoardDelService2 boardDelService;
	@Autowired
	BoardUpdateService2 boardUpdateService;
	
	
	@RequestMapping("boardList")
	public String boardList(Model model) {
		boardListService.execute(model);
		return "thymeleaf/board2/boardList";
	}
	
	@RequestMapping("boardForm")
	public String boardForm() {
		return "thymeleaf/board2/boardForm";
	}
	
	@RequestMapping("boardRegist")
	public String boardRegist(BoardCommand2 boardCommand, HttpServletRequest request) {
		boardInsertService.execute(boardCommand, request);
		return "redirect:boardList";
	}
	
	@RequestMapping("boardDetail")
	public String boardDetail(@RequestParam(value="num") Integer boardNum, Model model) {
		boardDetailService.execute(boardNum, model);
		return "thymeleaf/board2/boardDetail";
	}
	
	@RequestMapping("boardUpdate")
	public String boardUpdate(@RequestParam(value="num") Integer boardNum, Model model) {
		boardDetailService.execute(boardNum, model);
		return "thymeleaf/board2/boardUpdate";
	}
	
	@RequestMapping("boardUpdateOk")
	public String boardUpdateOk(BoardCommand2 boardCommand) {
		boardUpdateService.execute(boardCommand);
		return "redirect:boardDetail?num="+boardCommand.getBoardNum();
	}
	
	@RequestMapping("boardDelete") 
	public String boardDelete(@RequestParam(value="num") Integer boardNum) {
		boardDelService.execute(boardNum);
		return "redirect:boardList";
	}
	

}
