
public class Ex07 {

	public static void main(String[] args) {
		char ch1 = 'A' + 1; // 2byte + 2byte : ���� + ����
		System.out.println(ch1);
		char ch2 = 'C'; // ����
		char ch3 = (char)(ch2 + 1); // (char)(4byte + 4byte) : ���� + ����
		
		short sh = 65 + 60; // 2byte�� 4byte��
		short sh1 = 65;
		short sh2 = 60;
		short sh3 = (short)(sh1 + sh2);
		System.out.println(sh3);
		
		float f1 = 10.5f; // 4byte
		double d1 = 10.6; // 8byte
		double d2 = f1 + d1; // 8byte
		
		// byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//								  ����    <    �Ǽ�
		// 8 -> 4�� �ƴ϶� ���� -> �Ǽ� (�Ǽ��� �� ũ�� ����)
		
		int result = (int)10.5 + 4; // 8byte + 4byte : 4byte + 4byte
		System.out.println(result);
		
		
		/* �ڷ��� : 
		 * 	���� : byte, char, short, int, long
		 * 	�Ǽ� : float, double
		 * 	���ڿ� : String, ""
		 * 	���� : char, ''
		 * 	�ο� : true, false : 1byte
		 */
		
		char ch = 'a';
		ch = 97;
		
	}

}
// 2��(�ڷ���)�� 3��(������)�� ���ϸ� ���α׷��� 80%�� �Ѵ�.