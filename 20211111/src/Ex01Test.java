
public class Ex01Test {

	public static void main(String[] args) {

		Ex01 ex01 = new Ex01();
		Ex01 ex02 = new Ex01();
		
		if (ex01 == ex02) {	// 서로 다른 주소. 다르다!
	  		System.out.println("같다");
	 	}else {
	 		System.out.println("다르다");
	 	}
		
		ex01.first = 20;	// 같은 주소면 같은 값이 나와야 한다.
		System.out.println(ex01.first);
		System.out.println(ex02.first); // 0 // 주소가 다른 서로 다른 객체이기 때문
		
		Singleton s1 = Singleton.getInstance(); // 2000 같은 주소 같은 객체
		Singleton s2 = Singleton.getInstance(); // 2000 같은 주소 같은 객체
		
		if (s1 == s2) {	// 서로 같은 주소. 같다!
	  		System.out.println("같다");
	 	}else {
	 		System.out.println("다르다");
	 	}
		
		
	}

}
