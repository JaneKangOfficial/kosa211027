
public class Ex09 {

	public static void main(String[] args) {
		// ���̽� : not False = True; not True = False
		System.out.println(!true); // false
		System.out.println(!false); // true
		boolean b = true;
		System.out.println(!b); // false
		System.out.println(!!b); // true
		boolean b1 = false;
		System.out.println(!b1); // true
		System.out.println(!!b1); // false

		// ���׿��� : !, ++, --, -
		// ������ True and True
		boolean b2 = true && true;
		System.out.println(b2); // true
		System.out.println(true && false); // false
		// True or True
		System.out.println(true || true); // true
		System.out.println(false || false); // false
		// �������� : &&(and), ||(or) : && �켱������ �� ����.
		// ��(����)������ : >, <, <=, >=, ==, !=
		int i = 10;
		int j = 20;
		System.out.println(i > j); // false
		System.out.println(i < j); // true
		System.out.println(i >= j); // false
		System.out.println(i <= j); // true
		System.out.println(i == j); // false
		System.out.println(i != j); // true
		
		boolean b3;
		b3 = i > j;
		System.out.println("b3 : " + b3); // false
		
		// ���� : 2200���� �����Դϱ�?
		// 4�⸶�� ����, 100�⸶�� ���, 400�⸶�� ����
		b3 = 2200 % 4 == 0 && 2200 % 100 != 0 || 2200 % 400 == 0;
		System.out.println(b3); // false ���
		
		float f = 10.1f; // 10.123456789 : �Ҽ��� 9��
		double d = 10.1; // 10.123456789123456789
		boolean b4;
		b4 = f == d;
		System.out.println(b4); // false
		b4 = (double)f == d;
		// f = 10.000000000000000000
		// d = 10.100000001111111111
		System.out.println(b4); // false
		b4 = f == (float)d;
		System.out.println(b4); // true
		
		i = 10;
		d = 10.0;
		b4 =  i == d; // 4byte == 8byte => 8byte == 8byte
//											10.0 == 10.0
		System.out.println(b4); // true
		
		int i3 = 65;
		int i4 = 75;
		int i5 = 85;
		boolean b5, b6, b7;
		b5 = i3 > i4; // false
		b6 = i4 < i5; // true
		b7 = b5 && b6; // false
		System.out.println(b5);
		System.out.println(b6);
		System.out.println(b7);
		b7 = i3 > i4 && i4 < i5; //false
		System.out.println(b7);
		
		b7 = b5 || b6; // false || true : true
		System.out.println(b7);
		b7 = i3 > i4 || i4 < i5;
		System.out.println(b7);
		
	}

}
