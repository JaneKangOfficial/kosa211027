import java.util.Scanner;

public class AccountMain1 {
	// static main �޼��� �ȿ��� ����Ϸ��� static�� �پ�� �Ѵ�.
	static Account[] accs = new Account[100];
	// �迭�� index�� 0������ ����
	static Scanner sc = new Scanner(System.in);
	static int arrayNum = 0; // �迭�� ���� ��ȣ�� ������ ���� ���� 
	static boolean run = true;
	
	public static void main(String[] args) {
		
		do {
			System.out.println("1. ���µ�� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ���� ");
			System.out.print("���� > ");
			
			/*
			int selectNo = sc.nextInt(); // sc.nextLine();�� �����̴�.
			sc.nextLine(); // �Է���ġ�� "\n"���� �ִ� ���� ���ֱ� ���� ���
			*/
			String selectNo = sc.nextLine(); // accountNo�� ���� "\n" ������ ������, �޸𸮿� �������� ����
												// nextInt�� "\n"���� �� ������ ��
			switch(selectNo) {
			case "1":
				System.out.println("���µ�� �������Դϴ�.");
				System.out.print("���� ��ȣ : ");
				String accountNo = sc.nextLine();
				System.out.print("������ : ");
				String owner = sc.nextLine();
				System.out.print("�ݾ� : ");
				int money = sc.nextInt();
				
				accs[arrayNum] = new Account(accountNo, owner, money);
				arrayNum++;
				System.out.println("���µ���� �Ϸ�Ǿ����ϴ�.");
				break;
			case "2":
				System.out.println("���ڸ�� �������Դϴ�.");
				System.out.println("���¹�ȣ \t\t ������ \t\t �ݾ�");
				
				accountPrint();
				
				System.out.println();
				break;
			case "3":
				System.out.println("���� �������Դϴ�.");
				System.out.println("���¹�ȣ : ");
				accountNo = sc.nextLine();
				System.out.println("���ݾ� : ");
				money = Integer.parseInt(sc.nextLine());
				
				Account acc = accountFind(accountNo);
				
				int result = acc.getBalance() + money;
				acc.setBalance(result);
				System.out.println();
				break;
			case "4":
				System.out.println("��� �������Դϴ�.");
				System.out.println("���¹�ȣ : ");
				accountNo = sc.nextLine();
				System.out.println("���ݾ� : ");
				money = Integer.parseInt(sc.nextLine());
				
				acc = accountFind(accountNo);
				
				result = acc.getBalance() - money;
				acc.setBalance(result);
				System.out.println();
				break;
			case "5":
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				run = false; break;
//					System.exit(0); // ���α׷� ����
			}
		
		}while(run);
	}
	
	public static Account accountFind(String accountNo) {
		for(int i = 0; i < accs.length; i++) {
			if(accs[i] == null) break;
			else {
				if(accs[i].getAccountNo().equals(accountNo)) {
					// ���¹�ȣ�� ��ġ�ϴ� Account�� ������ �ͼ� acc�� ����.
					return accs[i];
				}
			}
		}
		return null;
	}
	
	public static void accountPrint() {
		for(int i = 0; i < accs.length; i++) {
			if(accs[i] == null) break;
			System.out.println(accs[i].getAccountNo() + "\t\t" 
							+ accs[i].getOwner()+ "\t\t"
							+ accs[i].getBalance());
		}
	}



/*
 * class : Data (Method) ����
 * class Account {
 * 		String accountNo;	// heap ������ instance ������ ����
 * 		String owner;
 * 		int balance;
 * 		static int val;		// static�� class������ �����ϴ� ���� = Ŭ���� ����
 * 							// ��� ��ü������ ���� �����ؼ� ����ؾ� �ϴ� ���
 * }
 * 
 * Account ac1 = new Account()
 * Account ac2 = new Account()
 * 
 * 		stack								heap
 *  ac1		10000			10000	| accountNo | owner | balance| ==> ac1 ��ü = instance
 * 	ac2		20000			20000	| accountNo | owner | balance| ==> ac2 ��ü = instance
 *											instance ���� = this.accountNo
 *											������� : ��ü ���� �ִ� ���� 	
 *											static�� ������ class������ �ִ�.
 *	
 * 	ac1.val = 10 // val�� static �̱� ������ instance�� �ƴ� Ŭ������ 10�� ����ȴ�.
 *	System.out.println(ac2.val); // 10�� class�� ����Ǿ� �ֱ� ������ ac2.val�� ���� 10�� �ȴ�. 
 *	System.out.println(Account.val) // 10 ���
 *
 */	
}
