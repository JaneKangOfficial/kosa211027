import java.util.Scanner;

public class Ex24 {

	public static void main(String[] args) {

		// 자바 스타일 do ~ while 사용
		
		Scanner sc = new Scanner(System.in);
		String stop;
		
		do { // 무조건 실행
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
			stop = sc.next();
		} while (!stop.equals("y"));
			System.out.println("프로그램 종료");
		
		
	}

}
