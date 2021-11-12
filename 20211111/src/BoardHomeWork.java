import java.util.Scanner;

public class BoardHomeWork {

	public static void main(String[] args) {
		
		Board b[] = new Board[100];
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int numCount = 0;
		do {
			System.out.println("글쓰기 1 | 상세보기 2");
			System.out.print("번호 선택 : ");
			String selectNum = sc.nextLine();
			switch(selectNum) {
			case "1" : 
				System.out.println("글작성 페이지입니다.");
				System.out.print("글쓴이 : ");
				String writer = sc.nextLine();
				System.out.print("제목 : ");
				String subject = sc.nextLine();
				System.out.print("내용 : ");
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
//						System.out.println("없음");
//						break;
//					}
//					System.out.println("있음");
////					b[numCount] = new Board(num, writer, subject, content, readCount);
//					System.out.println(b[numCount]);
//					num++;
//				}
				
				System.out.println("등록이 완료되었습니다.");
				System.out.println();
				break;
			case "2" : 
				Board bb = null;
				System.out.println("상세보기 페이지입니다.");
				System.out.print("보고싶은 게시글 번호를 입력해주세요 : ");
				int nu = Integer.parseInt(sc.nextLine());
				
				for(int i = 0; i < b.length; i++) {
					if (b[i].getNum() == nu) {
						bb = b[i];
						break;
					}else {
						System.out.println("없는 번호입니다.");
						break;
					}
				}
					
				System.out.println("번호 : " + bb.getNum());
				System.out.println("글쓴이 : " + bb.getWriter());
				System.out.println("제목 : " + bb.getSubject());
				System.out.println("내용 : " + bb.getContent());
				System.out.println(bb.getReadCount());
				System.out.println();
				System.out.println("=================================");
				System.out.println("목록으로 가기 : 1 | 수정 : 2 | 삭제 : 3");
				selectNum = sc.nextLine();
				switch(selectNum) {
				case "1" :
					System.out.println("목록페이지입니다.");
					System.out.println("글목록");
					System.out.println("번호\t\t글쓴이\t\t\t제목\t\t\t내용\t\t\t읽은수");
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
					System.out.println("수정페이지입니다.");
					break;
				case "3" : 
					System.out.println("삭제합니다.");
					break;
				}
				break;
			case "z":
				System.out.println("종료");
				run = false; break;
			}
			
		}while(run);
		
		
		
		
		
		
		
		
	}
}
