package collectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 기본자료형, String, Integer(Wrapper), 배열, class, list, set, map
public class HashSetExample1 {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		set.add("홍길동");		// 순서에 영향을 받지 않는다. (= 파이썬의 집합자료형 set 자료형 순서 영향 받지 않고 중복값 허용하지 않음) 
		set.add("김길동");
		set.add("이길동");
		set.add("박길동");
		set.add("박길동");		// set에서 같은 값은 저장되지 않는다. (list는 같은 값 저장된다.)
		int size = set.size();
		System.out.println(size);	// 4
		
		System.out.println("---------");
		
		Iterator iterator =  set.iterator();
		while(iterator.hasNext()) {
			String s = (String)iterator.next();
			System.out.println(s);	// 중복값은 출력되지 않는다.
		}
		
		System.out.println("---------");
		
		set.remove("김길동");
		size = set.size();
		System.out.println(size);	// 3
		
		System.out.println("---------");

		for(String s : set) {
			System.out.println(s);
		}

	}

}
