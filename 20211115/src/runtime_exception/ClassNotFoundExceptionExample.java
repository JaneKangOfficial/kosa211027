package runtime_exception;

public class ClassNotFoundExceptionExample {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.util.List111");	// Ŭ������ �������� ������ �̸� try catch���� ����ϸ� ���ڽ��ϴ�.
			System.out.println("Ŭ������ �ֽ��ϴ�.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); // ���� �޼��� ��� , ���� �ܰ迡�� ���� Ȯ�� // �����ڰ� ��� �������� Ȯ���ϱ� ���� �ڵ�
			System.out.println("Ŭ������ �����ϴ�.");
		}
		System.out.println("���α׷� ��");	// ��µȴٸ� ������ ������ �ƴ�, ������ ���� �����ڵ� ����� ��.
	}
}
