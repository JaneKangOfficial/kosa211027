package stringClass;

public class StringMethod {

	public static void main(String[] args) {

		String ssn = "010624-1230123";
		//            01234567890123
		//						1
		// �� �տ� 0�� ������ ����
		
		char ch = ssn.charAt(7);
		switch(ch) {
		case '1' :
		case '3' : System.out.println("����"); break;
		case '2' :
		case '4' : System.out.println("����"); break;
		}
		System.out.println(ssn.charAt(7));
		
		System.out.println(ssn.charAt(7));
		String str = "���� �ڹٰ� �ʹ� ����־��";
		//           012 3456 7890 1234
		System.out.println(str.charAt(10));
		// charAt() : index�� �ش��ϴ� ���ڸ� ������.
		
		// Method ����
		String str1 = "apple";
		boolean b1 = str1.startsWith("ap"); // ù���ڰ� ap�� �����մϱ�
		System.out.println(b1);	// true
		
		b1 = str1.startsWith("le");
		System.out.println(b1); // false
		
		b1 = str1.endsWith("le");
		System.out.println(b1); // true
		
		str = new String("java");
		str1 = new String("java");
		System.out.println(str1 == str); // false // ==���� �񱳴� false�� �߸� ���ü��� �ִ�.
		System.out.println(str1.equals(str)); // true // equals�� �̿��ؼ� ���� ���ؾ� �Ѵ�.
		
		str1 = "I like the java";
		//      012345678901234
		//				  1
		System.out.println(str1.indexOf("t")); // 7 // t�� �ִ� ��ġ
		System.out.println(str1.indexOf("a")); // 12 // ��ó�� a�� �ִ� ��ġ
		System.out.println(str1.lastIndexOf("a")); // 14 // �ǵ� a�� �ִ� ��ġ
		System.out.println(str1.length()); // �迭 �ܿ��� length()
		int[] ii = new int[5];
		System.out.println(ii.length); // �迭������ length : ��ȣ����
		
		// I�� i�� ���� ��ȯ
		System.out.println(str1.replace('I', 'i'));
		
		// I�� You�� ���ڿ� ��ȯ, ����ǥ���Ŀ� �ش��ϴ� ���ڸ� ���� : replaceAll() 
		System.out.println(str1.replaceAll("I", "You"));
		
		str = "A:B:C:D:abcd";
		String[] str2 = str.split(":"); 	// ���ڿ��� split�� �ϸ� �ڹٿ����� �迭�� ����, ���̽㿡���� ����Ʈ�� ����ȴ�.
		System.out.println(str2[1]);	// B
		
		str = "A B C D abcd";
		str2 = str.split(" ");
		System.out.println(str2[1]);	// B

		// ���̽� slicing : a = "abcdef" : a[1:3] substring
		str1 = "abcdef";
		System.out.println(str1.substring(1, 1 + 2));
	
		str1 = "abcDEF";
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());

		Integer i = 10;
		str = "10" + i.toString();	// toString : ���ڸ� ���ڷ� ����
		System.out.println(str);	// 1010
		
		str1 = " abc DEF "; // ���̽� : strip ���� ���� ����
		System.out.println(str1.trim()); // "abc DEF"

		str1 = "I like the java";
		// 		012345678901234
		//				  1
		int start = str1.indexOf("t");
		System.out.println(str1.substring(start, start + 8)); // "the java"
		
		str = "A:B/C-D,abcd";
		str2 = str.split(":|/|-|,");
		System.out.println(str2[1]); // B
		
	}

}
