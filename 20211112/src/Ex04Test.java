
public class Ex04Test {

	public static void main(String[] args) {

		B b = new B();	// A
		C c = new C();	// A
		D d = new D();	// B, A
		E e = new E();	// C, A
		// ������ : �θ�� �ڽ� ��ü�� ������ �� �ִ�.
		//			�ڽ��� �θ� ��ӹ޾ƾ����� �����ϴ�.
		A a = b; // a�� b�� �Ǿ���.
		a = c;	// a�� c�� �Ǿ���.
		a = d; 	// a�� d�� �Ǿ���.
		a = e; 	// a�� e�� �Ǿ���.
		
		
	}

}