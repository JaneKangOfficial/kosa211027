import java.util.Scanner;

public class Ex23 {

	public static void main(String[] args) {

		/*
		 * ���̽�
		 * num = int(input("ù��° ���ڸ� �Է����ּ���."))
		 */

		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ���. : ");
		String name = sc.next();
		System.out.println("�̸��� : " + name);
		
		System.out.print("���ڸ� �Է��ϼ���. : ");
		int num = sc.nextInt();
		System.out.println("���� : " + num);
		*/
		
		// ���� : �ܰ� ���� ������ �Է� �޾� �������� ����Ͻÿ�. - ���̽� ��Ÿ�� while(true) ���
		
		Scanner sc = new Scanner(System.in);
		
		while(true) { // ������ �����ϱ� ���ؼ� true ���
			System.out.print("���۴��� �Է� : ");
			int startDan = sc.nextInt();
			System.out.print("���������� �Է� : ");
			int lastDan = sc.nextInt();
			System.out.println(startDan + "�ܺ��� " + lastDan + "����");
			
			System.out.print("���۰��� �Է� : ");
			int startGop = sc.nextInt();
			System.out.print("���������� �Է� : ");
			int lastGop = sc.nextInt();
			System.out.println(startGop + "������ " + lastGop + "����");
			
			int dan = startDan;
			while ( dan <= lastDan) {
				int gop = startGop;
				while(gop <= lastGop) {
					System.out.println(dan + " * " + gop + " = " + dan * gop);
					gop++;
				}
				dan++;
			}

			System.out.println("�����Ϸ��� 'y' ����Ϸ��� �ƹ�Ű�� : ");
			String stop = sc.next();
			if (stop.equals("y")) {
				System.out.println("���α׷� ����");
				break;
			}
			
		}
		
		
	}
}
