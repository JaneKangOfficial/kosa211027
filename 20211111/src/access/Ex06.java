package access;

import access.access1.Ex04;
import inheritance.Ex05;

public class Ex06 {
 
	public static void main(String[] args) {
		Ex04 ex04 = new Ex04(); // 다른 패키지
		// protected 멤버는 다른 패키지에 상속은 되지만, 다른 클래스에서 사용할 수는 없다.
//		ex04.first;
		
		// 다른 패키지에서 상속 받은 패키지에서도 사용할 수 없다.
		Ex03 ex03 = new Ex03(); // 다른 패키지에서 상속 받음
//		ex03.first;
		
		Ex05 ex05 = new Ex05(); // 같은 패키지에서 상속 받음
//		ex05.first;	// 다른 패키지에 클래스에서 상속은 되지만 사용은 할 수 없다.
		
	}
}
