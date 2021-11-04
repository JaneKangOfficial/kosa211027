
public class Ex04 {

	public static void main(String[] args) {
		// 실수형 리터널 : 0.5, 10.6, 0.0
		// 소숫점을 가지고 있는 수를 실수라고 한다.
		
		float f; // 4byte : 정밀도 낮다.
		double d; // 8byte : 정밀도 높다. 
		// 실수의 기본 크기 : 8byte
		d = 0.1234567890123456789;
		f = 0.1234567890123456789f;
		System.out.println(d);
		System.out.println(f);
		
		boolean b = true;
		boolean b1 = false;
		String str = "true"; // 문자열
		// b = True; 소문자
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(str);

		
	}
}
