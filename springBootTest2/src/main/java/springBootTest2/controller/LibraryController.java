package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.LibraryCommand;
import springBootTest2.service.library.LibraryDelService;
import springBootTest2.service.library.LibraryInfoService;
import springBootTest2.service.library.LibraryInsertService;
import springBootTest2.service.library.LibraryListService;

@Controller
@RequestMapping("lib")
public class LibraryController {
	@Autowired
	LibraryInsertService libraryInsertService;
	@Autowired
	LibraryListService libraryListService;
	@Autowired
	LibraryInfoService libraryInfoService;
	@Autowired
	LibraryDelService libraryDelService;
	
	@RequestMapping("libList")
	public String libList(Model model) {
		libraryListService.execute(model);
		return "thymeleaf/lib/libList";
	}
	
	@RequestMapping("libForm")
	public String libForm() {
		return "thymeleaf/lib/libForm";
	}
	
	@RequestMapping("libWrite")
	public String libWrite(LibraryCommand libraryCommand, HttpSession session, HttpServletRequest request) {
		libraryInsertService.execute(libraryCommand, session, request);
		return "redirect:libList";
	}
	
	@RequestMapping("libInfo")
	public String libInfo(@RequestParam(value="num") Integer libNum, Model model) {
		libraryInfoService.execute(libNum, model);
		return "thymeleaf/lib/libInfo";
	}
	
	@RequestMapping("libDel")
	public String libDel(@RequestParam(value="num") Integer libNum) {
		libraryDelService.execute(libNum);
		return "redirect:libList";
	}
	
	@RequestMapping("libUpdate")
	public String libUpdate() {
		return "";
	}
	
}
