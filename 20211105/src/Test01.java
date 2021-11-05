

public class Test01 {

	public static void main(String[] args) {

//		1. 반복을 위한 변수 i의 초기값이 1이고 10번을 반복 수행을 할 때 i가 출력되도록 하시오.
		System.out.println("===1===");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
//		2. 반복을 위한 변수 i의 초기값이 1일고 10번을 반복 수행을 할 때 변수 y가 반복될 때마다 1씩 증가하는 값이 출력되도록 하시오.
		System.out.println("===2===");
		int y = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.println(y);
			y++;
		}
		
//		3. 반복을 위한 변수 i가 5회 수행하는 동안 초기 값 0을 가지는 변수y1를 반복문 안에서 1증가 하도록 하되 변수y1계속 반복문안에서 
//		   한번만 1증가 된 값이 출력되도록 하시오. 변수 y1에 0을 대입해서는 안된다. 단 초기화는 가능.
		System.out.println("===3===");
		int y1 = 0;
		for(int i = 1; i <= 5; i++) {
			y1++;
			System.out.println(y1);
		}
		
//		4. 반복이 10번 수행이 되는 동안 "이쓰앰님을 전적으로 믿으셔야합니다."를 출력하시오.
		System.out.println("===4===");
		for (int i = 1; i <= 10; i++) {
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
		}
		
//		5. 반복 변수 i가 초기값 10을 가지고 있으며 10회를 반복할 때 변수 i를 출력할 때 2씩 증가한 값만 출력되도록 하시오.
		System.out.println("===5===");
		for (int i = 10; i <= 20; i+=2) {
			System.out.println(i);
		}
		
//		6. 반복 변수 i가 초기값 10을 가지고 있으며 10회를 반복할 때 변수 i를 출력할 때 홀수 값만 출력되도록 하시오.
		System.out.println("===6===");
		for (int i = 10; i <= 20; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
		
//		7. 반복 변수 i가 초기값 10을 가지고 있으며 25회를 반복할 때 변수 i를 출력할 때 4씩 증가한 값만 출력되도록 하시오.
		System.out.println("===7===");
		for(int i = 10; i <= 25; i+=4) {
			System.out.println(i);
		}
		
//		8. 반복 변수 i가 12부터 20회를 반복할 때 "개발을 잘하려면 자바를 들이셔야합니다"를 4회만 출력되도록 하시오.(나이도 2.5)
		System.out.println("===8===");
		for(int i = 12; i <= 20; i++) {
			if (i % 2 != 0) {
				System.out.println("개발을 잘하려면 자바를 들이셔야합니다");
			}
		}
		
//		9. 구구단 4단을 출력하시오.
		System.out.println("===9===");
		for (int i = 1; i <= 9; i++)  {
			System.out.println("4 * " + i + " = " + 4 * i);
		}
		
//		10. 구구단 6단 중 홀수 곱만 출력하시오.
		System.out.println("===10===");
		for (int i = 1; i <= 9; i++)  {
			if (i % 2 != 0) {
				System.out.println("6 * " + i + " = " + 6 * i);
			}
		}
		
//		11. 구구단 7단을 출력하되 홀수만을 출력하되 반복변수는 사용하지 말것.
		System.out.println("===11===");
		for (int i = 1; i <= 9; i++)  {
			if (i % 2 != 0) {
				System.out.println("7 * " + i + " = " + 7 * i);
			}
		}
		
//		12. 구구단 6단 중 짝수 곱만 출력하시오.
		System.out.println("===12===");
		for (int i = 1; i <= 9; i++)  {
			if (i % 2 == 0) {
				System.out.println("6 * " + i + " = " + 6 * i);
			}
		}
		
//		13. 1부터 10까지의 합을 구하시오.
		System.out.println("===13===");
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		14. 10부터 1000까지의 합을 구히시오.
		System.out.println("===14===");
		sum = 0;
		for(int i = 10; i <= 1000; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		15. 6단을 출력할 때 3곱부터 8곱까지만 출력하시오.
		System.out.println("===15===");
		for (int i = 3; i <= 8; i++)  {
			System.out.println("6 * " + i + " = " + 6 * i);
		}
		
//		16. Math.random()함수를 사용해서 1부터 45까지의 랜덤 수 중 하나를 가지고 와서 랜덤 수 만큼 
//	    "개발을 잘하려면 자바를 들이셔야합니다"를 출력하시오. (복원 추출, 중복 허용)
		System.out.println("===16===");
		int num = (int)(Math.random() * 45) + 1;
		System.out.println(num);
		for(int i = 1; i <= num; i++) {
			System.out.println("개발을 잘하려면 자바를 들이셔야합니다");
		}
		
//		17. 1부터 45까지의 랜덤 값 중 짝수인것만 곱하도록 3단을 만들고 반복은 10회 한다.
		System.out.println("===17===");
		for(int i = 1; i <= 10; i++) {
			num = (int)(Math.random() * 45) + 1;
			System.out.println(num);
			if (num % 2 == 0 ) {
				System.out.println("3 * " + num + " = " + 3 * num);
			}
		}
		
//		18. 1부터 45중 랜덤수 6개만 가지고 오시오 (복원 추출, 중복 허용)
		System.out.println("===18===");
		for (int i = 1; i <= 6; i++) {
			num = (int)(Math.random() * 45) + 1;
			System.out.println(num);
		}
		
//		19. 3단을 출력할때 2부터 5곱까지 만 출력하시오. 단, 반복 변수는 사용하지 마시오.
		System.out.println("===19===");
		for(int gop = 2; gop <= 5; gop++) {
			System.out.println("3 * " + gop + " = " + 3 * gop);
		}
		
//		20. 변수 x와 변수 z가 있을 때 반복변수 i는 x가 가지고 있는 값부터 z가 가지고 있는 값까지 변수 g만큼씩 증가하여 반복하여
//	     "우리 열공하여 취업을 잘합시다"를 출력하시오.
		System.out.println("===20===");
		int x = 3;
		int z = 30;
		int g = 5;
		for (int i = x; i <= z; i+=g) {
			System.out.println("우리 열공하여 취업을 잘합시다");
		}
		
//		21. i는 1부터 15까지 1씩 증가하여야 하며 y는 1000 부터 10씩 감소 할때만 반복이 이루어져야 한다.
//	    이 때 "자바는 나의 사랑"이라는 문구가 출력되도록 하시오.
		System.out.println("===21===");
		for (int i = 1; i <= 15; i++) {
			for (y = 1000; y >= 0; y-=10) {
				System.out.println("자바는 나의 사랑");
			}
		}
		
//		22. i는 1부터  1씩 증가한 값이 15이거나  y는 1000 부터 20씩 감소한 값이 0일때 까지 반복이 이루어져야 한다.
		System.out.println("===22===");
		for (int i = 1; i <= 15; i++) {
			for (y = 1000; y >= 0; y-=20) {
				System.out.println("자바는 나의 사랑");
			}
		}
		
//		23. 3단부터 8단까지 출력
		System.out.println("===23===");
		for(int dan = 3 ;  dan <= 8; dan++){
			System.out.println(dan + "단");
			for(int gop = 1; gop <= 9; gop++){
				System.out.println( dan + " * " + gop + "= " + dan * gop ); 
			}
		}

//		24. 3단부터 7단까지 출력을 하는데 4곱부터 8곱까지만 출력하시오.
		System.out.println("===24===");
		for(int dan = 3 ;  dan <= 7; dan++){
			System.out.println(dan + "단");
			for(int gop = 4; gop <= 8; gop++){
				System.out.println( dan + " * " + gop + "= " + dan * gop ); 
			}
		}
		
//		25. 
//		6단 시작
//		6 * 4= 24
//		6 * 5= 30
//		6 * 6= 36
//		6단 끝
//		7단 시작
//		7 * 4= 28
//		7 * 5= 35
//		7 * 6= 42
//		7단 끝
		System.out.println("===25===");
		for(int dan = 6 ;  dan <= 7; dan++){
			System.out.println(dan + "단 시작");
			for(int gop = 4; gop <= 6; gop++){
				System.out.println( dan + " * " + gop + "= " + dan * gop ); 
			}
			System.out.println(dan + "단 끝");
		}
		
//		26. 
//		6단 시작
//		6 * 4= 24         6 * 5= 30         6 * 6= 36
//		6단 끝
//		7단 시작
//		7 * 4= 28         7 * 5= 35         7 * 6= 42
//		7단 끝
		System.out.println("===26===");
		for(int dan = 6 ;  dan <= 7; dan++){
			System.out.println(dan + "단 시작");
			for(int gop = 4; gop <= 6; gop++){
				System.out.print( dan + " * " + gop + "= " + dan * gop + "\t" ); 
			}
			System.out.println("\n" + dan + "단 끝");
		}
		
//		27. 임의의 단의 범위를 가지는 dan1과 dan2가 있고 임의의 곱의 범위를 가지는  gom1과 gom2가 있는 
//        6         7                                                   4        6
//		위 조간에 맞게 출력될 수 있게 프로그래밍 하시오.
		System.out.println("===27===");
		int dan2 = 6;
		for(int dan1 = 4 ;  dan1 <= dan2; dan1++){
			int gop2 = 7;
			for(int gop1 = 6; gop1 <= gop2; gop1++){
				System.out.println( dan1 + " * " + gop1 + "= " + dan1 * gop1 ); 
			}
		}
		
//		28. html 의 table 태그 출력
//		<table>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
//		</table>
		System.out.println("===28===");
		System.out.println("<table>");
		for (int i = 1; i <= 4; i++) {
			System.out.print("<tr>");
			for (int j = 1; j <= 4; j++) {
				System.out.print("<td>" + j + "</td>");
			}
			System.out.print("</tr>\n");
		}
		System.out.println("</table>");
		
//		30. 1부터 45까지의 수 중 6개를 추출하여 출력하는 데 6개의 수를 5번 출력하시오.
		System.out.println("===30===");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6; j++) {
				num = (int)(Math.random() * 45) + 1;
				System.out.println(num);
			}
			System.out.println("-" + i + "번 -");
		}
		
		
		
		
	}

}
