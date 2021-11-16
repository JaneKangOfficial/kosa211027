package collectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {

	public static void main(String[] args) {

		Set<Member> set = new HashSet<Member>();
		set.add(new Member("홍길동", 30));		// Member
		set.add(new Member("김길동", 50));		// Member
		System.out.println(set.size());

		// Set을 이용해서 데이터를 저장했을 경우 Iterator를 이용해서 가져와야 한다.
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m.getName());
			if(m.getName().equals("김길동")) {
				set.remove(m);
				break;
			}
		}
		System.out.println(set.size());
		
		for(Member m : set) {
			if(m.getName().equals("이길동")) {
				set.remove(m);
				break;
			}
		}
		System.out.println(set.size());
		
		set.clear();
		System.out.println(set.isEmpty());
		
		
	}

}
