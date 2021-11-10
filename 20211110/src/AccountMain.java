import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		/*
		Account acc = new Account("1111","홍길동",100);
		Account acc1 = new Account("2222","홍이름",100);
		Account acc2 = new Account("3333","김이름",100);
		*/
		
		int arrayNum = 0; // 배열의 현재 번호를 가지기 위한 변수 
		
		Account[] accs = new Account[100];
		// 배열의 index는 0번부터 시작
		
		boolean run = true;
//		while(run) {
		do {
			System.out.println("1. 계좌등록 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료 ");
			System.out.print("선택 > ");
			
			/*
			int selectNo = sc.nextInt(); // sc.nextLine();은 문자이다.
			sc.nextLine(); // 입력장치에 "\n"값이 있는 것을 없애기 위해 사용
			*/
			String selectNo = sc.nextLine(); // accountNo가 엔터 "\n" 값까지 가져옴, 메모리에 남아있지 않음
												// nextInt는 "\n"값은 안 가지고 옴
			switch(selectNo) {
			case "1":
				System.out.println("계좌등록 페이지입니다.");
				System.out.print("계좌 번호 : ");
				String accountNo = sc.nextLine();
				System.out.print("예금주 : ");
				String owner = sc.nextLine();
				System.out.print("금액 : ");
				int money = sc.nextInt();
				
				accs[arrayNum] = new Account(accountNo, owner, money);
				arrayNum++;
				System.out.println("계좌등록이 완료되었습니다.");
				break;
			case "2":
				System.out.println("계좌목록 페이지입니다.");
				System.out.println("계좌번호 \t\t 계좌주 \t\t 금액");
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == null) break;
					System.out.println(accs[i].getAccountNo() + "\t\t" 
									+ accs[i].getOwner()+ "\t\t"
									+ accs[i].getBalance());
				}
				break;
			case "3":
				System.out.println("예금 페이지입니다.");
				System.out.println("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.println("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				Account acc = null;
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == null) break;
					else {
						if(accs[i].getAccountNo().equals(accountNo)) {
							// 계좌번호가 일치하는 Account를 가지고 와서 acc에 저장.
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
				System.out.println("출금 페이지입니다.");
				System.out.println("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.println("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				acc = null;
				for(int i = 0; i < accs.length; i++) {
					if(accs[i] == null) break;
					else {
						if(accs[i].getAccountNo().equals(accountNo)) {
							// 계좌번호가 일치하는 Account를 가지고 와서 acc에 저장.
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
				System.out.println("프로그램이 종료되었습니다.");
				run = false; break;
//				System.exit(0); // 프로그램 종료
			}
		
		}while(run);
	}
/*
 * 	Account[] accs = 				new Account[100];	// 배열 생성
 * 
 * 	accs[0] = new Account("1111","이름",100);
 * 	accs[1] = new Account("2222","이름2",200);
 * 	accs[2] = new Account("3333","이름3",300);
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
 * 							2000	1111 | 이름 | 100
 * 								accs[0].getAccountNo()	 => 1111
 * 								accs[0].getOwner()		 => 이름
 * 								accs[0].getBalance() 	=> 100
 * 
 * 							2050	2222 | 이름2 | 200
 * 								accs[1].getAccountNo()	 => 2222
 * 								accs[1].getOwner()		 => 이름2
 * 								accs[1].getBalance() 	=> 200
 * 		
 * 							2100	3333 | 이름3	| 300
 *								accs[2].getAccountNo()	 => 3333
 * 								accs[2].getOwner()		 => 이름3
 * 								accs[2].getBalance() 	=> 300
 * 
 * 
 * 
 * 	Account ac = new Account("4444","김이름",2000)
 * 		stack						heap
 * 	ac		1100			1100	accountNo | owner | balance | Account
 * 									  4444	  |	김이름	  |	2000 |
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
 * ac = new Account();	// 2.	// ac = 1000번지 주소
 * 
 * 		1. 							2.
 * 		stack						heap
 * ac 		1000				1000 | accountNo | owner | balance | Account
 * ac.accountNo = "1111" ===> 1000.accountNo = "1111"
 * 								1000 | "1111"    | 
 * 
 * ac.ower		= "홍길동" ===> 1000.owner = "홍길동"
 * 								1000 | "홍길동"	 |
 * 
 * ac.balance	= 100	===> 1000.getBalance = 100
 * 								1000 | "홍길동" 	 | 100
 * 
 * System.out.println(ac.owner) ==> System.out.println(1000.owner);
 * ac.setAccount("1111");
 * ac.setOwner("홍길동");
 * ac.setBalance(100);
 * System.out.println(ac.getOwner()); ==> System.out.println(1000.getOwner());
 * 
 * 
 * Account[] accs;
 * accs = new Account[100];
 * 		
 * 		stack						heap
 * accs						10000 | | | | | | ...| |	// Account를 담을 배열
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
 * 	i		20000 			20000 |10| | | | |			// 배열이지 정수는 아니다.
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
 *   	(Account 는 stack에 못들어가기 때문에 주소를 넣고 heap에 만든다.)
 *  
 *  ac.accountNo = 100 ==> 10000.accountNo = 100
 *  
 *  
 *  // 왼쪽 변수는 무조건 stack에 만들어지고 오른쪽 값은 무조건 heap에 만들어진다.
 *  int i[] = new int[3]
 *	int i = 10
 *	String str = "홍길동"
 *	float f = 10.5
 *  
 *  Account ac = new Account()
 *  
 *  	stack						heap
 *  i		10					10000	홍길동	
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
