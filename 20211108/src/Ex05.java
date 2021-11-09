
public class Ex05 {

	public static void main(String[] args) {

		// cmd에서 args값 입력 받아서 사용 -> java Ex05 3 5
		System.out.println(args[0]);
		System.out.println(args[1]);
		int start = Integer.parseInt(args[0]);
		int end = Integer.parseInt(args[1]);
		/*
		 * 파이썬
		 * start = int(args[0])
		 */
		// args를 이용해서 원하는 단의 범위를 출력하시오.
		for(int i = start; i <= end; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
		}
		
		
		
	}
}
