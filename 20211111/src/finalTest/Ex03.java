package finalTest;

//final 클래스는 상속을 할 수 없다.
public final class Ex03 {	
	
	int first;
	int second;
	
	public int add() {
		return first + second;
	}
	
	public int div() {
		return first / second;
	}
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
}
