
public class Ex06Test {

	public static void main(String[] args) {

		Ex06 ex06; // 변수선언
		ex06 = new Ex06(); // 객체 생성
		
		// 멤버필드 초기화
		ex06.setData("홍길동", 35, 175.5);
		String name = ex06.getName();
		System.out.println(name);
	
		// 객체생성과 동시에 멤버 필드에 초기화 : 생성자
		Ex061 ex061 = new Ex061("홍", 18, 175.5);
		System.out.println(ex061.getAge());
		
		// 객체생성시에 생성자가 자동으로 실행
		// 생성자 : 멤버필드를 초기화할 때 사용
		System.out.println(ex061.getAge());
		
		
	}

}
