
public class Ex03Test {

	public static void main(String[] args) {

		Ex03 ex031 = new Ex03();
		ex031.first = 10;
		ex031.second = 20;
		ex031.val = 30;
		
		Ex03 ex032 = new Ex03();
		System.out.println(ex032.first); 	// 0
		System.out.println(ex032.second); 	// 0
		System.out.println(ex032.val);		// 30
		
		System.out.println(Ex03.val); 		// 30
		
		int result = ex031.add();			// 30 + 10 = 40
		System.out.println(result);
		
		result = ex032.add();				// 30 + 0 = 30
		System.out.println(result);
		
		
		result = Ex03.sub(); // sub �޼ҵ忡 static�� �ֱ� ������ instance���� ��� �Ұ�. Ŭ���������� ȣ��
		// �޼��忡 static Ű���尡 �ִ� ��� Ŭ�������� �̿��ؼ� ����ϱ� ���� �޼����̴�.
		// static �޼��峻���� this Ű���带 ����� �� ����. 
		
		
	}

/*
 * ����(static) ������ ��� instance(��ü)���� ���� �����ϱ� ���ؼ� 
 * Ŭ�������� �����ϵ��� ������� �����̴�.
 * Ŭ������.����
 * 
 * ���� �޼���� instance(��ü)�� �ƴ� Ŭ�������� �̿��ؼ� �޼��带 ����ϱ� ���� ������� �޼����̴�. 
 * �׷��� this Ű���带 ������� ���ϹǷ� instance(��ü)���� (�������)�� ������� ���ϹǷ� static ������ ����ؾ� �Ѵ�. 
 * 
 * 
 * 
 */
	
	
	
}
