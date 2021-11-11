
public class Singleton {
	
	int first;
	int second;
	
	// �̱��� 
	private static 	  int	 	val    =	10;
	// �̱������� ����� ��� Ŭ�������� �ڱ��ڽ��� ���� private
	// �ڱ� �ڽ��� ��ü�� �̸� ����� ���� ��� private
	private static Singleton singleton = new Singleton(); // �ּ� 3000 
	private Singleton() {}
	// 						aaa�� ��������� �����ڵ鳢���� ��� getInstance()
	public static Singleton getInstance() { // �ڽ��� ��ü�� ����
		return singleton;	// ��ȯ
	}

	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	/*
	 * data (Method)
	 * Singleton {
	 * 		int first;
	 * 		int second;
	 * 		static Singleton singleton = new Singleton();
	 * 		// static Singleton singleton = 2000; // �ּ�
	 * 		// public static Singleton getInstance() {
	 * 				return singleton;
	 * 			}
	 * }
	 * System.out.println(Singleton.singleton);	// 2000
	 * System.out.println(Singleton.getInstance()); // 2000
	 * 
	 * 
	 * Ex01 {
	 * 		int age;
	 * 		String name;
	 * 		static String addr = 10;	// data������ �ִ� ���� // Ŭ������.������
	 * }
	 * 
	 * Ex01 ex01;
	 * ex01 = new Ex01();
	 * System.out.println(Ex01.addr);
	 * 
	 * 
	 * 			stack							heap
	 * 	ex01		1000			1000	| age | name |
	 * 								2000	| first | second |
	 * 
	 * 
	 */
	
	
	
	
	
	
}
