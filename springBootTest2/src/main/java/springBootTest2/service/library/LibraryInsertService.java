package springBootTest2.service.library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.LibraryCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibraryDTO;
import springBootTest2.mapper.LibraryMapper;

@Component
@Service
public class LibraryInsertService {
	@Autowired
	LibraryMapper libraryMapper;
	
	public void execute(LibraryCommand libraryCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		LibraryDTO dto = new LibraryDTO();
		dto.setLibWriter(libraryCommand.getLibWriter());
		dto.setLibSubject(libraryCommand.getLibSubject());
		dto.setLibContent(libraryCommand.getLibContent());
		dto.setLibPw(libraryCommand.getLibPw());
		dto.setMemId(authInfo.getUserId());
		dto.setIpAddr(request.getRemoteAddr());
		
		//========================================= 파일 업로드
		// 파일 정보를 입력하기 위한 변수 
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String fileDir = "/view/lib"; // spring boot는 .metaData가 없어서 이 경로에 저장된다.
		String filePath = request.getServletContext().getRealPath(fileDir);
		
		if(!libraryCommand.getReport()[0].getOriginalFilename().isEmpty()) {
			for(MultipartFile mf : libraryCommand.getReport()) {
				String originalFile = mf.getOriginalFilename();
				// .확장자 substring
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
				// UUID : 유니크 아이디 api 	
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = storeName + extension;
				String fileSize = Long.toString(mf.getSize()); // 파일크기 
				
				originalTotal += originalFile + "`";
				storeTotal += storeFileName + "`";
				fileSizeTotal += fileSize + "`";
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf.transferTo(file); // 파일을 저장
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		dto.setFileSize(fileSizeTotal);
		dto.setOriginalFileName(originalTotal);
		dto.setStoreFileName(storeTotal);
		
		libraryMapper.libInsert(dto);
	}
}
