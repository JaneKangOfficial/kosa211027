

import java.util.Scanner;

public class BoardHomeWork {

	public static void main(String[] args) {

		Board b[] = new Board[100];
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int numCount = 0;
		do {
			System.out.println("�۾��� 1 | �󼼺��� 2 | ���� 3");
			System.out.print("��ȣ ���� : ");
			String selectNum = sc.nextLine();

			switch (selectNum) {
			case "1":
				System.out.println("���ۼ� �������Դϴ�.");
				System.out.print("�۾��� : ");
				String writer = sc.nextLine();
				System.out.print("���� : ");
				String subject = sc.nextLine();
				System.out.print("���� : ");
				String content = sc.nextLine();

				System.out.println("�����Ϸ��� y �ٽ� ������ n : ");
				String add = sc.nextLine();
				System.out.println("add : " + add);
				switch (add) {
				case "y":
					System.out.println("����� �Ϸ�Ǿ����ϴ�.");
					int readCount = 0;
					int num = 1;
					b[numCount] = new Board(num, writer, subject, content, readCount);
					for (Board n : b) {
						if (n == null)
							break;
						n.setNum(num);
						System.out.print(n.getNum() + " ");
						System.out.print(n.getWriter() + " ");
						System.out.print(n.getSubject() + " ");
						System.out.print(n.getContent() + " ");
						System.out.println(n.getReadCount());
						num++;
					}
					numCount++;

					System.out.println();
					break;
				case "n":
					continue;
				}
				break;

			case "2":
				Board bb = null;
				System.out.println("�󼼺��� �������Դϴ�.");
				System.out.print("������� �Խñ� ��ȣ�� �Է����ּ��� : ");
				int nu = Integer.parseInt(sc.nextLine());

				for (int i = 0; i < b.length; i++) {

					if (b[i] == null) {
						System.out.println("���� ��ȣ�Դϴ�.");
						break;
					} else if (b[i].getNum() == nu) {
						bb = b[i];
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
				switch (selectNum) {
				case "1":
					System.out.println("����������Դϴ�.");
					System.out.println("�۸��");
					System.out.println("��ȣ\t\t�۾���\t\t\t����\t\t\t����\t\t\t������");
					for (Board n : b) {
						if (n == null)
							break;
						System.out.print(n.getNum() + "\t\t" + n.getWriter() + "\t\t\t" + n.getSubject() + "\t\t\t"
								+ n.getContent() + "\t\t\t");
						System.out.println(n.getReadCount());
					}
					System.out.println();
					System.out.println("=================================");
					break;

				case "2":
					System.out.println("�����������Դϴ�.");
					System.out.println("�۾��̸� �����Ϸ��� 1 | ������ �����Ϸ��� 2 | ������ �����Ϸ��� 3");

					String select = sc.nextLine();
					switch (select) {
					case "1":
						System.out.println("�۾��̸� �����մϴ�.");
						System.out.println("������ �۾��̸� �Է��ϼ��� : ");
						String writer2 = sc.nextLine();
						bb.setWriter(writer2);
						break;

					case "2":
						System.out.println("������ �����մϴ�.");
						System.out.println("������ ������ �Է��ϼ��� : ");
						String subject2 = sc.nextLine();
						bb.setSubject(subject2);
						break;

					case "3":
						System.out.println("������ �����մϴ�.");
						System.out.println("������ ������ �Է��ϼ��� : ");
						String content2 = sc.nextLine();
						bb.setContent(content2);
						break;
					}
					break;

				case "3":
					System.out.println("�����մϴ�.");
					System.out.println("������ ��ȣ�� �Է����ּ��� : ");
					int delete = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < b.length; i++) {

						if (b[i] == null) {
							System.out.println("���� ��ȣ�Դϴ�.");
							break;
						} else if (b[i].getNum() == delete) {
							bb = b[i];
							System.out.println("bb : " + bb);
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
				}
				break;

			case "3":
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
				break;
			}

		} while (run);

	}
}
