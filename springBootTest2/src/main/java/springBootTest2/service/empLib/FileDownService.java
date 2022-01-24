package springBootTest2.service.empLib;

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
public class FileDownService {
	public void execute(String sfile, String ofile, HttpServletRequest request, HttpServletResponse response) {
		String filePath = "/view/empLib";
		String fileDir = request.getServletContext().getRealPath(filePath);
		String originalFileName = null;
		
		try {
			originalFileName = URLEncoder.encode(ofile, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 0과 1의 형태(binary) = stream
		//response.setContentType("application/hwp; charset=UTF-8");
		response.setContentType("application/octet-stream; charset=UTF-8");
		// 이름
		response.setHeader("Content-Disposition", "attachment;fileName="+originalFileName+";");
		// 데이터 형태
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		File file = new File(fileDir + "/" + sfile);
		
		//response로 받은 것을 보내기 위해 OutputStream이 필요
		ServletOutputStream out1 = null;
		FileInputStream fis = null;
		
		try {
			out1 = response.getOutputStream(); // response를 이용해서 output 객체를 전송
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out1); // fis를 out1을 통해 웹브라우저로 전송
			
			response.flushBuffer();
			out1.flush();
			out1.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if(fis != null) {try{fis.close();} catch(Exception e) {}}}
		
	}
}
