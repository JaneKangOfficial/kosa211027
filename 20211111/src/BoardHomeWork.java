import java.util.Scanner;

public class BoardHomeWork {

	public static void main(String[] args) {
		
		Board b[] = new Board[100];
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int numCount = 0;
		do {
			System.out.println("�۾��� 1 | �󼼺��� 2");
			System.out.print("��ȣ ���� : ");
			String selectNum = sc.nextLine();
			switch(selectNum) {
			case "1" : 
				System.out.println("���ۼ� �������Դϴ�.");
				System.out.print("�۾��� : ");
				String writer = sc.nextLine();
				System.out.print("���� : ");
				String subject = sc.nextLine();
				System.out.print("���� : ");
				String content = sc.nextLine();
				int readCount = 0;
//				int numCount = 0;
				int  num = 1;
				
				b[numCount] = new Board(num, writer, subject, content, readCount);
				numCount++;
				for(Board n : b) {
					if (n == null) break;
					System.out.print(n.getNum() + " ");
					System.out.print(n.getWriter() + " ");
					System.out.print(n.getSubject() + " ");
					System.out.print(n.getContent() + " ");
					System.out.println(n.getReadCount());	
				}
				
				
//				for(numCount = 0; numCount < b.length; numCount++) {
//					if (b[numCount] == null) {
//						System.out.println("����");
//						break;
//					}
//					System.out.println("����");
////					b[numCount] = new Board(num, writer, subject, content, readCount);
//					System.out.println(b[numCount]);
//					num++;
//				}
				
				System.out.println("����� �Ϸ�Ǿ����ϴ�.");
				System.out.println();
				break;
			case "2" : 
				Board bb = null;
				System.out.println("�󼼺��� �������Դϴ�.");
				System.out.print("������� �Խñ� ��ȣ�� �Է����ּ��� : ");
				int nu = Integer.parseInt(sc.nextLine());
				
				for(int i = 0; i < b.length; i++) {
					if (b[i].getNum() == nu) {
						bb = b[i];
						break;
					}else {
						System.out.println("���� ��ȣ�Դϴ�.");
						break;
					}
				}
					
				System.out.println("��ȣ : " + bb.getNum());
				System.out.println("�۾��� : " + bb.getWriter());
				System.out.println("���� : " + bb.getSubject());
				System.out.println("���� : " + bb.getContent());
				System.out.println(bb.getReadCount());
				System.out.println();
				System.out.println("=================================");
				System.out.println("������� ���� : 1 | ���� : 2 | ���� : 3");
				selectNum = sc.nextLine();
				switch(selectNum) {
				case "1" :
					System.out.println("����������Դϴ�.");
					System.out.println("�۸��");
					System.out.println("��ȣ\t\t�۾���\t\t\t����\t\t\t����\t\t\t������");
//					while(true) {
//						for(int n : b) {
//							System.out.println(n);
//						}
//					}
					for(Board n : b) {
						if (n == null) break;
						System.out.print(n.getNum() + "\t\t" + n.getWriter() + "\t\t\t" + n.getSubject() 
									+ "\t\t\t" + n.getContent() + "\t\t\t");
						System.out.println(n.getReadCount());	
					}
					System.out.println();
					System.out.println("=================================");
					break;
				case "2" : 
					System.out.println("�����������Դϴ�.");
					break;
				case "3" : 
					System.out.println("�����մϴ�.");
					break;
				}
				break;
			case "z":
				System.out.println("����");
				run = false; break;
			}
			
		}while(run);
		
		
		
		
		
		
		
		
	}
}
