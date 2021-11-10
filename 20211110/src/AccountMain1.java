import java.util.Scanner;

public class AccountMain1 {
	// static main 메서드 안에서 사용하려면 static이 붙어야 한다.
	static Account[] accs = new Account[100];
	// 배열의 index는 0번부터 시작
	static Scanner sc = new Scanner(System.in);
	static int arrayNum = 0; // 배열의 현재 번호를 가지기 위한 변수 
	static boolean run = true;
	
	public static void main(String[] args) {
		
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
				System.out.println("계자목록 페이지입니다.");
				System.out.println("계좌번호 \t\t 계좌주 \t\t 금액");
				
				accountPrint();
				
				System.out.println();
				break;
			case "3":
				System.out.println("예금 페이지입니다.");
				System.out.println("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.println("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				
				Account acc = accountFind(accountNo);
				
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
				
				acc = accountFind(accountNo);
				
				result = acc.getBalance() - money;
				acc.setBalance(result);
				System.out.println();
				break;
			case "5":
				System.out.println("프로그램이 종료되었습니다.");
				run = false; break;
//					System.exit(0); // 프로그램 종료
			}
		
		}while(run);
	}
	
	public static Account accountFind(String accountNo) {
		for(int i = 0; i < accs.length; i++) {
			if(accs[i] == null) break;
			else {
				if(accs[i].getAccountNo().equals(accountNo)) {
					// 계좌번호가 일치하는 Account를 가지고 와서 acc에 저장.
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
 * class : Data (Method) 영역
 * class Account {
 * 		String accountNo;	// heap 영역에 instance 변수로 존재
 * 		String owner;
 * 		int balance;
 * 		static int val;		// static은 class내에만 존재하는 변수 = 클래스 변수
 * 							// 모든 객체내에서 값을 공유해서 사용해야 하는 경우
 * }
 * 
 * Account ac1 = new Account()
 * Account ac2 = new Account()
 * 
 * 		stack								heap
 *  ac1		10000			10000	| accountNo | owner | balance| ==> ac1 객체 = instance
 * 	ac2		20000			20000	| accountNo | owner | balance| ==> ac2 객체 = instance
 *											instance 변수 = this.accountNo
 *											멤버변수 : 객체 내에 있는 변수 	
 *											static이 있으면 class내에만 있다.
 *	
 * 	ac1.val = 10 // val이 static 이기 때문에 instance가 아닌 클래스에 10이 저장된다.
 *	System.out.println(ac2.val); // 10이 class에 저장되어 있기 때문에 ac2.val의 값도 10이 된다. 
 *	System.out.println(Account.val) // 10 출력
 *
 */	
}
