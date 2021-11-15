package promotion_access;

public class ChildExample {

	public static void main(String[] args) {

		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();
		
		Parent parent = new Parent();
		parent = child;	 // �θ� �ڽ��� ������ ��� : �ڽĿ��� ���ǵ� ���� ����� �� ����. 
		parent.method1();
		parent.method2();	// �ڽĿ��� �������̵��� �޼���� ��밡���ϴ�.
//		parent.method3();	// Error / 
		
	}
}

/*
 * ������ : �θ� ���������� ������ �������� �ϴ� ��.
 * 			- �ڽ�Ŭ�������� �θ�Ŭ������ ��� �޾ƾ� �Ѵ�.
 * 			- �θ� �ڽ��� ������ �� �־�� �Ѵ�.
 * 			- �ڽĿ��� ���ǵ� �޼���� ����� �� �����Ƿ� �������̵��� �ؾ� �Ѵ�.
 */