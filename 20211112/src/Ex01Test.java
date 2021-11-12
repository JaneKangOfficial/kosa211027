
public class Ex01Test {

	public static void main(String[] args) {
		
		int i = 10;
		System.out.println(i);
		
		double d = 10.5;
		System.out.println(d);
		
		int ii[] = new int[3];	// ii : |	|	|	|	=> 객체
								// 		  0   1   2
		ii[0] = 10;	// int i1 = 10;
		ii[1] = 20;
		ii[2] = 30;
		System.out.println(ii[0]);
		System.out.println(ii[1]);
		System.out.println(ii[2]);
		
		Ex01 ex01 = new Ex01();		// ex01 : | radius | pi |	=> 객체
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
		
//		자료형		 변수명 [] = new 자료명
		double 	d001 [] = new double[3];	// double형  |	|	|	|
		int 	i001 [] = new int[3];		// int형		|	|	|	|
		Ex01	ex001[] = new Ex01[3];		// Ex01형	|new Ex01()|	|	|
		//												 	 0		  1   2
		//												|pi|radius|			배열 안에 있는것은 멤버필드 아님
		// 배열과 객체는 다르다. 배열은 index를 가지고 있고 객체는 멤버필드를 가지고 있다.
	
		i001[0] = 10;
		d001[0] = 10.5;
		ex001[0] = new Ex01();
		ex01 	 = new Ex01();
		ex01.pi 	= 3.141592;
		ex001[0].pi = 3.141592;
		
		
		
	}
}

/*
 * 파이썬
 * # index 있다. index 사용
 * l = [1, 2, 3, 4, 5]
 * #    0  1  2  3  4
 * print(l[0])
 * 
 * # index 없다. key (멤버필드명) 사용
 * dic = {"radius":30, "pi":3.141592}
 * print(dic["radius"])
 * print(dic["pi"])
 * 
 * # index 있다.
 * t = (1, 2, 3, 4, 5)
 * #	0  1  2  3  4
 * 
 */
