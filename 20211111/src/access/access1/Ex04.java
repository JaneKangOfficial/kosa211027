package access.access1;

public class Ex04 {
	
	// protected
	// 다른 패키지에 있는 클래스에서 
	// protected 멤버는 상속이 된다.
	// default 멤버는 상속이 되지 않지만 
	protected int first;
	protected int second;
	protected int result;
	
	public void add() {
		result = first + second;
	}
	
	public void div() {
		result = first / second;
	}
	
}
