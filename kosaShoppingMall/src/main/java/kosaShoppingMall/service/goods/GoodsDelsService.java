package kosaShoppingMall.service.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsDelsService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String[] deletes) {
		// 1. 배열을 이용한 방법
		// goodsMapper.goodsDels(deletes);
		
	/* 
		// 2. 리스트를 전달하는 방법 : 배열이 있어야 리스트를 만드는 것이 아니다. 배열을 이용해서 리스트를 만든 것뿐이다.
		
		List<String> cs = new ArrayList<String>();
		for(String num: deletes) {
			cs.add(num);
		}
		goodsMapper.goodsDeletes(cs);
	*/
		
	/*
		// 3. 배열을 map에 저장하여 전달하는 방법
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("goodsNums", deletes);
		goodsMapper.goodsRemove(condition);
	*/
		
		// 4. list를 map에 저장하여 전달하는 방법
		List<String> cs = new ArrayList<String>();
		for(String num: deletes) {
			cs.add(num);
		}
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("goodsNums", cs);
		goodsMapper.goodsRemove(condition);
		
	}
}
