package controller.goods;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.EmployeeDAO;
import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsUpdateController {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "/goods/upload";
		String realPath = request.getServletContext().getRealPath(path);
		int fileSize = 1024 * 1024 * 5;
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		// 직원 id를 이용해서
		EmployeeDAO dao = new EmployeeDAO();
		// 직원 번호 가져오기
		String empNum = dao.selectEmpNum(authInfo.getUserId());
		String ipAddr = request.getRemoteAddr();
		
		// MultipartRequest를 사용하기 위해 cos.jar 사용
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());
		String goodsNum = multi.getParameter("goodsNum");
		String goodsName = multi.getParameter("goodsName");
		String goodsPrice = multi.getParameter("goodsPrice");
		String goodsContent = multi.getParameter("goodsContent");
		String goodsQty = multi.getParameter("goodsQty");
		String goodsCompany= multi.getParameter("goodsCompany");
		String img1 = multi.getFilesystemName("img1");
		String img2 = multi.getFilesystemName("img2");
		String img3 = multi.getFilesystemName("img3");
		String goodsDate = multi.getParameter("goodsDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(goodsDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp gDate = new Timestamp(date.getTime());
		
		// 기존 파일 삭제 후 update
		// 파일 삭제
		GoodsDAO dao1 = new GoodsDAO();
		String goodsImages = dao1.getImages(goodsNum);
		// 파일명 split
		String[] fileImages = goodsImages.split("`");
		if(fileImages.length >= 1) {
			File file = null;
			for(String fileName : fileImages) {
				file = new File(realPath + "/" + fileName);
				if(file.exists()) {
					file.delete();
				}
			}
		}
		
		GoodsDTO dto = new GoodsDTO();
		dto.setEmpNum(empNum);
		dto.setGoodsCompany(goodsCompany);
		dto.setGoodsContent(goodsContent);
		dto.setGoodsDate(gDate);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(goodsNum);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsQty(Integer.parseInt(goodsQty));
		dto.setIpAddr(ipAddr);
		dto.setGoodsImages(img1 + "`" + img2 + "`" + img3);
		dao1.goodsUpdate(dto);
		
		response.sendRedirect("goodsInfo.gd?num=" + goodsNum);
	}
}
