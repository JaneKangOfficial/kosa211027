package runtime_exception;
// 실행할 때 발생하는 오류 : runtimeException
// (여기에 걸리는 오류는 ArrayIndexOutOfBoundsException 뿐이다.

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		// 인자값 때문에 발생할 수 있는 오류 : ArrayIndexOutOfBoundsException
		// String[] args = {"1","2"}
		// 					 0   1
		// String[] args = {"1","2","3"}
		//					 0   1   2
		// String[] args = {"1","2","3","4"}
		//					 0   1   2   3
		
		/*
		try {
			String data1 = args[0];
			String data2 = args[1];
			String data3 = args[2];
			
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력 값은 3개이어야 합니다.");
		}
		*/
		
		if(args.length == 3) {
			String data1 = args[0];
			String data2 = args[1];
			String data3 = args[2];
			
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}else {
			System.out.println("값이 3개가 필요합니다.");
		}
		
		
	}
}
