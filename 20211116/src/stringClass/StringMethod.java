package stringClass;

public class StringMethod {

	public static void main(String[] args) {

		String ssn = "010624-1230123";
		//            01234567890123
		//						1
		// 맨 앞에 0이 있으면 문자
		
		char ch = ssn.charAt(7);
		switch(ch) {
		case '1' :
		case '3' : System.out.println("남자"); break;
		case '2' :
		case '4' : System.out.println("여자"); break;
		}
		System.out.println(ssn.charAt(7));
		
		System.out.println(ssn.charAt(7));
		String str = "나는 자바가 너무 재미있어요";
		//           012 3456 7890 1234
		System.out.println(str.charAt(10));
		// charAt() : index에 해당하는 문자를 가져옴.
		
		// Method 정리
		String str1 = "apple";
		boolean b1 = str1.startsWith("ap"); // 첫글자가 ap로 시작합니까
		System.out.println(b1);	// true
		
		b1 = str1.startsWith("le");
		System.out.println(b1); // false
		
		b1 = str1.endsWith("le");
		System.out.println(b1); // true
		
		str = new String("java");
		str1 = new String("java");
		System.out.println(str1 == str); // false // ==으로 비교는 false로 잘못 나올수가 있다.
		System.out.println(str1.equals(str)); // true // equals를 이용해서 값을 비교해야 한다.
		
		str1 = "I like the java";
		//      012345678901234
		//				  1
		System.out.println(str1.indexOf("t")); // 7 // t가 있는 위치
		System.out.println(str1.indexOf("a")); // 12 // 맨처음 a가 있는 위치
		System.out.println(str1.lastIndexOf("a")); // 14 // 맨뒤 a가 있는 위치
		System.out.println(str1.length()); // 배열 외에는 length()
		int[] ii = new int[5];
		System.out.println(ii.length); // 배열에서만 length : 괄호없음
		
		// I를 i로 문자 변환
		System.out.println(str1.replace('I', 'i'));
		
		// I를 You로 문자열 변환, 정규표현식에 해당하는 문자를 변경 : replaceAll() 
		System.out.println(str1.replaceAll("I", "You"));
		
		str = "A:B:C:D:abcd";
		String[] str2 = str.split(":"); 	// 문자열을 split을 하면 자바에서는 배열로 저장, 파이썬에서는 리스트로 저장된다.
		System.out.println(str2[1]);	// B
		
		str = "A B C D abcd";
		str2 = str.split(" ");
		System.out.println(str2[1]);	// B

		// 파이썬 slicing : a = "abcdef" : a[1:3] substring
		str1 = "abcdef";
		System.out.println(str1.substring(1, 1 + 2));
	
		str1 = "abcDEF";
		System.out.println(str1.toLowerCase());
		System.out.println(str1.toUpperCase());

		Integer i = 10;
		str = "10" + i.toString();	// toString : 숫자를 문자로 변경
		System.out.println(str);	// 1010
		
		str1 = " abc DEF "; // 파이썬 : strip 양쪽 공백 삭제
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
