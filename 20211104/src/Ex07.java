
public class Ex07 {

	public static void main(String[] args) {
		char ch1 = 'A' + 1; // 2byte + 2byte : 문자 + 숫자
		System.out.println(ch1);
		char ch2 = 'C'; // 정수
		char ch3 = (char)(ch2 + 1); // (char)(4byte + 4byte) : 정수 + 정수
		
		short sh = 65 + 60; // 2byte가 4byte로
		short sh1 = 65;
		short sh2 = 60;
		short sh3 = (short)(sh1 + sh2);
		System.out.println(sh3);
		
		float f1 = 10.5f; // 4byte
		double d1 = 10.6; // 8byte
		double d2 = f1 + d1; // 8byte
		
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//								  정수    <    실수
		// 8 -> 4가 아니라 정수 -> 실수 (실수가 더 크기 때문)
		
		int result = (int)10.5 + 4; // 8byte + 4byte : 4byte + 4byte
		System.out.println(result);
		
		
		/* 자료형 : 
		 * 	정수 : byte, char, short, int, long
		 * 	실수 : float, double
		 * 	문자열 : String, ""
		 * 	문자 : char, ''
		 * 	부울 : true, false : 1byte
		 */
		
		char ch = 'a';
		ch = 97;
		
	}

}
// 2장(자료형)과 3장(연산자)만 잘하면 프로그램의 80%를 한다.