package collectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("강길동", 35);
		int age = map1.get("강길동");
		
		Map<Integer, Double> map2 = new HashMap<Integer,Double>();
		map2.put(1, 10.5);
		double d = map2.get(1);
		System.out.println(d);
		
		Map<String, Member> map = new HashMap<String, Member>();
		map.put("홍길동", new Member("홍길동", 30));
		map.put("김길동", new Member("김길동", 30));
		map.put("이길동", new Member("이길동", 30));
		map.put("박길동", new Member("박길동", 30));
		
		Member m = map.get("홍길동");
		
	}

}
