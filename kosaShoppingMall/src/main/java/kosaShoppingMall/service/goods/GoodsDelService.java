package kosaShoppingMall.service.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsDelService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String goodsNum, HttpServletRequest request) {
		
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		// 데이터베이스에서 삭제 후 파일도 삭제해야 한다. 중요한 코드! =================
		Integer i = goodsMapper.goodsDel(goodsNum);
		if(i > 0) {
			String fileDir = "/view/goods/upload";
			String filePath = request.getServletContext().getRealPath(fileDir);
			
			if(dto.getGoodsImages() != null) {
				String[] fileNames = dto.getGoodsImages().split("`");
				for(String fileName : fileNames) {
					File f = new File(filePath + "/" + fileName);
					if(f.exists()) {
						f.delete();
					}
				}
			}
			
			String file = dto.getGoodsMain();
			File f = new File(filePath + "/" + file);
			if(f.exists()) {
				f.delete();
			}
			System.out.println(i + "개 행이 삭제되었습니다.");
		}
	}
}
