
public class Ex02Test {

	public static void main(String[] args) {

		// final ������ �����ڸ� ���ؼ� �ʱ�ȭ�� ����
		Ex02 ex02 = new Ex02(10, 20, "100");
		// �ʱ�ȭ �� ���� �������� ���Ѵ�. = ���
//		ex02.first = 20;	// private �� ��� �ܺο��� ������ ���������� final �̱� ������ ���� �Ұ�.
		
		// instance ��ü���� final ������ ���� ������ ���� �� �ִ�.
		Ex02 ex021 = new Ex02(30,40, "100");
		System.out.println(ex02.FIRST);
		System.out.println(ex021.FIRST);
		
		
		
		
	}

}
