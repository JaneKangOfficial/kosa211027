package collectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {

		Set<Member> set = new HashSet<Member>();
		set.add(new Member("ȫ�浿", 30));		// Member
		set.add(new Member("��浿", 50));		// Member
		System.out.println(set.size());		// 2

		// Set�� �̿��ؼ� �����͸� �������� ��� Iterator�� �̿��ؼ� �����;� �Ѵ�.
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m.getName());	// ��浿
			if(m.getName().equals("��浿")) {
				set.remove(m);
				break;
			}
		}
		System.out.println(set.size());		// 1
		
		for(Member m : set) {
			if(m.getName().equals("ȫ�浿")) {
				set.remove(m);
				break;
			}
		}
		System.out.println(set.size());		// 0
		
		set.clear();
		System.out.println(set.isEmpty());	// true
		
		
	}

}
