
public class Ex01 {

	int first;
	int second; 
}

/*
 *			data(Method
 *	Ex01  {
 *	int first;
 *	int second;
 *	...
 *	�޼���
 *	}
 *
 *	Ex01 ex01 = new Ex01();
 *	Ex01 ex02 = new Ex01();
 *	new �����ڴ� heap������ ��ü�� ������Ű�� ������.
 *
 *			stack							heap
 *		ex01	1000				1000	| first | second |
 *		ex02	2000				2000	| first | second |
 *
 *
 *		1000	2000	// Ŭ������ ������ �ٸ� �ּҸ� ���� �ٸ� ��ü
 * 	if (ex01 == ex02) {
 * 		System.out.println("����");
 * 	}else {
 * 		System.out.println("�ٸ���");
 *  }
 * 
 * 
 */
