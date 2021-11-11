package inheritance;

public class Ex09 extends Ex08{

	int val;
	
	// 자식클래스에서 default 생성자는 사용하지 못한다. - 부모클래스 생성자에 값을 전달해야 되기 때문
	// 부모클래스에 생성자가 있으면 자식클래스에서 초기값을 전달할 수 있는 생성자가 꼭 필요하다.
	public Ex09(int first, int second, int val) {
		super(first, second);
		this.val = val;
	}
	
	public void sub() {
		result = first - second;
	}
	
	public void mul() {
		result = first * second;
	}
	
	@Override
	public void div() { // 부모가 가진 메서드를 자식에서 재정의
		if(second == 0) {
			result = 0;
		}else {
			result = first / second;
		}
	}
	
	public void div1() {
		super.div(); 	// 재정의 되지 않은 부모 클래스에 있는 메서드를 호출 
	}
	
	
}
