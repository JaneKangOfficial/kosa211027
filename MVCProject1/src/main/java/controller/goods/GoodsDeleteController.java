package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsDeleteController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		
		// 그림 삭제 후 DB 삭제
		// goodsNum을 이용해서 파일 정보 가져오기
		GoodsDAO dao = new GoodsDAO();
		String goodsImages = dao.getImages(goodsNum);
		String[] fileImages = goodsImages.split("`");
		if(fileImages.length >= 1) {
			// 파일의 절대 경로 디렉터리를 가져옴
			String path = "/goods/upload";
			String realPath = request.getServletContext().getRealPath(path);
			File file = null;
			for(String fileName : fileImages) {
				// 파일명만으로는 삭제할 수 없다. 경로가 있어야 한다. (절대 경로 + 파일명)
				file = new File(realPath + "/" + fileName);
				if(file.exists()) file.delete();
			}
		}
		dao.goodsDelete(goodsNum);
		
	}
}
