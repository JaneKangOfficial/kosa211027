
public class Ex02 extends Ex01 {

	// ������
	public Ex02(int first) {
		super(first);
	}
	
	public void method2() {
		
		// �߻�޼��尡 �ִ� Ŭ������ ��ü ������ �� ���� ����.
//		Ex01 ex01 = new Ex01(12);
		
		// Ȯ���ؼ� ����Ѵ�. extends Ex01
	}

	// �߻�޼��尡 �ִ� �߻�Ŭ������ ����ϸ� �߻�޼���� �������̵��� �ؾ� �Ѵ�.
	@Override
	public void method01() {
		System.out.println("Ex02-method01");
	}
}
