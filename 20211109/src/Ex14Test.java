
public class Ex14Test {

	public static void main(String[] args) {

		Ex14 ex14 = new Ex14(50, 20);
		
//		1. �Է� ���� �ְ� �����(��ȯ��)�� �ִ� �޼���
		int num = ex14.add(20, 10);
		System.out.println(num);
		
//		2. �Է� ���� �ְ� ��� ���� ���� �޼���
		ex14.sub(30.0, 15);
		
//		3. �Է°��� ���� ������� �ִ� �޼���
		num = ex14.mul();
		System.out.println(num);
		
//		4. �Է°��� ���� ������� ���� �Լ�
		ex14.div();
		
		ex14.add = 10;
		System.out.println(ex14.add);
		
		
		
		
		
		
		
	}

}
