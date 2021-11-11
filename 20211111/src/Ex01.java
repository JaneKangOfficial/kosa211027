
public class Ex01 {

	int first;
	int second; 
}

/*
 *			data(Method
 *	Ex01  {
 *	int first;
 *	int second;
 *	...
 *	메서드
 *	}
 *
 *	Ex01 ex01 = new Ex01();
 *	Ex01 ex02 = new Ex01();
 *	new 연산자는 heap영역에 객체를 생성시키는 연산자.
 *
 *			stack							heap
 *		ex01	1000				1000	| first | second |
 *		ex02	2000				2000	| first | second |
 *
 *
 *		1000	2000	// 클래스는 같지만 다른 주소를 가진 다른 객체
 * 	if (ex01 == ex02) {
 * 		System.out.println("같다");
 * 	}else {
 * 		System.out.println("다르다");
 *  }
 * 
 * 
 */
