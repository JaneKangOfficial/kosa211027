package default_method;

public class ClassC extends ClassA {

	public void method04() {
		System.out.println("ClassC-method04");
	}

	@Override
	public void method01() { // ClassA�� �ִ� �߻�޼��� �������̵� ������!
		System.out.println("ClassC-method01");
	}

	@Override
	public void method02() { // ClassA�� �ִ� �Ϲݸ޼��� �������̵� �ʿ信 ����!
		System.out.println("ClassC-method02");
	}
	
}
