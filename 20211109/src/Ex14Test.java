
public class Ex14Test {

	public static void main(String[] args) {

		Ex14 ex14 = new Ex14(50, 20);
		
//		1. 입력 값이 있고 결과값(반환형)이 있는 메서드
		int num = ex14.add(20, 10);
		System.out.println(num);
		
//		2. 입력 값은 있고 결과 없이 없는 메서드
		ex14.sub(30.0, 15);
		
//		3. 입력값은 없고 결과값이 있는 메서드
		num = ex14.mul();
		System.out.println(num);
		
//		4. 입력값이 없고 결과값이 없는 함수
		ex14.div();
		
		ex14.add = 10;
		System.out.println(ex14.add);
		
		
		
		
		
		
		
	}

}
