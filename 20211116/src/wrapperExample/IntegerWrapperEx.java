package wrapperExample;

public class IntegerWrapperEx {

	public static void main(String[] args) {

		int i = 10;
		String s = "10";
		
		// Wrapper �ڷ��� 
		Integer i1 = 10;	// int�� ����.
		i1 = Integer.parseInt(s);
		
		byte by = 10;
		Byte by1 = 10;	// Wrapper �ڷ���
		
		short sh = 10;
		Short sh1 = 10;	// Wrapper �ڷ���
		
		double d = 10.5;
		Double d1 = 10.5;	// Wrapper �ڷ���
		
		float f = 10.5f;
		Float f1 = 10.5f;	// Wrapper �ڷ���
//		f = null; 	// �Ϲ� �ڷ����� null ���� ������ ���� ����.// null : ���� �����ϵ� ��� �������� �𸣴� ��.
		f1 = null;	// Wrapper : ���ڿ��� ���ڷ� ��ȯ�ϱ⵵ ������ null ���� �����ϱ� ���ؼ� �ַ� ���
		
	}

}
