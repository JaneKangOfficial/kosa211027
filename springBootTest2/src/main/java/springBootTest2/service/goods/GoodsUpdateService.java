package springBootTest2.service.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(GoodsCommand goodsCommand, HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsDate(goodsCommand.getGoodsDate());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsQty(goodsCommand.getGoodsQty());
		dto.setGoodsCompany(goodsCommand.getGoodsCompany());
		
		//=====================
		// 파일 저장
		GoodsDTO dto2 = goodsMapper.selectOne(goodsCommand.getGoodsNum());
		String[] storeFileNames = dto2.getGoodsImage().split("`");
		
		String storeTotal = "";
		String filePath = "/view/goods";
		String fileDir = request.getServletContext().getRealPath(filePath);
		System.out.println(request.getServletContext());
		System.out.println("11111 "+request.getServletContext());
		System.out.println("22222 "+request.getServletContext().getRealPath(filePath));
		
		for(MultipartFile mf : goodsCommand.getGoodsImage()) {
			String originalFile = mf.getOriginalFilename();
			//.hwp
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = store + extension;
			
			File file = new File(fileDir + "/" + storeFileName);
			
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
			storeTotal += storeFileName + "`";
		}
		dto.setGoodsImage(storeTotal);
		
		// 파일 삭제
		Integer i = goodsMapper.goodsUpdate(dto);
		if(i > 0) {
			
			for(String fileName : storeFileNames) {
				File file = new File(fileDir + "/" + fileName); 
				if(file.exists()) file.delete();
			}
		}
	}
}
