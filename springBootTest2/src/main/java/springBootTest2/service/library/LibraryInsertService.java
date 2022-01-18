package springBootTest2.service.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.LibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;

@Component
@Service
public class LibraryInsertService {
	@Autowired
	LibraryMapper libraryMapper;
	
	public void execute(LibraryCommand libraryCommand, HttpSession session, HttpServletRequest request) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		LibraryDTO dto = new LibraryDTO();
		dto.setLibWriter(libraryCommand.getLibWriter());
		dto.setLibSubject(libraryCommand.getLibSubject());
		dto.setLibContent(libraryCommand.getLibContent());
		dto.setLibPw(libraryCommand.getLibPw());
		dto.setMemId(authInfo.getUserId());
		dto.setIpAddr(request.getRemoteAddr());
		
		libraryMapper.libInsert(dto);
	}
}
