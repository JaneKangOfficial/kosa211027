
public interface Ex03 {
	// interface�� ���, �߻�޼��带 ������ ����
	
	// ���
	static final int FIRST = 0;
	
	// �߻�޼���
	public void method01();	// �������̵��ؼ� ���
	
	// ��ü������ �� �� ���� �߻�޼��带 ���� interface������ �����ڰ� �ʿ����.
	// �Ϲݸ޼��� ����. �������̵��ؼ� ����� ���̱� ������. // ���� ������ ����ʵ� �ʿ����.
	// �޼��尡 �ϴ� ������ �ܺηκ��� ����ʵ� ���� ���� �ްų� ����ʵ忡 �ִ� ���� �ܺο� �����ϱ� ���ؼ� ���. setter, getter ����.
	
	// �ڹ� ���� 8���� default, static �߰� �� 
	default void method02() {
		System.out.println("default-method");
	}
	
	static void method03() {
		System.out.println("static-method");
	}
	
}
