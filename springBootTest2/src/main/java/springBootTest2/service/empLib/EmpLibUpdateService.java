package springBootTest2.service.empLib;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibUpdateService {
	@Autowired
	EmpLibMapper empLibMapper;
	
	public String execute(EmpLibCommand empLibCommand, HttpServletRequest request, Model model) {
		String path = "thymeleaf/empLib/empLibUpdate";
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empLibMapper.selectEmpNum(empId);
		
		Integer libNum = empLibCommand.getLibNum();
		EmpLibDTO dto = empLibMapper.selectOne(libNum); 
				
		if(dto.getLibPw().equals(empLibCommand.getLibPw()) && dto.getEmpNum().equals(empNum)) {
			dto.setEmpNum(empNum);
			dto.setLibNum(empLibCommand.getLibNum());
			dto.setLibWriter(empLibCommand.getLibWriter());
			dto.setLibSubject(empLibCommand.getLibSubject());
			dto.setLibContent(empLibCommand.getLibContent());
			dto.setLibPw(empLibCommand.getLibPw());
	
			//====================
			// 옛날 정보 불러오기
			String [] storeFileNames = null;
			if(dto.getStoreFileName() != null ) {
				storeFileNames = dto.getStoreFileName().split("`");
			}
			
			// 파일 저장
			String originalTotal = "";
			String storeTotal = "";
			String fileSizeTotal = "";
			String filePath = "/view/empLib";
			String fileDir = request.getServletContext().getRealPath(filePath);
			
			for(MultipartFile mf : empLibCommand.getReport()) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
			
				String store = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = store+extension;
				String fileSize = (Long.toString(mf.getSize()));
				
				File file = new File(fileDir + "/" + storeFileName);
				
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				originalTotal += originalFile + "`";
				storeTotal += storeFileName+ "`";
				fileSizeTotal += fileSize + "`";
			}
			
			dto.setOriginalFileName(originalTotal);
			dto.setStoreFileName(storeTotal);
			dto.setFileSize(fileSizeTotal);
			
			Integer i = empLibMapper.libUpdate(dto);
			
			if(i > 0) {
				// 파일 삭제
				for(String fileName : storeFileNames) {
					File file = new File(fileDir + "/" + fileName);
					
					if(file.exists()) file.delete();
				}
			}
			
			path = "redirect:libInfo?num="+empLibCommand.getLibNum();
		}else {
			model.addAttribute("dto", dto);
			model.addAttribute("err_pw", "비밀번호가 일치하지 않거나 작성자가 아닙니다.");
		}
		return path;
	}
	
}
