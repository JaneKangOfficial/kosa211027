package collectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Map 컬렉션
public class HashMapExample1 {

	public static void main(String[] args) {
	
		// 파이썬 딕셔너리 dic = {"a":1, "b":2} : Map
		// print(dic["a"]) // dic.keys()
		
		// 컬렉션
		List<String> list = new ArrayList<String>(); // 밸류 -> 컬렉션
		list.add("홍길동");
		
		// Map 컬렉션 생성 : Map<키,값>
		// 	  키			값
		Map<String, Integer> map = new HashMap<String, Integer>(); // 키 , 밸류 -> 맵
		
		// 객체 저장
		map.put("홍길동", 35);
		map.put("김길동", 55);
		map.put("이길동", 88);
		map.put("박길동", 25);
		map.put("홍길동", 95); // 중복 키를 허용하지 않는다. // 값이 수정된다.
		System.out.println("map의 크기 : " + map.size()); // 4
		System.out.println("홍길동의 나이는 " + map.get("홍길동") + "살 입니다.");
	
		map.put("김길동", 16);	// 키로 값을 수정할 수 있다.
		
		Set<String> keySet = map.keySet();	// 키를 추출하면 Set 자료형으로 가져온다.
		for(String key : keySet) {
//			System.out.println(map.get(key));
			System.out.println(key + "의 나이는 " + map.get(key) + "살 입니다.");
		}
		
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(map.get(key));
		}

		System.out.println("==============================");
		
		map.remove("홍길동");
		System.out.println(map.size()); // 3
		
		map.clear();
		System.out.println(map.size()); // 0
		System.out.println(map.isEmpty()); // true
		
	}
	
}

/*
 *  파이썬
 *  l.append(3)
 *  l.append(4)
 *  l.append(5)
 *  # 리스트, 튜플, 딕셔너리, 집합자료형(set)
 *  
 *  자바
 *  List<Integer> l = new ArrayList<Integer>();
 *  l.add(1)		// 리스트,		map,	set
 *  l.add(2)
 *  l.add(3)
 *  // 리스트, set, map
 * 
 */

