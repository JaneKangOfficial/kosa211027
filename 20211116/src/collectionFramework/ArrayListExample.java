package collectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// 자바 리스트는 배열의 단점인 크기가 고정인 것을 보완해서 만듦
		String str[] = {"나는", "자바가", "너무", "좋아요"};
		System.out.println(str.length);	
		str[3] = "참 좋아요";
//		str[4] = "."; // 배열의 크기는 고정이다.
		// 리스트는 크기가 유동적이다. 배열과 똑같이 같은 타입만 저장할 수 있다.
		List list = new ArrayList();	// 파이썬 리스트와 비슷하다.
		list.add("홍길동");
		list.add("김길동");
		list.add("이길동");
		list.add(1);	// 다른 타입 : 오류는 안 나지만 잘 쓰지 않는다. 가져올 때 데이터 타입마다 분류해서 가져와야 하기 때문
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(3));
		System.out.println("-------");
		for(int i = 0; i < list.size(); i++ ) { 
			System.out.println(list.get(i));
		}
		System.out.println("-------");
		for(Object obj : list) {
			System.out.println(obj);
		}
		System.out.println("-------");
		
		List<String> list1 = new ArrayList<String>();	// String 타입만 저장하겠다.
		list1.add("홍길동1");
		list1.add("김길동1");
		list1.add("이길동1");
		for(String s : list1) {
			System.out.println(s);
		}
		System.out.println("-------");
		
		int i = 10;
		Object obj1 = 10;
		System.out.println(obj1);
		String st = "박길동";
		obj1 = "박길동";
		System.out.println(obj1);
		double d = 10.5;
		obj1 = 10.5;
		System.out.println(obj1);
		
		// 많이 사용한다.
		obj1 = new Calu();
		Calu calu = (Calu)obj1;	// 강제형변환
		calu.setFirst(10); 
		System.out.println(calu.getFirst());
		
	}
}
