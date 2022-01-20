package springBootTest2.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmployeeDTO;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.EmployeeMapper;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsRegistService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand, HttpSession session) {
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
		
		goodsMapper.goodsInsert(dto);
		
	}
}
