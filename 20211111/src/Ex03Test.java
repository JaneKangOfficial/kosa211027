
public class Ex03Test {

	public static void main(String[] args) {
		// 
		System.out.println(Ex03.name);
		Ex03.name = "�̼���";
		System.out.println(Ex03.name);
		
		// final ������ ��ü���� ���� �ʱ�ȭ�� �� �ִ�. �� �ѹ� �ʱ�ȭ�� �ϸ� ������ �� ����.
		// �����ڷ� �ʱ�ȭ
		Ex03 ex03 = new Ex03(20,30);
		Ex03 ex031 = new Ex03(50, 20);
		System.out.println(ex03.getVal1());		// 20
		System.out.println(ex031.getVal1());	// 50
		System.out.println("=====");
		
		// ����� ����ϴ� ������ ��� ��ü���� ������� ���� ������ ���� ����ϱ� ���ؼ� 
		System.out.println(ex03.first);		// 10
		System.out.println(ex03.second);	// 5
		System.out.println(ex031.first);	// 10
		System.out.println(ex031.second);	// 5
		
		// final Ű���带 ������ �־ �� ������ ���� ����.
//		ex03.first = 10;
		
		
		
		
	}

}
