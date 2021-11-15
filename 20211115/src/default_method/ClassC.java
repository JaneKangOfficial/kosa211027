package default_method;

public class ClassC extends ClassA {

	public void method04() {
		System.out.println("ClassC-method04");
	}

	@Override
	public void method01() { // ClassA에 있는 추상메서드 오버라이드 무조건!
		System.out.println("ClassC-method01");
	}

	@Override
	public void method02() { // ClassA에 있는 일반메서드 오버라이드 필요에 따라!
		System.out.println("ClassC-method02");
	}
	
}
