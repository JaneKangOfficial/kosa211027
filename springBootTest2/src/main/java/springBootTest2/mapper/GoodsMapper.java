package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.GoodsDTO;

@Component
@Repository(value="springBootTest2.mapper.GoodsMapper")
public interface GoodsMapper {
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> selectAll();
	public GoodsDTO selectOne(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDel(String goodsNum);
	public String selectNum();
	public Integer selectEmpNum(String empId);

}
