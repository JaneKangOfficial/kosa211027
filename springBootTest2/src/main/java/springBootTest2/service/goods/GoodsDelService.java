package springBootTest2.service.goods;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsDelService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String goodsNum, HttpSession session) {
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		Integer i = goodsMapper.goodsDel(goodsNum);
		
		if(i > 0) {
			String storeFileNames[] = dto.getGoodsImage().split("`");
			String fileDir = session.getServletContext().getRealPath("/view/goods");
			
			for(String fileName : storeFileNames) {
				File file = new File(fileDir + "/" + fileName);
				if(file.exists()) file.delete();
			}
		}
	}
}
