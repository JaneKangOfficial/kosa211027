import java.util.Scanner;

public class Ex24 {

	public static void main(String[] args) {

		// �ڹ� ��Ÿ�� do ~ while ���
		
		Scanner sc = new Scanner(System.in);
		String stop;
		
		do { // ������ ����
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
			stop = sc.next();
		} while (!stop.equals("y"));
			System.out.println("���α׷� ����");
		
		
	}

}
