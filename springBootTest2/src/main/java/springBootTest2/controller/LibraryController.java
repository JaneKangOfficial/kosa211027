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
import springBootTest2.service.library.LibraryUpdateService;

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
	@Autowired
	LibraryUpdateService libraryUpdateService;
	
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
	public String libWrite(LibraryCommand libraryCommand, HttpServletRequest request) {
		libraryInsertService.execute(libraryCommand, request);
		return "redirect:libList";
	}
	
	@RequestMapping("libInfo")
	public String libInfo(@RequestParam(value="num") Integer libNum, Model model,
			HttpSession session) {
		libraryInfoService.execute(libNum, model);
		session.removeAttribute("err_pw");
		return "thymeleaf/lib/libInfo";
	}
	
	@RequestMapping("libDelPass")
	public String libDelPass(@RequestParam(value="num") Integer libNum, Model model) {
		model.addAttribute("aaa", libNum);
		return "thymeleaf/lib/libDel";
	}
	
	@RequestMapping(value="libDel")
	public String libDel(LibraryCommand libraryCommand, Model model, HttpSession session) {
		String path = libraryDelService.execute(libraryCommand, model, session);
		return path;
	}
	
	@RequestMapping("libUpdate")
	public String libUpdate(@RequestParam(value="num") Integer libNum, Model model) {
		libraryInfoService.execute(libNum, model);
		return "thymeleaf/lib/libUpdate";
	}
	
	@RequestMapping("libUpdateOk")
	public String libUpdateOk(LibraryCommand libraryCommand, Model model, HttpSession session) {
		String path = libraryUpdateService.execute(libraryCommand, model, session);
		return path;
	}
	
}
