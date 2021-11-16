package collectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("���浿", 35);
		int age = map1.get("���浿");
		System.out.println(age); // 35
		
		Map<Integer, Double> map2 = new HashMap<Integer,Double>();
		map2.put(1, 10.5);
		double d = map2.get(1);
		System.out.println(d); // 10.5
		
		Map<String, Member> map = new HashMap<String, Member>();
		map.put("ȫ�浿", new Member("ȫ�浿", 30));
		map.put("��浿", new Member("��浿", 15));
		map.put("�̱浿", new Member("�̱浿", 27));
		map.put("�ڱ浿", new Member("�ڱ浿", 90));
		
		Member m = map.get("ȫ�浿");
		System.out.println(m.getAge()); // 30
	}

}
