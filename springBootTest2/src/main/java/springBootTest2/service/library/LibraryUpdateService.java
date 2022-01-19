package springBootTest2.service.library;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.LibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;

@Component
@Service
public class LibraryUpdateService {
	@Autowired
	LibraryMapper libraryMapper;
	
	public String execute(LibraryCommand libraryCommand, Model model, HttpSession session) {
		
		String path = "thymeleaf/lib/libUpdate";
		Integer libNum = libraryCommand.getLibNum();
		LibraryDTO dto = libraryMapper.selectOne(libNum);
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		if(dto.getLibPw().equals(libraryCommand.getLibPw()) && dto.getMemId().equals(authInfo.getUserId())) {
			dto.setLibNum(libraryCommand.getLibNum());
			dto.setLibWriter(libraryCommand.getLibWriter());
			dto.setLibSubject(libraryCommand.getLibSubject());
			dto.setLibContent(libraryCommand.getLibContent());
			dto.setLibPw(libraryCommand.getLibPw());
			libraryMapper.libUpdate(dto);
			path = "redirect:libInfo?num="+libraryCommand.getLibNum();
		}else {
			model.addAttribute("dto", libraryCommand);
			model.addAttribute("err_pw", "비밀번호가 일치하지 않거나 작성자가 아닙니다.");
		}
		return path;
	
	}
}
