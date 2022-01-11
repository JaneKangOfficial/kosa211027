package main.DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.DTO.MemberDTO;

/*
 * 의존객체 문제점 : 의존객체명 변경시 하나하나 바꿔야 한다.
 * 문제점 해결을 위해 의존객체 주입
 */
public class CachedMemberDAO {
	static long nextId = 0; // static : 변수 유지
	
	// DAO가 종료되어도 map은 사라지지 않도록 static으로 유지, 계속 데이터 쌓도록 변수 유지
	static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();
	
	public void insert(MemberDTO dto) {
		dto.setId(++nextId);
		map.put(dto.getEmail(), dto);
	}

	public Collection<MemberDTO> selectAll() {
		return map.values(); // value만 list(Collection) 형태로 가져온다.
	}
	
	public MemberDTO selectByEmail(String email) {
		return map.get(email);
	}
	
	public void update(MemberDTO dto) {
		// map 에서의 update는 put (키가 같으면 update 없으면 insert)
		map.put(dto.getEmail(), dto); 
	}
}
