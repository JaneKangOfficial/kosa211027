package inheritance;

public class Ex08 {
	int first;
	int second;
	int result;
	
	public Ex08() {
		System.out.println("부모클래스 객체가 생성되었습니다.");
	}
	
	public Ex08(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public void setFirst(int first) {
		this.first = first;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
	
	public int getFirst() {
		return first;
	}
	
	public int getSecond() {
		return second;
	}
	
	public int getResult() {
		return result;
	}
	
	public void add() {
		result = first + second;
	}
	
	public void div() {
		result = first / second;
	}

}
