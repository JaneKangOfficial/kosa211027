
public class Ex21 {

	public static void main(String[] args) {

		// lotto : 1 ~ 45 중 3개 숫자
		int num1, num2, num3;
		num1 = (int)(Math.random() * 45) + 1;
		do {
			// 1
			num2 = (int)(Math.random() * 45) + 1;
		}while(num1 == num2); // 2
		
		////////////////////////////////
		num1 = (int)(Math.random() * 45) + 1;
		num2 = (int)(Math.random() * 45) + 1;
		while(num1 == num2) {
			num2 = (int)(Math.random() * 45) + 1;
		}
		
		
		
		
		
	}
}
