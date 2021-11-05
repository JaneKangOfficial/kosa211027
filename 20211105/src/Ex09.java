
public class Ex09 {

	public static void main(String[] args) {

		// 7단을 홀수만 출력하시오.
		System.out.println("7 * " + 1 + " = " + 7 * 1);
		System.out.println("7 * " + 3 + " = " + 7 * 3);
		System.out.println("7 * " + 5 + " = " + 7 * 5);
		System.out.println("7 * " + 7 + " = " + 7 * 7);
		System.out.println("7 * " + 9 + " = " + 7 * 9);
		
		System.out.println("================ for ===================");
		
		for (int i = 1; i <= 9; i+=2) {
			System.out.println("7 * " + i + " = " + 7 * i);
		}
		
	}

}
