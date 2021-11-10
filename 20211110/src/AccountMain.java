import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		/*
		Account acc = new Account("1111","ȫ�浿",100);
		Account acc1 = new Account("2222","ȫ�̸�",100);
		Account acc2 = new Account("3333","���̸�",100);
		*/
		
		int arrayNum = 0; // �迭�� ���� ��ȣ�� ������ ���� ���� 
		
		Account[] accs = new Account[100];
		// �迭�� index�� 0������ ����
		
		boolean run = true;
//		while(run) {
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
				System.out.println("���¸�� �������Դϴ�.");
				System.out.println("���¹�ȣ \t\t ������ \t\t �ݾ�");
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == null) break;
					System.out.println(accs[i].getAccountNo() + "\t\t" 
									+ accs[i].getOwner()+ "\t\t"
									+ accs[i].getBalance());
				}
				break;
			case "3":
				System.out.println("���� �������Դϴ�.");
				System.out.println("���¹�ȣ : ");
				accountNo = sc.nextLine();
				System.out.println("���ݾ� : ");
				money = Integer.parseInt(sc.nextLine());
				Account acc = null;
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == null) break;
					else {
						if(accs[i].getAccountNo().equals(accountNo)) {
							// ���¹�ȣ�� ��ġ�ϴ� Account�� ������ �ͼ� acc�� ����.
							acc = accs[i];
							break;
						}
					}
				}
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
				acc = null;
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == null) break;
					else {
						if(accs[i].getAccountNo().equals(accountNo)) {
							// ���¹�ȣ�� ��ġ�ϴ� Account�� ������ �ͼ� acc�� ����.
							acc = accs[i];
							break;
						}
					}
				}
				result = acc.getBalance() - money;
				acc.setBalance(result);
				System.out.println();
				break;
			case "5":
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				run = false; break;
//				System.exit(0); // ���α׷� ����
			}
		
		}while(run);
	}
/*
 * 	Account[] accs = 				new Account[100];	// �迭 ����
 * 
 * 	accs[0] = new Account("1111","�̸�",100);
 * 	accs[1] = new Account("2222","�̸�2",200);
 * 	accs[2] = new Account("3333","�̸�3",300);
 * 
 * 
 * 	Account acc;
 * 	acc = accs[0] ===> acc = 2000
 * 	acc.getAccountNo() ===> 2000.getAccountNo();
 * 							accs[0].getAccountNo();
 * 
 * 	acc = accs[1] ===> acc = 2050
 * 	acc.getAccountNo() ===> 2050.getAccountNo();
 * 							accs[1].getAccountNo();
 * 
 * 
 * 		stack						heap
 * 	accs	1000 -------->	1000	2000 | 2050 | 2100 | .... | null |
 * 								accs  0		1		2	....	99
 * 
 * 							2000	1111 | �̸� | 100
 * 								accs[0].getAccountNo()	 => 1111
 * 								accs[0].getOwner()		 => �̸�
 * 								accs[0].getBalance() 	=> 100
 * 
 * 							2050	2222 | �̸�2 | 200
 * 								accs[1].getAccountNo()	 => 2222
 * 								accs[1].getOwner()		 => �̸�2
 * 								accs[1].getBalance() 	=> 200
 * 		
 * 							2100	3333 | �̸�3	| 300
 *								accs[2].getAccountNo()	 => 3333
 * 								accs[2].getOwner()		 => �̸�3
 * 								accs[2].getBalance() 	=> 300
 * 
 * 
 * 
 * 	Account ac = new Account("4444","���̸�",2000)
 * 		stack						heap
 * 	ac		1100			1100	accountNo | owner | balance | Account
 * 									  4444	  |	���̸�	  |	2000 |
 * 
 * 	ac = accs[2];
 * 	ac = accs[0];
 * 	ac = new Account();
 *  ac = new Account();
 * 
 * 
 * 	int i = 10;
 * 	int j = 10;
 * 	j = i;
 * 
 * 
 * int i = 10;
 * Account ac;	// 1.
 * ac = new Account();	// 2.	// ac = 1000���� �ּ�
 * 
 * 		1. 							2.
 * 		stack						heap
 * ac 		1000				1000 | accountNo | owner | balance | Account
 * ac.accountNo = "1111" ===> 1000.accountNo = "1111"
 * 								1000 | "1111"    | 
 * 
 * ac.ower		= "ȫ�浿" ===> 1000.owner = "ȫ�浿"
 * 								1000 | "ȫ�浿"	 |
 * 
 * ac.balance	= 100	===> 1000.getBalance = 100
 * 								1000 | "ȫ�浿" 	 | 100
 * 
 * System.out.println(ac.owner) ==> System.out.println(1000.owner);
 * ac.setAccount("1111");
 * ac.setOwner("ȫ�浿");
 * ac.setBalance(100);
 * System.out.println(ac.getOwner()); ==> System.out.println(1000.getOwner());
 * 
 * 
 * Account[] accs;
 * accs = new Account[100];
 * 		
 * 		stack						heap
 * accs						10000 | | | | | | ...| |	// Account�� ���� �迭
 * 								   0 1 2 3 4      99
 * 
 * accs[0] = new Account()
 * 							10100 | | | | | Account
 * 
 * accs[1] = new Account()
 * 
 * 
 * 
 * 
 * 
 * int i[] = new int[3];
 * 
 * 		stack						heap
 * 	i		20000 			20000 |10| | | | |			// �迭���� ������ �ƴϴ�.
 * 								   0 1 2 3 4
 *  i[0] = 10; 
 *  i[1] = 20;
 *  
 *  
 *  Account ac = new Account()
 *  
 *  	stack						heap
 *  i	10				
 *  ac	10000				10000
 *   	(Account �� stack�� ������ ������ �ּҸ� �ְ� heap�� �����.)
 *  
 *  ac.accountNo = 100 ==> 10000.accountNo = 100
 *  
 *  
 *  // ���� ������ ������ stack�� ��������� ������ ���� ������ heap�� ���������.
 *  int i[] = new int[3]
 *	int i = 10
 *	String str = "ȫ�浿"
 *	float f = 10.5
 *  
 *  Account ac = new Account()
 *  
 *  	stack						heap
 *  i		10					10000	ȫ�浿	
 *  str		10000				20000	| balance| 	|	|
 *  f		10.5
 *  ac		20000
 *  ac.balance
 *  
 *  
 *  
 *  Account[] acc = new Account[3]
 *  int[] i = new int[3]
 *  
 *  	stack						heap
 *  acc		10000				10000	| Account |Account | Account |
 *  i		20000				20000	| int | int | int |
 *  										0	 1		2
 *  i[0] = 10
 *  i[1] = 20
 *  i[2] = 30
 *  
 *  acc[0] = new Account();
 *  acc[1] = new Account();
 *  acc[2] = new Account();
 *  
 * 	Account ac;
 * 	ac = acc[0]
 * 	ac = acc[1]
 * 	ac = acc[2]
 *  
 *    
 *  
 */
}
