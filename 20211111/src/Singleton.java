
public class Singleton {
	
	int first;
	int second;
	
	// 싱글톤 
	private static 	  int	 	val    =	10;
	// 싱글톤으로 사용할 경우 클래스내에 자기자신을 생성 private
	// 자기 자신의 객체를 미리 만들어 놓고 사용 private
	private static Singleton singleton = new Singleton(); // 주소 3000 
	private Singleton() {}
	// 						aaa도 상관없지만 개발자들끼리의 약속 getInstance()
	public static Singleton getInstance() { // 자신의 객체를 전달
		return singleton;	// 반환
	}

	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	/*
	 * data (Method)
	 * Singleton {
	 * 		int first;
	 * 		int second;
	 * 		static Singleton singleton = new Singleton();
	 * 		// static Singleton singleton = 2000; // 주소
	 * 		// public static Singleton getInstance() {
	 * 				return singleton;
	 * 			}
	 * }
	 * System.out.println(Singleton.singleton);	// 2000
	 * System.out.println(Singleton.getInstance()); // 2000
	 * 
	 * 
	 * Ex01 {
	 * 		int age;
	 * 		String name;
	 * 		static String addr = 10;	// data영역에 있는 변수 // 클래스명.변수명
	 * }
	 * 
	 * Ex01 ex01;
	 * ex01 = new Ex01();
	 * System.out.println(Ex01.addr);
	 * 
	 * 
	 * 			stack							heap
	 * 	ex01		1000			1000	| age | name |
	 * 								2000	| first | second |
	 * 
	 * 
	 */
	
	
	
	
	
	
}
