package access.access1;

public class Ex07 {

	private int first;
	private int second;
	private int result;
	
	public void add() {
		result = first + second;
	}
	
	public void div() {
		result = first / second;
	}
	
}

/*

public : 어디서든지 상속, 멤버사용 가능하다.

protected : 같은 패키지나 다른 패키지에 있는 클래스 상속된다.
			다른 패키지에 있는 클래스에서는 멤버를 사용할 수 없다.
			
default : 같은 패키지에서는 상속도 되고 멤버도 사용할 수 있다.
			다른 패키지일 때는 상속도 안되고 멤버 사용도 안된다.
			멤버 필드에 접근 지정자를 주지 않으면 기본적으로 설정된다.
	
private : 클래스에서만 사용 가능 (상속 X)
			다른 클래스에서 멤버를 사용할 수 없다.

*/