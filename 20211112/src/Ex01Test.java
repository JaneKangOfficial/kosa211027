
public class Ex01Test {

	public static void main(String[] args) {
		
		int i = 10;
		System.out.println(i);
		
		double d = 10.5;
		System.out.println(d);
		
		int ii[] = new int[3];	// ii : |	|	|	|	=> ��ü
								// 		  0   1   2
		ii[0] = 10;	// int i1 = 10;
		ii[1] = 20;
		ii[2] = 30;
		System.out.println(ii[0]);
		System.out.println(ii[1]);
		System.out.println(ii[2]);
		
		Ex01 ex01 = new Ex01();		// ex01 : | radius | pi |	=> ��ü
		ex01.radius = 10;			// areaCircle()
		ex01.pi = 3.141592;
		
		double result = ex01.areaCircle();
		System.out.println(result);
		System.out.println(ex01.radius);		
		System.out.println(ex01.pi);		
		System.out.println(ex01.getRadius());		
		System.out.println(ex01.getPi());		
		
		Ex01 ex011 = new Ex01();	// ex011 : | radius | pi | 
		ex011.radius = 20;
		
//		�ڷ���		 ������ [] = new �ڷ��
		double 	d001 [] = new double[3];	// double��  |	|	|	|
		int 	i001 [] = new int[3];		// int��		|	|	|	|
		Ex01	ex001[] = new Ex01[3];		// Ex01��	|new Ex01()|	|	|
		//												 	 0		  1   2
		//												|pi|radius|			�迭 �ȿ� �ִ°��� ����ʵ� �ƴ�
		// �迭�� ��ü�� �ٸ���. �迭�� index�� ������ �ְ� ��ü�� ����ʵ带 ������ �ִ�.
	
		i001[0] = 10;
		d001[0] = 10.5;
		ex001[0] = new Ex01();
		ex01 	 = new Ex01();
		ex01.pi 	= 3.141592;
		ex001[0].pi = 3.141592;
		
		
		
	}
}

/*
 * ���̽�
 * # index �ִ�. index ���
 * l = [1, 2, 3, 4, 5]
 * #    0  1  2  3  4
 * print(l[0])
 * 
 * # index ����. key (����ʵ��) ���
 * dic = {"radius":30, "pi":3.141592}
 * print(dic["radius"])
 * print(dic["pi"])
 * 
 * # index �ִ�.
 * t = (1, 2, 3, 4, 5)
 * #	0  1  2  3  4
 * 
 */
