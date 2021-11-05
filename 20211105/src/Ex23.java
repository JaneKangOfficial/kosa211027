import java.util.Scanner;

public class Ex23 {

	public static void main(String[] args) {

		/*
		 * 파이썬
		 * num = int(input("첫번째 숫자를 입력해주세요."))
		 */

		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요. : ");
		String name = sc.next();
		System.out.println("이름은 : " + name);
		
		System.out.print("숫자를 입력하세요. : ");
		int num = sc.nextInt();
		System.out.println("숫자 : " + num);
		*/
		
		// 문제 : 단과 곱의 범위를 입력 받아 구구단을 출력하시오. - 파이썬 스타일 while(true) 사용
		
		Scanner sc = new Scanner(System.in);
		
		while(true) { // 무조건 실행하기 위해서 true 사용
			System.out.print("시작단을 입력 : ");
			int startDan = sc.nextInt();
			System.out.print("마지막단을 입력 : ");
			int lastDan = sc.nextInt();
			System.out.println(startDan + "단부터 " + lastDan + "까지");
			
			System.out.print("시작곱을 입력 : ");
			int startGop = sc.nextInt();
			System.out.print("마지막곱을 입력 : ");
			int lastGop = sc.nextInt();
			System.out.println(startGop + "곱부터 " + lastGop + "까지");
			
			int dan = startDan;
			while ( dan <= lastDan) {
				int gop = startGop;
				while(gop <= lastGop) {
					System.out.println(dan + " * " + gop + " = " + dan * gop);
					gop++;
				}
				dan++;
			}

			System.out.println("종료하려면 'y' 계속하려면 아무키나 : ");
			String stop = sc.next();
			if (stop.equals("y")) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
		
	}
}
