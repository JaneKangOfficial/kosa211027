

import java.util.Scanner;

public class BoardHomeWork {

	static Board b[] = new Board[100];
	static Board bb = null;
	static int readCount = 0;
	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int numCount = 0;
		
		do {
			System.out.println("글쓰기 1 | 상세보기 2 | 종료 3");
			System.out.print("번호 선택 : ");
			String selectNum = sc.nextLine();

			switch (selectNum) {
			case "1":
				System.out.println("글작성 페이지입니다.");
				System.out.print("글쓴이 : ");
				String writer = sc.nextLine();
				System.out.print("제목 : ");
				String subject = sc.nextLine();
				System.out.print("내용 : ");
				String content = sc.nextLine();

				System.out.println("저장하려면 y 다시 쓰려면 n : ");
				String add = sc.nextLine();
				System.out.println("add : " + add);
				switch (add) {
				case "y":
					System.out.println("등록이 완료되었습니다.");
					
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
				System.out.println("상세보기 페이지입니다.");
				System.out.print("보고싶은 게시글 번호를 입력해주세요 : ");
				int nu = Integer.parseInt(sc.nextLine());

				boardFind(nu);
				
				System.out.println("=================================");
				System.out.println("목록으로 가기 : 1 | 수정 : 2 | 삭제 : 3");

				String selectNum2 = sc.nextLine();
				switch (selectNum2) {
				case "1":
					System.out.println("목록페이지입니다.");
					System.out.println("글목록");
					
					boardPrint();
					
					System.out.println("=================================");
					continue;

				case "2":
					System.out.println("수정페이지입니다.");
					System.out.println("글쓴이를 수정하려면 1 | 제목을 수정하려면 2 | 내용을 수정하려면 3");

					String select = sc.nextLine();
					switch (select) {
					case "1":
						System.out.println("글쓴이를 수정합니다.");
						System.out.println("수정할 글쓴이를 입력하세요 : ");
						String writer2 = sc.nextLine();
						bb.setWriter(writer2);
						break;

					case "2":
						System.out.println("제목을 수정합니다.");
						System.out.println("수정할 제목을 입력하세요 : ");
						String subject2 = sc.nextLine();
						bb.setSubject(subject2);
						break;

					case "3":
						System.out.println("내용을 수정합니다.");
						System.out.println("수정할 내용을 입력하세요 : ");
						String content2 = sc.nextLine();
						bb.setContent(content2);
						break;
					}
				continue;
				
				case "3":
					System.out.println("삭제합니다.");
					System.out.println("삭제할 번호를 입력해주세요 : ");
					int delete = Integer.parseInt(sc.nextLine());
					
					boardFind(delete);
					
					bb.setNum(0);
					bb.setWriter(null);
					bb.setSubject(null);
					bb.setContent(null);
					bb.setReadCount(0);
					
				continue;
				}

			case "3":
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			}

		} while (run);

	}
	
	public static Board boardFind(int a) {
		
		for (int i = 0; i < b.length; i++) {

			if (b[i] == null) {
				System.out.println("없는 번호입니다.");
				break;
			} else if (b[i].getNum() == a) {
				bb = b[i];
				break;
			}
		}
		bb.setReadCount(bb.getReadCount() + 1);
		System.out.println("번호 : " + bb.getNum());
		System.out.println("글쓴이 : " + bb.getWriter());
		System.out.println("제목 : " + bb.getSubject());
		System.out.println("내용 : " + bb.getContent());
		System.out.println(bb.getReadCount());
		System.out.println();
		return bb;
	}
	
	public static void boardPrint() {
		System.out.println("번호\t\t글쓴이\t\t\t제목\t\t\t내용\t\t\t읽은수");
		for (Board n : b) {
			if (n == null)
				break;
			System.out.print(n.getNum() + "\t\t" + n.getWriter() + "\t\t\t" + n.getSubject() + "\t\t\t"
					+ n.getContent() + "\t\t\t");
			System.out.println(n.getReadCount());
		}
		System.out.println();
	}
	
}
