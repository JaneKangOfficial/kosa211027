package springBootTest2.service.library;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Component
@Service
public class FileDownLoadService {
	public void fileDownLoad(String sfileName, String ofileName, HttpServletRequest request, HttpServletResponse response) {
		String path = "/view/lib";
		String RealPath = request.getServletContext().getRealPath(path);
		
		String originalFileName = null;
		try {
			originalFileName = URLEncoder.encode(ofileName,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/octet-stream;charset=utf-8"); // 파일 다운
		response.setHeader("Content-Disposition", "attachment;filename="+originalFileName+";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		File file = new File(RealPath + "/" + sfileName); // 파일 객체
		
		// 웹브라우저로 보내기 위해
		ServletOutputStream out1 = null;
		FileInputStream fis = null;
		
		try {
			out1 = response.getOutputStream();
			fis = new FileInputStream(file);
			
			// fis가 가지고 있는 파일을 out1에 복사해주고 웹브라우저로 전송
			FileCopyUtils.copy(fis, out1);
			
			response.flushBuffer();
			out1.flush();
			out1.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try{
					fis.close();
				}catch(Exception e){}
			}
			
		}
		
	}
}
