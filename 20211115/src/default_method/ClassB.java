package default_method;

public class ClassB extends ClassA {

	public void method03() {
		System.out.println("ClassB-method03");
	}

	@Override
	public void method01() { // 추상메서드
		System.out.println("ClassB-method01");
	}
	
	// 상속받은 일반메서드는 오버라이드를 하지 않아도 된다.
	
}
