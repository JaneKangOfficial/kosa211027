package default_method;

public interface MyInterface {

	public void method1(); // ������ ������ (�������̵�)
	
	// �������̵带 �� ���� �ְ� �� �� ���� �ִ� �޼��� : �ڹ� 7������ abstract Ŭ������ ��밡���ߴµ� �ڹ� 8���ʹ� interface default �޼��带 ����ؼ� �����ϴ�.
	public default void method2() {
		System.out.println("MyInterface-method2 ����");
	}
	
	
}
