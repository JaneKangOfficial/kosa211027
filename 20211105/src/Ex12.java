
public class Ex12 {

	public static void main(String[] args) {

		/* 
		 * 파이썬
		 * num = 1 # 전역변수
		 * def test() :
		 * 		num = 100 # 지역변수 : 블럭변수(자바)
		 * 		print(num)
		 * 
		 * test()
		 * print(num)
		 */
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			int a = 10;
			// 변수 i, a 를 블럭변수라고 한다. 블럭 안에서만 사용이 가능하다.
		}
		/* 블럭 밖에서 사용하려면 오류가 발생한다.
			System.out.println(a);
			System.out.println(i);
		 */
		
		int num;
		for (num = 1; num <= 10; num++) {
			System.out.println(num);
			// 블럭 밖에 있는 변수 num은 블럭 안에서 사용이 가능하다.
		}
		
		
		
		
	}

}
