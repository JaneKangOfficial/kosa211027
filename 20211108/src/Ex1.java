
public class Ex1 {

	public static void main(String[] args) {

//		1. �ݺ��� ���� ���� i�� �ʱⰪ�� 1�̰� 10���� �ݺ� ������ �� �� i�� ��µǵ��� �Ͻÿ�.
		System.out.println("===1===");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
//		2. �ݺ��� ���� ���� i�� �ʱⰪ�� 1�ϰ� 10���� �ݺ� ������ �� �� ���� y�� �ݺ��� ������ 1�� �����ϴ� ���� ��µǵ��� �Ͻÿ�.
		System.out.println("===2===");
		int y = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.println(y);
			y++;
		}
		
		// 3.
		for (int i = 1; i <= 10; i++) {
			int y1 = 0; // �ݺ��� �ȿ� ���� ������ ����
			y1++; // y1�� 0���� �ʱ�ȭ�� �Ǿ����Ƿ� �׻� 1�� �ȴ�.
			System.out.println(y1); // 1,1,1,1,1,1,1
			System.out.println(i); // 1,2,3,4,5,6,7,8,9,10
		}
		
		// 4.
		for(int i = 11; i <= 20; i++) { // i�� �ݺ�����
			System.out.println("�̾��޴��� �������� �����ž� �մϴ�.");
		}
		
		// �ݺ����� i�� �ʱⰪ�� 10�̰� 10�� �ݺ� i�� 2�� ����
		for (int i = 10; i <= 19; i+=2) {
			System.out.println(i);
		}
		// continue�� ���
		for(int i = 10; i <= 19; i++) {
			if (i % 2 != 0) continue;
			System.out.println(i);
		}
		// ����� ������ �˰����� ���ٰ� �Ѵ�. ������ �ٸ� ���̴�.

		// i�� �ʱⰪ�� 10�̰� 25ȸ �ݺ��ϵ� i�� 4�� ����
		int y2 = 1;
		for (int i = 10; i <= 109; i+=4) {
			System.out.println(y2);
			y2++;
		}

		// 8. i�� �ʱⰪ�� 12�̰� 20ȸ �ݺ��� �� �� "�����ڴ� �鿩���⸦ ���ؾ� �մϴ�."�� 4ȸ ���
		for (int i = 12; i <= 31; i+=5) {
			System.out.println("�����ڴ� �鿩���⸦ ���ؾ� �մϴ�.");
		}
		
		// 11. ������ 7���� ����ϵ� Ȧ������ ����ϵ� �ݺ������� ������� ����.
		int y3 = 1;
		for(int i = 1; i <= 9; i++) {
			System.out.println("7 * " + y3 + " = " + 7 * y3);
			y3++;
		}
		
		// 16. Math.random()�Լ��� ����ؼ� 1���� 45������ ���� �� �� �ϳ��� ������ �ͼ� ���� �� ��ŭ �ݺ�
		int num = (int)(Math.random() * 45) + 1;
		for (int i = 1; i <= num; i++) {
			System.out.println(i);
			
		}
		
		// 17. 1���� 10���� �ݺ��� �� Math.random()���� 1���� 45������ ���� �޾� ¦���� ���� 3�� ���ؼ� ���, 10ȸ�� �ݺ�
		for(int i = 1; i <= 10; i++) {
			int num1 = (int)(Math.random() * 45) + 1;
			if (num1 % 2 == 0) {
				System.out.println("3 * " + num1 + " = " + 3 * num1);
			}else i--;
		}
		
		// x = 10; y = 19; z = 2�� �� i�� �ʱⰪ x�� ������ y��ŭ �ݺ��ϵ� g��ŭ ����
		int x = 10;
		y = 19;
		int g = 2;
		for (int i = x; i <= y; i+=g) {
			System.out.println(i);
		}
		
		// ���� i�� 1���� 10���� �ݺ��� �ϰ� ���� j�� 100���� 91�� �� ������ �ݺ��Ͽ� "���α׷��� ���Ϸ��� �鿩���⸦ ������" ���
		for (int i = 1, j = 100; i <= 10 && j >= 91; i++, j--) {
			System.out.println("���α׷��� ���Ϸ��� �鿩���⸦ ������");
		}
		
		/*
			6�� ����
			6 * 4= 24
			6 * 5= 30
			6 * 6= 36
			6�� ��
			7�� ����
			7 * 4= 28
			7 * 5= 35
			7 * 6= 42
			7�� ��
		*/
		for (int i = 4; i <= 6; i++) {
			System.out.println(i + "�� ����");
			for (int j = 3; j <= 8; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println(i + "�� ��");
		}
		System.out.println("===================");
		
		for (int i = 4; i <= 6; i++) {
			System.out.println(i + "�� ����");
			for (int j = 3; j <= 8; j++) {
				System.out.print(i + " * " + j + " = " + i * j + " ");
			}
			System.out.println();
			System.out.println(i + "�� ��");
		}
		
		/*
			28. html �� table �±� ���
			<table>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			</table>
		*/
		System.out.println("<table>");
		for(int i = 1; i <= 4; i++) {
			System.out.println("<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>");
		}
		System.out.println("</table>");
		
	}
}
