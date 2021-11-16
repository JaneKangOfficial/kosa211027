package wrapperExample;

public class ValueCompareEx {

	public static void main(String[] args) {

		int i1 = 10;
		int i2 = 10;
		if (i1 == i2) { // 같다
			System.out.println("같다");
		}
		
		Integer i3 = 10;
		Integer i4 = 10;
		if (i3 == i4) { // 같다
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		// unboxing 해서 비교 
		if (i3.intValue() == i4.intValue()) { // 같다
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		i3 = 10;
		i4 = 10;	// -128 ~ 127 : true
		System.out.println(i3 == i4);	// true
		System.out.println(i3.intValue() == i4.intValue());	// true
		System.out.println(i3.equals(i4));	// true

		i3 = 300;
		i4 = 300;	// -128보다 작고 127보다 큰 값인 경우 
		System.out.println(i3 == i4);	// false	// Wrapper 자료형에서는 == 쓰지 않기
		System.out.println(i3.intValue() == i4.intValue());	// true
		System.out.println(i3.equals(i4));	// true	// Wrapper 자료형에서 주로 사용
		
		
	}

}
