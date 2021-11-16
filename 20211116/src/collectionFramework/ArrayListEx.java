package collectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {

		List list = new ArrayList();
		list.add("가나다");	// Object
		list.add("라마바");
		list.add("사아자");
		list.add("사아자");	// list에서는 같은 값 저장 된다. (set에서는 안된다.)
		list.set(3, "황길동"); // list에 있는 값 수정
		
		// 많이 사용한다. Object타입이기 때문에 꼭 형변환 후 사용
		for(int i = 0; i < list.size(); i++) {
			String s = (String)list.get(i);	// Object타입을 String으로 변환하겠다.
			System.out.println(s);
		}
		
		// Object로 저장된 경우 아래처럼 사용하지 않는다. (형변환 하지 않고)
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 많이 사용한다. Integer만 사용했으므로 형변환 없이 사용해도 된다.
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// 리스트에 있는 값을 삭제
		list1.remove(0);
		System.out.println(list1.size());

		System.out.println("-------------------");
		System.out.println(list.size());
		for(Object obj : list) {
			String s = (String)obj;
			System.out.println(s);
		}
		// 리스트에 있는 값을 삭제
		list.remove(2);
		System.out.println(list.size());
		list.remove("라마바");
		System.out.println(list.size());
//		list.removeAll(list); // removeAll 보다는 clear 사용
		list.clear();
		System.out.println(list.size());
		System.out.println(list.isEmpty()); 	// true 비어있음
		
		list.add("홍길동");
		System.out.println(list.isEmpty()); 	// false 비어있지 않음
		
		// List : add, remove, size, isEmpty, removeAll 대신 clear
	
	}
}

/* 
 *	기본자료형 (기본자료형 제외, 전부 API이다.)
 *	문자열
 *	배열 : 크기가 정해져있다. 같은 유형의 데이터. index 사용.
 *	사용자 자료형 : class
 *	Integer(Wrapper) 
 *	컬렉션(list, set, map) : 크기가 정해져있지 않다. add, remove. 같은 유형의 데이터를 저장한다. index 사용.
 * 
*/