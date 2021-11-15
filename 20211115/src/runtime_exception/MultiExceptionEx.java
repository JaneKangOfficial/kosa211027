package runtime_exception;

public class MultiExceptionEx {

	public static void main(String[] args) {

		int data1 = 0;
		int data2 = 0;

		try {
			data1 = Integer.parseInt(args[0]);
			data2 = Integer.parseInt(args[1]);
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data1 / data2);
		} catch (ArrayIndexOutOfBoundsException e) { // 범위가 큰 error가 위에 오면 아래 작은 error는 실행되지 않아서 오류가 발생한다. 큰 error가 밑으로.
			System.out.println("입력 값이 2개가 필요합니다.");
		} catch (Exception e) { // 모든 error를 처리한다. (파이썬 => } except : { )
			if (data2 == 0) {
				System.out.println(0);
			} else {
				System.out.println(data1 / data2);
			}
		}

	}

}
