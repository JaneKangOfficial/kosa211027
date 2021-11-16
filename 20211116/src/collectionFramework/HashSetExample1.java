package collectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// �⺻�ڷ���, String, Integer(Wrapper), �迭, class, list, set, map
public class HashSetExample1 {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		set.add("ȫ�浿");		// ������ ������ ���� �ʴ´�. (= ���̽��� �����ڷ��� set �ڷ��� ���� ���� ���� �ʰ� �ߺ��� ������� ����) 
		set.add("��浿");
		set.add("�̱浿");
		set.add("�ڱ浿");
		set.add("�ڱ浿");		// set���� ���� ���� ������� �ʴ´�. (list�� ���� �� ����ȴ�.)
		int size = set.size();
		System.out.println(size);	// 4
		
		System.out.println("---------");
		
		Iterator iterator =  set.iterator();
		while(iterator.hasNext()) {
			String s = (String)iterator.next();
			System.out.println(s);	// �ߺ����� ��µ��� �ʴ´�.
		}
		
		System.out.println("---------");
		
		set.remove("��浿");
		size = set.size();
		System.out.println(size);	// 3
		
		System.out.println("---------");

		for(String s : set) {
			System.out.println(s);
		}

	}

}
