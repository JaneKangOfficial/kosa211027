package collectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("���浿", 35);
		int age = map1.get("���浿");
		
		Map<Integer, Double> map2 = new HashMap<Integer,Double>();
		map2.put(1, 10.5);
		double d = map2.get(1);
		System.out.println(d);
		
		Map<String, Member> map = new HashMap<String, Member>();
		map.put("ȫ�浿", new Member("ȫ�浿", 30));
		map.put("��浿", new Member("��浿", 30));
		map.put("�̱浿", new Member("�̱浿", 30));
		map.put("�ڱ浿", new Member("�ڱ浿", 30));
		
		Member m = map.get("ȫ�浿");
		
	}

}
