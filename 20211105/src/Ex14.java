
public class Ex14 {

	public static void main(String[] args) {
		/*
		 * 파이썬
		 * i = 1			# 1
		 * while i <= 9 :	# 2
		 * 		print(i)	# 3
		 * 		i += 1		# 4
		 * 
		 *  1 -> 2 -> 3 -> 4 -> 2 -> 3 -> 4 -> 2 -> ... -> 2
		 */
		
		// for문의 실행순서
		//        1       2      4     
		for (int i = 1; i <= 9; i++) {
			// 3
			System.out.println("5 * " + i + " = " + 5 * i);
		}
		// 1 -> 2 -> 3 -> 4 -> 2 -> 3-> 4 -> 2 -> ... -> 2

		int i = 1;
		for ( ; i <= 9; ) {
			System.out.println("5 * " + i + " = " + 5 * i);
			i++;
		}
		
		System.out.println("================ while ===================");
		
		i = 1;	// 1
		while (i <= 9) {	// 2
			System.out.println("5 * " + i + " = " + 5 * i); 	// 3
			i++;	// 4
		}
		
		// while문으로 3단을 출력하시오.
		i = 1;
		while ( i <= 9) {
			System.out.println("3 * " + i + " = " + 3 * i);
			i++;
		}
		
		System.out.println("==== for ====");
		for (i = 3; i <= 7; i++) {
			System.out.println("3 * " + i + " = " + 3 * i);
		}
		
		System.out.println("==== while ====");
		i = 3;
		while(i <= 7) {
			System.out.println("3 * " + i + " = " + 3 * i);
			i++;
		}
		
		
		
		
		
	}
}
