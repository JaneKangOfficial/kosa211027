
public class Ex02Test {

	public static void main(String[] args) {

		// final 변수는 생성자를 통해서 초기화가 가능
		Ex02 ex02 = new Ex02(10, 20, "100");
		// 초기화 된 값을 변경하지 못한다. = 상수
//		ex02.first = 20;	// private 이 없어서 외부에서 접근은 가능하지만 final 이기 때문에 수정 불가.
		
		// instance 객체마다 final 변수의 값을 별개로 가질 수 있다.
		Ex02 ex021 = new Ex02(30,40, "100");
		System.out.println(ex02.FIRST);
		System.out.println(ex021.FIRST);
		
		
		
		
	}

}
