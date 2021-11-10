
public class Ex04 {

	static int first;
	static int second;
	// static 변수는 생성자를 이용해서 초기화 할 수 없다.
	// static 변수를 초기화 할 때에는 static 블럭을 이용한다.
	// 정적 멤버는 객체 생성하지 않고 클래스명으로 바로 접근해 사용
	static {
		first = 10;
		second = 20;
	}
	
	int val;

	public Ex04() {}
	
	public Ex04(int val) {
		this.val = val;
	}
	
	public Ex04(int first, int second) {
//		this.first = first; 	// static 변수 this 사용 못함. => 생성자를 이용해서 초기화 못함.
//		this.second = second;	// static 블럭을 이용해서 초기화한다.
	}
	

}
