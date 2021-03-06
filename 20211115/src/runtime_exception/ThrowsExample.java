package runtime_exception;

public class ThrowsExample {

	public static void main(String[] args) {
		try {
			test();	// 호출함수
		}catch(ArithmeticException e) {
			System.out.println(0);
		}
	}
	
	// 					호출함수쪽으로 예외를 돌려줄 때에는 throws 연산자를 사용해야 한다.
	public static void test() throws ArithmeticException {
		int i = 2;
		int j = 0;
		try {
			System.out.println(i / j);
		}catch(ArithmeticException e) {
			System.out.println(0);
		}
	}
	
}
