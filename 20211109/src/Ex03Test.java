
public class Ex03Test {

	public static void main(String[] args) {
		/*
		 *  파이썬
		 *  ex03 = Ex03() # 파이썬에서 선언하는 방식
		 */
		Ex03 ex03 = new Ex03(); // 자바에서 선언하는 방식
		ex03.setData(20, 10);
		// ex03.first = 20; ex03.second = 10;
		ex03.add();
		System.out.println(ex03.result);
		ex03.sub();
		System.out.println(ex03.result);
		
		Ex03 ex003 = new Ex03();
		ex003.setData(200, 100);
		ex003.sub();
		System.out.println(ex003.result);
		
/*
	data(Method), static, stack, heap
		
		data
	Ex03 : 변수, 함수 // 클래스 : 붕어빵 틀
	
Ex03 ex03;				1.
ex03 = new Ex03();		2.
Ex03 ex003;
ex003 = new Ex03();
ex003.setData(20,10);

	데이터 영역에 있는 클래스								new할 경우 틀
		stack										heap // 객체 // 붕어빵
	주소,	 	변수, 	값						주소 	 	 	값
	1000 	ex03 	null		1.			100		first|second|result
		 			100
	1010	ex003							110	 	first | second | result
					110
													 20   |   10   | result
ex03.result ==> 100.result
System.out.println(ex003.result) ==> 110.result

객체지향 : 


		 
*/
	}

}
