
public class Ex10 {

	public static void main(String[] args) {
		// ���Կ����� : =
		int i = 10;
		System.out.println(i);
		
		i += 1; // i = i + 1, i++ / 2�׺��ٴ� 1�� ���
		System.out.println(i); // 11
		i += 2; // i = i + 2
		System.out.println(i); // 13
		i -= 2; // i = i - 2
		System.out.println(i); // 11
		i *= 2; // i = i * 2
		System.out.println(i); // 22
		i /= 2; // i = i / 2
		System.out.println(i); // 11
		i %= 3; // i = i % 3;
		System.out.println(i);// 2
		
		int a,b,c;
		a = b = c = 100;
		String str = "hello " + "java";
		System.out.println(str);
		String str1 = "hello";
		String str2 = "java";
		str = str1 + " " + str2;
		System.out.println(str);
		System.out.println("a, b, c�� " + 100);
		
		str = "3 * 7 = " + 21; // ���ڰ� ���ڿ��� �ڵ�����ȯ
		System.out.println(str);
		
		// ���׿�����
		i = 70;
		System.out.println(i > 60 ? "�հ�" : "���հ�");
//		                    1��    2��(true)  3��(false)
		
//		if (i > 60) {
//			System.out.println("�հ�");
//		}else {
//			System.out.println("���հ�");
//		}
		
		// +, -, *, /, %
	}

}
