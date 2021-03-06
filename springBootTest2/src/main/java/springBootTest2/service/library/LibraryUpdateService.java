package springBootTest2.service.library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

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
		
		String [] fileNames = null;
		if(dto.getStoreFileName() != null) {
			fileNames = dto.getStoreFileName().split("`");
		}
		
		String filePath = "/view/lib";
		String fileDir = session.getServletContext().getRealPath(filePath);
		
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		
		if(dto.getLibPw().equals(libraryCommand.getLibPw()) && dto.getMemId().equals(authInfo.getUserId())) {
			dto.setLibNum(libraryCommand.getLibNum());
			dto.setLibWriter(libraryCommand.getLibWriter());
			dto.setLibSubject(libraryCommand.getLibSubject());
			dto.setLibContent(libraryCommand.getLibContent());
			dto.setLibPw(libraryCommand.getLibPw());
			
			if(dto.getOriginalFileName() != null) {
				originalTotal = dto.getOriginalFileName();
				storeTotal = dto.getStoreFileName();
				fileSizeTotal = dto.getFileSize();
			}
			
			///
			if(!libraryCommand.getReport()[0].getOriginalFilename().isEmpty()) {
				originalTotal = "";
				storeTotal = "";
				fileSizeTotal = "";
				
				for(MultipartFile mf : libraryCommand.getReport()) {
					String originalFile = mf.getOriginalFilename();
					String extension = originalFile.substring(originalFile.lastIndexOf(".")); // ?????????
					String storeName = UUID.randomUUID().toString().replace("-", "");
					String storeFileName = storeName + extension;
					String fileSize = Long.toString(mf.getSize());
					
					File file = new File(fileDir + "/" + storeFileName);
					try {
						mf.transferTo(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					originalTotal += originalFile + "`";
					storeTotal += storeFileName + "`";
					fileSizeTotal += fileSize + "`";
				}
			}
				
			dto.setFileSize(fileSizeTotal);
			dto.setStoreFileName(storeTotal);
			dto.setOriginalFileName(originalTotal);
			
			Integer i = libraryMapper.libUpdate(dto);
			
			// update??? ??????????????? ????????? ???????????? ?????? ??????
			if(!libraryCommand.getReport()[0].getOriginalFilename().isEmpty()) {
				if(i > 0) {
					File file = null;
					try {
						for(String fileName : fileNames) {
							file = new File(fileDir + "/" + fileName);
							if(file.exists()) file.delete();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			libraryMapper.libUpdate(dto);
			path = "redirect:libInfo?num="+libraryCommand.getLibNum();
		}else {
			model.addAttribute("dto", dto);
			model.addAttribute("err_pw", "??????????????? ???????????? ????????? ???????????? ????????????.");
		}
		return path;
	}
}
