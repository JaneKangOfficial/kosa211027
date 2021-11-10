import java.util.Scanner;

public class AccountHomeWork {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Account[] acc = new Account[100];
		int num = 0;
		boolean run = true;

		do {
			System.out.println("1. 계좌등록 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료 ");
			System.out.print("선택 > ");
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1":
				System.out.println("계좌 등록 페이지입니다.");
				System.out.print("계좌번호 : ");
				String accountNo = sc.nextLine();
				System.out.print("예금주 : ");
				String owner = sc.nextLine();
				System.out.print("금액 : ");
				int balance = sc.nextInt();

				acc[num] = new Account(accountNo, owner, balance);
				// acc[i].setAccountNo(accountNo);
				// acc[i].setOwner(owner);
				// acc[i].setBalance(balance);
				num++;
				System.out.println("계좌등록이 완료되었습니다.");
				System.out.println();
				break;
			case "2":
				System.out.println("계좌 목록 페이지입니다.");
				System.out.println("계좌번호\t\t계좌주\t\t금액");
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
				System.out.println("예금 페이지입니다.");
				System.out.print("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.print("금액 : ");
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
				System.out.println("출금 페이지입니다.");
				System.out.print("계좌번호 : ");
				accountNo = sc.nextLine();
				System.out.print("금액 : ");
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
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		} while (run);
	}

}
