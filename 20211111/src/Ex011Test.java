
public class Ex011Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();	// 		stack				heap
		Ex01 ex02 = ex01;		//	ex01	1000		1000 | first | second |
								//	ex02	1000
		Ex01 ex03 = new Ex01();	//	ex03	2000		2000 | first | second |
		
		ex01.first = 30;
		System.out.println(ex01.first);	// 30
		System.out.println(ex02.first);	// 30
		System.out.println(ex03.first);	// 0
		
		if(ex01 == ex02) {	// ���� ���� �ּ� : ���� ��ü
			System.out.println("ex01�� ex02�� ���� ��ü�̴�.");
		}else {
			System.out.println("�ٸ� ��ü�̴�.");
		}
		
		if(ex01 == ex03) {	// ���� �ٸ� �ּ� : �ٸ� ��ü
			System.out.println("���� ��ü�̴�.");
		}else {
			System.out.println("ex01�� ex03�� �ٸ� ��ü�̴�.");
		}
		
		// static Ű���尡 �ִ� ��� ������ ��ü �������� Ŭ���������� ����� �� �ִ�.
//		int result = Singleton.val;	 // private �̱� ������ �ܺο��� ���� ������ �Ұ�.
//		Singleton s = Singleton.singleton;	// private
		Singleton s = Singleton.getInstance(); // s = 3000 �ּ�
		Singleton s1 = Singleton.getInstance(); // s1 = 3000 �ּ�
		
		if(s == s1) {	// ���� ���� �ּ� : ���� ��ü
			System.out.println("s�� s1�� ���� ��ü�̴�.");
		}else {
			System.out.println("s�� s1�� �ٸ� ��ü�̴�.");
		}
		
		
	}

}
