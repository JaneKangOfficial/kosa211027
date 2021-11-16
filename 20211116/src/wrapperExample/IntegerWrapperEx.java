package wrapperExample;

public class IntegerWrapperEx {

	public static void main(String[] args) {

		int i = 10;
		String s = "10";
		
		// Wrapper 자료형 
		Integer i1 = 10;	// int와 같다.
		i1 = Integer.parseInt(s);
		
		byte by = 10;
		Byte by1 = 10;	// Wrapper 자료형
		
		short sh = 10;
		Short sh1 = 10;	// Wrapper 자료형
		
		double d = 10.5;
		Double d1 = 10.5;	// Wrapper 자료형
		
		float f = 10.5f;
		Float f1 = 10.5f;	// Wrapper 자료형
//		f = null; 	// 일반 자료형은 null 값을 저장할 수가 없다.// null : 값은 존재하되 어떠한 값인지를 모르는 것.
		f1 = null;	// Wrapper : 문자열을 숫자로 변환하기도 하지만 null 값을 저장하기 위해서 주로 사용
		
	}

}
