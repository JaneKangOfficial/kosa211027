import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {

		System.out.println("===== 1 =====");
		double num=0.0, sum=0.0;
//		1/2 + 2/3 +3/4 + 5/6 + 6/7 + 7/8 + 8/9 + 9/10�� ���� ���ϴ� ���α׷����Ͻÿ�.
		for (double i = 1; i <=9; i++) {
			for (double j = i+1; j<=i+1; j++) {
				num = i / j;
				sum += num;
				System.out.println(i + " / " + j + " = " + num);
			}
		}
		System.out.println("sum = " + sum);

		System.out.println("===== 2 =====");
//		�����Ը� �Է��Ͻÿ� : 45.5
//		�����Ը� �Է��Ͻÿ� : 27.3
//		�����Ը� �Է��Ͻÿ� : 12.6
//		�����Ը� �Է��Ͻÿ� : 65.4
//		�ִ밪=65.40
//		�ּҰ�=12.60
//		��=150.80
//		���=37.70
	
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("�����Ը� �Է��Ͻÿ� : ");
//		double a1 = sc.nextDouble();
//		System.out.println("�����Ը� �Է��Ͻÿ� : ");
//		double a2 = sc.nextDouble();
//		System.out.println("�����Ը� �Է��Ͻÿ� : ");
//		double a3 = sc.nextDouble();
//		System.out.println("�����Ը� �Է��Ͻÿ� : ");
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
//		System.out.println("�� = " + sum1);
//		System.out.println("��� = " + sum1 / arr.length);
//		System.out.println("�ִ밪 = " + max);
//		System.out.println("�ּҰ� = " + min);
		
	
		System.out.println("===== 3 =====");
		for(int j = 1; j <= 9; j++) {
			for(int i = 2; i <= 9; i++) {
				System.out.print(i + " * " + j + " = " + i * j + " \t");
			}
			System.out.println();
		}
	
	
		System.out.println("===== 4 =====");
//		1. ��ǰ�ڵ�� 1, 2, 3, 4, 5 �� �ϳ��̰� 1�̸� �ܰ��� 50000��, 2�̸� 30000��,
//		3�̸� 35000��, 4�̸� 40000��, 5�̸� 80000���̴�.
//		2. ��ǰ�ڵ� ���� ������ �Է¹޴´�.
//		3. ��ǰ�ڵ带 ������ �ܰ��� ������ �Ѵ�.
//		4. �ݾ��� ����*�ܰ��� ����Ѵ�.
//		5. �ݾ��� ����Ѵ�.
//		6. ��ǰ�ڵ� ���� 1���� 5�� �ƴ� ������ �ٽ� �Է��� �޴´�.
		
		
		while (true){
			Scanner sca = new Scanner(System.in);
			System.out.println("1 ~ 5 �� ��ǰ�ڵ带 �Է��ϼ��� : ");
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
				System.out.println("�ٽ� �Է����ּ���.");
				continue;
			}
		
		System.out.println("������ �Է��ϼ��� : ");
		int num2 = sca.nextInt();
		
		int price = 0;
		System.out.println("�ݾ��� " + per * num2 + " �Դϴ�.");
		break;
		}
		
	}

}
