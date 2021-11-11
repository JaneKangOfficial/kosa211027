
public class ArrayTest {

	public static void main(String[] args) {
		
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		
		int i[] = new int [3];
		i[0] = i1; // 10
		i[1] = i2; // 20
		i[2] = i3; // 30
		System.out.println(i[0]);	// 정수형 배열 객체 생성
		
		// 			Board 객체
		Board b1 = new Board(1, "홍길동", "제목1", "내용1", 0);
		Board b2 = new Board(2, "김길동", "제목2", "내용2", 0);
		
		Board b[] = new Board[3];	// Board형 배열 객체 생성
//		b[0] = b1;
		
		b[0] = new Board(1, "홍길동", "제목1", "내용1", 0); 
		b[1] = new Board(2, "김길동", "제목2", "내용2", 0);
		b[2] = new Board(3, "이길동", "제목3", "내용3", 0);
		
		for(int n : i) {
			System.out.println(n);
		}
		
		System.out.println(b1); // 주소 출력
		System.out.println(b1.getNum());
		System.out.println(b1.getWriter());
		System.out.println(b1.getSubject());
		System.out.println(b1.getContent());
		System.out.println(b1.getReadCount());
		
		for(Board n : b) {
			System.out.println(n); // 주소 출력
			System.out.print(n.getNum() + " ");
			System.out.print(n.getWriter() + " ");
			System.out.print(n.getSubject() + " ");
			System.out.print(n.getContent() + " ");
			System.out.println(n.getReadCount());	
		}
		
	}

}



/*
* 	객체지향의 개념 3가지
*	캡슐화(필드, 메서드)
*	상속  
*	다형성 
*/

