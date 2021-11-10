// 캡슐화
public class Ex01 {

	// 멤버 필드, 멤버 변수
	int first;
	int second;
	int result;

	// 생성자
	public Ex01() {} // 기본 생성자 : 다른 생성자가 없는 경우 byte코드 파일에 자동으로 생기는 생성자
	//								다른 생성자가 있는 경우 디폴트 생성자를 명시해 주어야 한다.
	
	public Ex01(int first) {
		this.first = first;
		this.second = 20;
	}
	
	public Ex01(int first, int second) { // 이름은 같지만 매개변수의 순서, 타입, 개수가 다름 : 생성자 오버로딩
		this.first = first;
		this.second = second;
	}
	
	// 메서드
	public void setFirst(int first)  {
		this.first = first;
	}
	
	public int getFirst() {	 // 매개변수가 없는 경우 멤버 필드 this 생략 가능
		return first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public int add() { // 메서드 오버로딩
		return this.first + this.second;
	}
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public void add(int num1) {
		System.out.println(num1 + this.first);
	}
	
	
	
	
}
