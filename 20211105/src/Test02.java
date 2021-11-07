import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {

		System.out.println("===== 1 =====");
		double num=0.0, sum=0.0;
//		1/2 + 2/3 +3/4 + 5/6 + 6/7 + 7/8 + 8/9 + 9/10의 합을 구하는 프로그래밍하시오.
		for (double i = 1; i <=9; i++) {
			for (double j = i+1; j<=i+1; j++) {
				num = i / j;
				sum += num;
				System.out.println(i + " / " + j + " = " + num);
			}
		}
		System.out.println("sum = " + sum);

		System.out.println("===== 2 =====");
//		몸무게를 입력하시오 : 45.5
//		몸무게를 입력하시오 : 27.3
//		몸무게를 입력하시오 : 12.6
//		몸무게를 입력하시오 : 65.4
//		최대값=65.40
//		최소값=12.60
//		합=150.80
//		평균=37.70
	
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("몸무게를 입력하시오 : ");
//		double a1 = sc.nextDouble();
//		System.out.println("몸무게를 입력하시오 : ");
//		double a2 = sc.nextDouble();
//		System.out.println("몸무게를 입력하시오 : ");
//		double a3 = sc.nextDouble();
//		System.out.println("몸무게를 입력하시오 : ");
//		double a4 = sc.nextDouble();
	
//		double[] arr = {a1, a2, a3, a4};
//		double sum1 = 0;
//		double max = arr[0];
//		double min = arr[0];
//		for (int i = 0; i <= arr.length; i++) {
//			sum1 += arr[i];
//			
//			if (arr[i] > max) {
//				max = arr[i];
//			}
//			
//			if (arr[i] < min) {
//				min = arr[i];
//			}
//		}
//		System.out.println("합 = " + sum1);
//		System.out.println("평균 = " + sum1 / arr.length);
//		System.out.println("최대값 = " + max);
//		System.out.println("최소값 = " + min);
		
	
		System.out.println("===== 3 =====");
		for(int j = 1; j <= 9; j++) {
			for(int i = 2; i <= 9; i++) {
				System.out.print(i + " * " + j + " = " + i * j + " \t");
			}
			System.out.println();
		}
	
	
		System.out.println("===== 4 =====");
//		1. 상품코드는 1, 2, 3, 4, 5 중 하나이고 1이면 단가가 50000원, 2이면 30000원,
//		3이면 35000원, 4이면 40000원, 5이면 80000원이다.
//		2. 상품코드 값과 수량을 입력받는다.
//		3. 상품코드를 가지고 단가의 판정을 한다.
//		4. 금액은 수량*단가로 계산한다.
//		5. 금액을 출력한다.
//		6. 상품코드 값이 1부터 5가 아닐 때까지 다시 입력을 받는다.
		
		
		while (true){
			Scanner sca = new Scanner(System.in);
			System.out.println("1 ~ 5 중 상품코드를 입력하세요 : ");
			int code = sca.nextInt();
			
			int per = 0;
			if (code == 1) {
				per = 50000;
			}else if (code == 2) {
				per = 30000;
			}else if (code == 3) {
				per = 35000;
			}else if (code == 4) {
				per = 40000;
			}else if (code == 5) {
				per = 80000;
			}else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
		
		System.out.println("수량을 입력하세요 : ");
		int num2 = sca.nextInt();
		
		int price = 0;
		System.out.println("금액은 " + per * num2 + " 입니다.");
		break;
		}
		
	}

}
