package runtime_exception;
// ������ �� �߻��ϴ� ���� : runtimeException
// (���⿡ �ɸ��� ������ ArrayIndexOutOfBoundsException ���̴�.

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		// ���ڰ� ������ �߻��� �� �ִ� ���� : ArrayIndexOutOfBoundsException
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
			System.out.println("�Է� ���� 3���̾�� �մϴ�.");
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
			System.out.println("���� 3���� �ʿ��մϴ�.");
		}
		
		
	}
}
