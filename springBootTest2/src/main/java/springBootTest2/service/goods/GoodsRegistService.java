package springBootTest2.service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsRegistService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand, HttpSession session, HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		String empId = authInfo.getUserId();
		Integer empNum = goodsMapper.selectEmpNum(empId);
				
		dto.setEmpNum(empNum);
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsDate(goodsCommand.getGoodsDate());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsQty(goodsCommand.getGoodsQty());
		dto.setGoodsCompany(goodsCommand.getGoodsCompany());
		
		//=================================
		String storeTotal = "";
		String filePath = "/view/goods";
		String fileDir = request.getServletContext().getRealPath(filePath);
		
		for(MultipartFile mf : goodsCommand.getGoodsImage()) {
			String originalFileName = mf.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
			
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = store + extension;
			
			File file = new File(fileDir + "/" + storeFileName);
			
			System.out.println("fileeeeeeeeeeeeeeee " + file);
			
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			storeTotal += storeFileName+ "`";			
			
		}
		
		dto.setGoodsImage(storeTotal);
		
		goodsMapper.goodsInsert(dto);
		
	}
}
