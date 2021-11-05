
public class Ex17 {

	public static void main(String[] args) {

		// 1 ~ 100까지의 합을 구하는데 짝수만 더하시오. 
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if (i % 2 == 0)  {
				sum += i;
			}
		}
		System.out.println(sum);
		
		System.out.println("=====");
		
		sum = 0;
		int i = 1;
		while (i <= 100) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
		
		System.out.println("=====");

		sum = 0;
		i = 0;
		while (true) {
			i++;
			if (i % 2 == 0) {
				sum += i;
			}
			if (i > 100) break;
		}
		System.out.println(sum);
	
	
	}

}
