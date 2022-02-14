package kosaShoppingMall.service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsInsertService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(GoodsCommand goodsCommand, HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setVisitCount(goodsCommand.getVisitCount());
		
		// ======== 파일 저장
		String fileDir = "/view/goods/upload";
		String filePath = request.getServletContext().getRealPath(fileDir); // 절대경로 : webapp까지의 경로 + fileDir
		
		// storeFileName으로 변환해서 저장
		if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			MultipartFile mf = goodsCommand.getGoodsMain();
			String originalFile = mf.getOriginalFilename();
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			String storeName = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = storeName + extension;
			File file = new File(filePath + "/" + storeFileName);
			try {
				mf.transferTo(file); // 파일을 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setGoodsMainOrg(originalFile);
			dto.setGoodsMain(storeFileName);
		}
		
		// 여러개 파일 저장
		if(!goodsCommand.getGoodsImages()[0].getOriginalFilename().isEmpty()) {
			String storeTotal = "";
			String originalTotal = "";
			for(MultipartFile mf : goodsCommand.getGoodsImages()) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = storeName + extension; // 저장할 때 사용할 파일명
				
				storeTotal += storeFileName + "`";
				originalTotal += originalFile + "`";
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			dto.setGoodsOriginal(originalTotal);
			dto.setGoodsImages(storeTotal);
		}
		
		Integer i = goodsMapper.goodsInsert(dto);
		System.out.println(i + "개 행이 삽입되었습니다.");
		
	}
}
