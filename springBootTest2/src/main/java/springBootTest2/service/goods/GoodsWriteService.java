package springBootTest2.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(Model model) {
		String num = goodsMapper.selectNum();
		model.addAttribute("num", num);
	}
}
