import java.util.Scanner;

public class AccountHomeWork {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Account[] acc = new Account[100];
		int num = 0;
		boolean run = true;

		do {
			System.out.println("1. ���µ�� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ���� ");
			System.out.print("���� > ");
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1":
				System.out.println("���� ��� �������Դϴ�.");
				System.out.print("���¹�ȣ : ");
				String accountNo = sc.nextLine();
				System.out.print("������ : ");
				String owner = sc.nextLine();
				System.out.print("�ݾ� : ");
				int balance = sc.nextInt();

				acc[num] = new Account(accountNo, owner, balance);
				// acc[i].setAccountNo(accountNo);
				// acc[i].setOwner(owner);
				// acc[i].setBalance(balance);
				num++;
				System.out.println("���µ���� �Ϸ�Ǿ����ϴ�.");
				System.out.println();
				break;
			case "2":
				System.out.println("���� ��� �������Դϴ�.");
				System.out.println("���¹�ȣ\t\t������\t\t�ݾ�");
				for (int i = 0; i < acc.length; i++) {
					if (acc[i] == null)
						break;
					System.out.print(acc[i].getAccountNo() + "\t\t" 
								+ acc[i].getOwner() + "\t\t" 
								+ acc[i].getBalance());
				}
				System.out.println();
				break;
			case "3":
				System.out.println("���� �������Դϴ�.");
				System.out.print("���¹�ȣ : ");
				accountNo = sc.nextLine();
				System.out.print("�ݾ� : ");
				balance = Integer.parseInt(sc.nextLine());
				Account ac = null;
				for (int i = 0; i < acc.length; i++) {
					if (acc[i] == null)
						break;
					else {
						if (acc[i].getAccountNo().equals(accountNo)) {
							ac = acc[i];
							break;
						}
					}
				}
				int result = ac.getBalance() + balance;
				ac.setBalance(result);
				System.out.println();
				break;
			case "4":
				System.out.println("��� �������Դϴ�.");
				System.out.print("���¹�ȣ : ");
				accountNo = sc.nextLine();
				System.out.print("�ݾ� : ");
				balance = Integer.parseInt(sc.nextLine());
				ac = null;
				for (int i = 0; i < acc.length; i++) {
					if (acc[i] == null)
						break;
					else {
						if (acc[i].getAccountNo().equals(accountNo)) {
							ac = acc[i];
							break;
						}
					}
				}
				result = ac.getBalance() - balance;
				ac.setBalance(result);
				System.out.println();
				break;
			case "5":
				System.out.println("���α׷� ����");
				run = false;
				break;
			}
		} while (run);
	}

}
