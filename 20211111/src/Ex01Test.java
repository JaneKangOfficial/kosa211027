
public class Ex01Test {

	public static void main(String[] args) {

		Ex01 ex01 = new Ex01();
		Ex01 ex02 = new Ex01();
		
		if (ex01 == ex02) {	// ���� �ٸ� �ּ�. �ٸ���!
	  		System.out.println("����");
	 	}else {
	 		System.out.println("�ٸ���");
	 	}
		
		ex01.first = 20;	// ���� �ּҸ� ���� ���� ���;� �Ѵ�.
		System.out.println(ex01.first);
		System.out.println(ex02.first); // 0 // �ּҰ� �ٸ� ���� �ٸ� ��ü�̱� ����
		
		Singleton s1 = Singleton.getInstance(); // 2000 ���� �ּ� ���� ��ü
		Singleton s2 = Singleton.getInstance(); // 2000 ���� �ּ� ���� ��ü
		
		if (s1 == s2) {	// ���� ���� �ּ�. ����!
	  		System.out.println("����");
	 	}else {
	 		System.out.println("�ٸ���");
	 	}
		
		
	}

}
