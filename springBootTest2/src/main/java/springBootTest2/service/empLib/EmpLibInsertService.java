package springBootTest2.service.empLib;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibInsertService {
	@Autowired
	EmpLibMapper empLibMapper;
	
	public void execute(EmpLibCommand empLibCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empLibMapper.selectEmpNum(empId);
		
		EmpLibDTO dto = new EmpLibDTO();
		dto.setEmpNum(empNum);
		dto.setLibWriter(empLibCommand.getLibWriter());
		dto.setLibSubject(empLibCommand.getLibSubject());
		dto.setLibContent(empLibCommand.getLibContent());
		dto.setLibPw(empLibCommand.getLibPw());
		dto.setIpAddr(request.getRemoteAddr());
		
		//================================================= 파일 업로드
		// 파일 정보를 입력하기 위한 변수
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String path = "/view/empLib";
		// C:/Users/user/workspace/eclipse-workspace/kosa211027/springBootTest2/src/main/webapp/view/empLib
		// 파일 저장을 위한 empLib의 전체경로, 서버 컴퓨터에서도 경로가 달라도 가능하게 하기 위해서 realPath(webapp까지의 주소) 사용
		String fileDir = request.getServletContext().getRealPath(path);
		System.out.println("fileDir : " + fileDir);
		
		for(MultipartFile mf : empLibCommand.getReport()) {
			String original = mf.getOriginalFilename();
			String extension = original.substring(original.lastIndexOf("."));
			
			// 중복 파일명이 있을 경우를 대비하여 유일한 이름의 파일명을 생성
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = store+extension;
			
			// 파일 저장
			File file = new File(fileDir + "/" + storeFileName);
			
			String fileSize = (Long.toString(mf.getSize()));
			
			// 파일 전송
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// DB에 저장
			originalTotal += original + "`"; // 파일이 여러개일 경우 "`" 구분자로 구분
			storeTotal += storeFileName + "`";
			fileSizeTotal += fileSize + "`";
			
		}
		
		dto.setOriginalFileName(originalTotal);
		dto.setStoreFileName(storeTotal);
		dto.setFileSize(fileSizeTotal);		
		
		empLibMapper.empLibInsert(dto);
		
	}
}
