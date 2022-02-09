package kosaShoppingMall.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberDelsService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String[] deletes) {
		// 1. 배열 이용
		// memberMapper.memDels(deletes);
		
	/*
		// 2. 리스트 이용
		List<String> cs = new ArrayList<String>();
		for(String num : deletes) {
			cs.add(num);
		}
		memberMapper.memDels2(cs);
	*/
		
	/*
		// 3. 배열을 map에 저장
		HashMap<String, Object> condition = new HashMap<String,Object>();
		condition.put("memberNums", deletes);
		memberMapper.memDels3(condition);
	*/
		
		// 4. 리스트를 map에 저장
		List<String> cs = new ArrayList<String>();
		for(String num : deletes) {
			cs.add(num);
		}
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("memberNums", deletes);
		memberMapper.memDels3(condition);
		
	}
	
}
