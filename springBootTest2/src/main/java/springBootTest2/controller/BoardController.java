package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.BoardCommand;
import springBootTest2.service.board.BoardDelService;
import springBootTest2.service.board.BoardDetailService;
import springBootTest2.service.board.BoardInfoService;
import springBootTest2.service.board.BoardListService;
import springBootTest2.service.board.BoardModifyService;
import springBootTest2.service.board.BoardWriteService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService;
	@Autowired
	BoardDelService boardDelService;
	@Autowired
	BoardInfoService boardInfoService;
	@Autowired
	BoardModifyService boardModifyService;
	
	@RequestMapping("boardList") // doGet, doPost 모두 있음
	public String boardList(Model model) { 
		boardListService.execute(model);
		return "thymeleaf/board/boardList";
	}
	
	@RequestMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/board/boardForm";
	}
	
	@RequestMapping(value="boardRegist", method=RequestMethod.POST) // doPost에만 있음, doGet으로 보낼 경우 400 Error
	public String boardRegist(BoardCommand boardCommand, HttpServletRequest request) {
		boardWriteService.execute(boardCommand, request); // request로 ip주소를 받아온다. (jsp처럼)
		return "redirect:boardList";
	}
	
	@RequestMapping(value="boardDetail", method=RequestMethod.GET) // doGet에만 있음
	public String boardDetail(@RequestParam(value="num") Integer boardNum, Model model) { // Model : 값을 넘기기 위해 필요
		boardDetailService.execute(model, boardNum);
		return "thymeleaf/board/boardInfo";	
	}
	
	@RequestMapping(value="boardDel", method=RequestMethod.GET)
	public String boardDel(@RequestParam(value="num") Integer boardNum) {
		boardDelService.execute(boardNum);
		return "redirect:boardList";
	}
	
	@RequestMapping("boardUpdate")
	public String boardUpdate(@RequestParam(value="num") Integer boardNum, Model model){
		// boardDetailService와 같지만 수정할 때는 visitCount를 사용하면 안되기 때문에 boardInfoService를 새로 만든다.
		boardInfoService.execute(boardNum, model);
		return "thymeleaf/board/boardDetail";
	}
	
	@RequestMapping(value="boardModify", method=RequestMethod.POST)
	public String boardModify(BoardCommand boardCommand) {
		boardModifyService.execute(boardCommand);
		return "redirect:boardDetail?num="+boardCommand.getBoardNum();
	}
	
}
