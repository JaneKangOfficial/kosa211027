

public class Test01 {

	public static void main(String[] args) {

//		1. �ݺ��� ���� ���� i�� �ʱⰪ�� 1�̰� 10���� �ݺ� ������ �� �� i�� ��µǵ��� �Ͻÿ�.
		System.out.println("===1===");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
//		2. �ݺ��� ���� ���� i�� �ʱⰪ�� 1�ϰ� 10���� �ݺ� ������ �� �� ���� y�� �ݺ��� ������ 1�� �����ϴ� ���� ��µǵ��� �Ͻÿ�.
		System.out.println("===2===");
		int y = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.println(y);
			y++;
		}
		
//		3. �ݺ��� ���� ���� i�� 5ȸ �����ϴ� ���� �ʱ� �� 0�� ������ ����y1�� �ݺ��� �ȿ��� 1���� �ϵ��� �ϵ� ����y1��� �ݺ����ȿ��� 
//		   �ѹ��� 1���� �� ���� ��µǵ��� �Ͻÿ�. ���� y1�� 0�� �����ؼ��� �ȵȴ�. �� �ʱ�ȭ�� ����.
		System.out.println("===3===");
		int y1 = 0;
		for(int i = 1; i <= 5; i++) {
			y1++;
			System.out.println(y1);
		}
		
//		4. �ݺ��� 10�� ������ �Ǵ� ���� "�̾��ڴ��� �������� �����ž��մϴ�."�� ����Ͻÿ�.
		System.out.println("===4===");
		for (int i = 1; i <= 10; i++) {
			System.out.println("�̾��ڴ��� �������� �����ž��մϴ�.");
		}
		
//		5. �ݺ� ���� i�� �ʱⰪ 10�� ������ ������ 10ȸ�� �ݺ��� �� ���� i�� ����� �� 2�� ������ ���� ��µǵ��� �Ͻÿ�.
		System.out.println("===5===");
		for (int i = 10; i <= 20; i+=2) {
			System.out.println(i);
		}
		
//		6. �ݺ� ���� i�� �ʱⰪ 10�� ������ ������ 10ȸ�� �ݺ��� �� ���� i�� ����� �� Ȧ�� ���� ��µǵ��� �Ͻÿ�.
		System.out.println("===6===");
		for (int i = 10; i <= 20; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
		
//		7. �ݺ� ���� i�� �ʱⰪ 10�� ������ ������ 25ȸ�� �ݺ��� �� ���� i�� ����� �� 4�� ������ ���� ��µǵ��� �Ͻÿ�.
		System.out.println("===7===");
		for(int i = 10; i <= 25; i+=4) {
			System.out.println(i);
		}
		
//		8. �ݺ� ���� i�� 12���� 20ȸ�� �ݺ��� �� "������ ���Ϸ��� �ڹٸ� ���̼ž��մϴ�"�� 4ȸ�� ��µǵ��� �Ͻÿ�.(���̵� 2.5)
		System.out.println("===8===");
		for(int i = 12; i <= 20; i++) {
			if (i % 2 != 0) {
				System.out.println("������ ���Ϸ��� �ڹٸ� ���̼ž��մϴ�");
			}
		}
		
//		9. ������ 4���� ����Ͻÿ�.
		System.out.println("===9===");
		for (int i = 1; i <= 9; i++)  {
			System.out.println("4 * " + i + " = " + 4 * i);
		}
		
//		10. ������ 6�� �� Ȧ�� ���� ����Ͻÿ�.
		System.out.println("===10===");
		for (int i = 1; i <= 9; i++)  {
			if (i % 2 != 0) {
				System.out.println("6 * " + i + " = " + 6 * i);
			}
		}
		
//		11. ������ 7���� ����ϵ� Ȧ������ ����ϵ� �ݺ������� ������� ����.
		System.out.println("===11===");
		for (int i = 1; i <= 9; i++)  {
			if (i % 2 != 0) {
				System.out.println("7 * " + i + " = " + 7 * i);
			}
		}
		
//		12. ������ 6�� �� ¦�� ���� ����Ͻÿ�.
		System.out.println("===12===");
		for (int i = 1; i <= 9; i++)  {
			if (i % 2 == 0) {
				System.out.println("6 * " + i + " = " + 6 * i);
			}
		}
		
//		13. 1���� 10������ ���� ���Ͻÿ�.
		System.out.println("===13===");
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		14. 10���� 1000������ ���� �����ÿ�.
		System.out.println("===14===");
		sum = 0;
		for(int i = 10; i <= 1000; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//		15. 6���� ����� �� 3������ 8�������� ����Ͻÿ�.
		System.out.println("===15===");
		for (int i = 3; i <= 8; i++)  {
			System.out.println("6 * " + i + " = " + 6 * i);
		}
		
//		16. Math.random()�Լ��� ����ؼ� 1���� 45������ ���� �� �� �ϳ��� ������ �ͼ� ���� �� ��ŭ 
//	    "������ ���Ϸ��� �ڹٸ� ���̼ž��մϴ�"�� ����Ͻÿ�. (���� ����, �ߺ� ���)
		System.out.println("===16===");
		int num = (int)(Math.random() * 45) + 1;
		System.out.println(num);
		for(int i = 1; i <= num; i++) {
			System.out.println("������ ���Ϸ��� �ڹٸ� ���̼ž��մϴ�");
		}
		
//		17. 1���� 45������ ���� �� �� ¦���ΰ͸� ���ϵ��� 3���� ����� �ݺ��� 10ȸ �Ѵ�.
		System.out.println("===17===");
		for(int i = 1; i <= 10; i++) {
			num = (int)(Math.random() * 45) + 1;
			System.out.println(num);
			if (num % 2 == 0 ) {
				System.out.println("3 * " + num + " = " + 3 * num);
			}
		}
		
//		18. 1���� 45�� ������ 6���� ������ ���ÿ� (���� ����, �ߺ� ���)
		System.out.println("===18===");
		for (int i = 1; i <= 6; i++) {
			num = (int)(Math.random() * 45) + 1;
			System.out.println(num);
		}
		
//		19. 3���� ����Ҷ� 2���� 5������ �� ����Ͻÿ�. ��, �ݺ� ������ ������� ���ÿ�.
		System.out.println("===19===");
		for(int gop = 2; gop <= 5; gop++) {
			System.out.println("3 * " + gop + " = " + 3 * gop);
		}
		
//		20. ���� x�� ���� z�� ���� �� �ݺ����� i�� x�� ������ �ִ� ������ z�� ������ �ִ� ������ ���� g��ŭ�� �����Ͽ� �ݺ��Ͽ�
//	     "�츮 �����Ͽ� ����� ���սô�"�� ����Ͻÿ�.
		System.out.println("===20===");
		int x = 3;
		int z = 30;
		int g = 5;
		for (int i = x; i <= z; i+=g) {
			System.out.println("�츮 �����Ͽ� ����� ���սô�");
		}
		
//		21. i�� 1���� 15���� 1�� �����Ͽ��� �ϸ� y�� 1000 ���� 10�� ���� �Ҷ��� �ݺ��� �̷������ �Ѵ�.
//	    �� �� "�ڹٴ� ���� ���"�̶�� ������ ��µǵ��� �Ͻÿ�.
		System.out.println("===21===");
		for (int i = 1; i <= 15; i++) {
			for (y = 1000; y >= 0; y-=10) {
				System.out.println("�ڹٴ� ���� ���");
			}
		}
		
//		22. i�� 1����  1�� ������ ���� 15�̰ų�  y�� 1000 ���� 20�� ������ ���� 0�϶� ���� �ݺ��� �̷������ �Ѵ�.
		System.out.println("===22===");
		for (int i = 1; i <= 15; i++) {
			for (y = 1000; y >= 0; y-=20) {
				System.out.println("�ڹٴ� ���� ���");
			}
		}
		
//		23. 3�ܺ��� 8�ܱ��� ���
		System.out.println("===23===");
		for(int dan = 3 ;  dan <= 8; dan++){
			System.out.println(dan + "��");
			for(int gop = 1; gop <= 9; gop++){
				System.out.println( dan + " * " + gop + "= " + dan * gop ); 
			}
		}

//		24. 3�ܺ��� 7�ܱ��� ����� �ϴµ� 4������ 8�������� ����Ͻÿ�.
		System.out.println("===24===");
		for(int dan = 3 ;  dan <= 7; dan++){
			System.out.println(dan + "��");
			for(int gop = 4; gop <= 8; gop++){
				System.out.println( dan + " * " + gop + "= " + dan * gop ); 
			}
		}
		
//		25. 
//		6�� ����
//		6 * 4= 24
//		6 * 5= 30
//		6 * 6= 36
//		6�� ��
//		7�� ����
//		7 * 4= 28
//		7 * 5= 35
//		7 * 6= 42
//		7�� ��
		System.out.println("===25===");
		for(int dan = 6 ;  dan <= 7; dan++){
			System.out.println(dan + "�� ����");
			for(int gop = 4; gop <= 6; gop++){
				System.out.println( dan + " * " + gop + "= " + dan * gop ); 
			}
			System.out.println(dan + "�� ��");
		}
		
//		26. 
//		6�� ����
//		6 * 4= 24         6 * 5= 30         6 * 6= 36
//		6�� ��
//		7�� ����
//		7 * 4= 28         7 * 5= 35         7 * 6= 42
//		7�� ��
		System.out.println("===26===");
		for(int dan = 6 ;  dan <= 7; dan++){
			System.out.println(dan + "�� ����");
			for(int gop = 4; gop <= 6; gop++){
				System.out.print( dan + " * " + gop + "= " + dan * gop + "\t" ); 
			}
			System.out.println("\n" + dan + "�� ��");
		}
		
//		27. ������ ���� ������ ������ dan1�� dan2�� �ְ� ������ ���� ������ ������  gom1�� gom2�� �ִ� 
//        6         7                                                   4        6
//		�� ������ �°� ��µ� �� �ְ� ���α׷��� �Ͻÿ�.
		System.out.println("===27===");
		int dan2 = 6;
		for(int dan1 = 4 ;  dan1 <= dan2; dan1++){
			int gop2 = 7;
			for(int gop1 = 6; gop1 <= gop2; gop1++){
				System.out.println( dan1 + " * " + gop1 + "= " + dan1 * gop1 ); 
			}
		}
		
//		28. html �� table �±� ���
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
		
//		30. 1���� 45������ �� �� 6���� �����Ͽ� ����ϴ� �� 6���� ���� 5�� ����Ͻÿ�.
		System.out.println("===30===");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6; j++) {
				num = (int)(Math.random() * 45) + 1;
				System.out.println(num);
			}
			System.out.println("-" + i + "�� -");
		}
		
		
		
		
	}

}
