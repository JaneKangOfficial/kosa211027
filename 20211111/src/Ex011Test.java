
public class Ex011Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();	// 		stack				heap
		Ex01 ex02 = ex01;		//	ex01	1000		1000 | first | second |
								//	ex02	1000
		Ex01 ex03 = new Ex01();	//	ex03	2000		2000 | first | second |
		
		ex01.first = 30;
		System.out.println(ex01.first);	// 30
		System.out.println(ex02.first);	// 30
		System.out.println(ex03.first);	// 0
		
		if(ex01 == ex02) {	// 서로 같은 주소 : 같은 객체
			System.out.println("ex01과 ex02는 같은 객체이다.");
		}else {
			System.out.println("다른 객체이다.");
		}
		
		if(ex01 == ex03) {	// 서로 다른 주소 : 다른 객체
			System.out.println("같은 객체이다.");
		}else {
			System.out.println("ex01과 ex03은 다른 객체이다.");
		}
		
		// static 키워드가 있는 멤버 변수는 객체 생성없이 클래스명으로 사용할 수 있다.
//		int result = Singleton.val;	 // private 이기 때문에 외부에서 직접 접근은 불가.
//		Singleton s = Singleton.singleton;	// private
		Singleton s = Singleton.getInstance(); // s = 3000 주소
		Singleton s1 = Singleton.getInstance(); // s1 = 3000 주소
		
		if(s == s1) {	// 서로 같은 주소 : 같은 객체
			System.out.println("s와 s1은 같은 객체이다.");
		}else {
			System.out.println("s와 s1은 다른 객체이다.");
		}
		
		
	}

}
