package springBootTest2.service.library;

import java.io.File;

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
public class LibraryDelService {
	@Autowired
	LibraryMapper libraryMapper;
	
	public String execute(LibraryCommand libraryCommand, Model model, HttpSession session) {
		String path = null;
		Integer libNum = libraryCommand.getLibNum();
		LibraryDTO dto = libraryMapper.selectOne(libNum);
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		if(dto.getLibPw().equals(libraryCommand.getLibPw()) && dto.getMemId().equals(authInfo.getUserId())) {
			session.removeAttribute("err_pw");
			Integer i = libraryMapper.libDel(libNum);
			if(i > 0 && dto.getStoreFileName() != null) {
				// split을 하면 배열이 된다. -> for문으로 출력
				String[] fileNames = dto.getStoreFileName().split("`");
				
				// filePath로 fileDir을 가져온다.
				String filePath = "/view/lib";
				String fileDir = session.getServletContext().getRealPath(filePath);
				
				File file = null;  // 파일 객체
				try {
					for(String fileName : fileNames) {
						file = new File(fileDir + "/" + fileName); // 파일
						if(file.exists()) file.delete(); // 파일이 존재하면 삭제
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			path = "redirect:libList";
		}else {
			session.setAttribute("err_pw","비밀번호가 일치하지 않거나 작성자가 아닙니다.");
			path = "redirect:libDelPass?num="+dto.getLibNum();
		//session.removeAttribute("err_pw")를 하기 위해서는 redirect보다는 html 파일을 불러오는 것(thymeleaf)이 좋다.
		}
		return path;
	}
}
