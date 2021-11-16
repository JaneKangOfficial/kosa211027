package collectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Map �÷���
public class HashMapExample1 {

	public static void main(String[] args) {
	
		// ���̽� ��ųʸ� dic = {"a":1, "b":2} : Map
		// print(dic["a"]) // dic.keys()
		
		// �÷���
		List<String> list = new ArrayList<String>(); // ��� -> �÷���
		list.add("ȫ�浿");
		
		// Map �÷��� ���� : Map<Ű,��>
		// 	  Ű			��
		Map<String, Integer> map = new HashMap<String, Integer>(); // Ű , ��� -> ��
		
		// ��ü ����
		map.put("ȫ�浿", 35);
		map.put("��浿", 55);
		map.put("�̱浿", 88);
		map.put("�ڱ浿", 25);
		map.put("ȫ�浿", 95); // �ߺ� Ű�� ������� �ʴ´�. // ���� �����ȴ�.
		System.out.println("map�� ũ�� : " + map.size()); // 4
		System.out.println("ȫ�浿�� ���̴� " + map.get("ȫ�浿") + "�� �Դϴ�.");
	
		map.put("��浿", 16);	// Ű�� ���� ������ �� �ִ�.
		
		Set<String> keySet = map.keySet();	// Ű�� �����ϸ� Set �ڷ������� �����´�.
		for(String key : keySet) {
//			System.out.println(map.get(key));
			System.out.println(key + "�� ���̴� " + map.get(key) + "�� �Դϴ�.");
		}
		
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(map.get(key));
		}

		System.out.println("==============================");
		
		map.remove("ȫ�浿");
		System.out.println(map.size()); // 3
		
		map.clear();
		System.out.println(map.size()); // 0
		System.out.println(map.isEmpty()); // true
		
	}
	
}

/*
 *  ���̽�
 *  l.append(3)
 *  l.append(4)
 *  l.append(5)
 *  # ����Ʈ, Ʃ��, ��ųʸ�, �����ڷ���(set)
 *  
 *  �ڹ�
 *  List<Integer> l = new ArrayList<Integer>();
 *  l.add(1)		// ����Ʈ,		map,	set
 *  l.add(2)
 *  l.add(3)
 *  // ����Ʈ, set, map
 * 
 */

