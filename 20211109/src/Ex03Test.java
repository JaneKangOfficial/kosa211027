
public class Ex03Test {

	public static void main(String[] args) {
		/*
		 *  ���̽�
		 *  ex03 = Ex03() # ���̽㿡�� �����ϴ� ���
		 */
		Ex03 ex03 = new Ex03(); // �ڹٿ��� �����ϴ� ���
		ex03.setData(20, 10);
		// ex03.first = 20; ex03.second = 10;
		ex03.add();
		System.out.println(ex03.result);
		ex03.sub();
		System.out.println(ex03.result);
		
		Ex03 ex003 = new Ex03();
		ex003.setData(200, 100);
		ex003.sub();
		System.out.println(ex003.result);
		
/*
	data(Method), static, stack, heap
		
		data
	Ex03 : ����, �Լ� // Ŭ���� : �ؾ Ʋ
	
Ex03 ex03;				1.
ex03 = new Ex03();		2.
Ex03 ex003;
ex003 = new Ex03();
ex003.setData(20,10);

	������ ������ �ִ� Ŭ����								new�� ��� Ʋ
		stack										heap // ��ü // �ؾ
	�ּ�,	 	����, 	��						�ּ� 	 	 	��
	1000 	ex03 	null		1.			100		first|second|result
		 			100
	1010	ex003							110	 	first | second | result
					110
													 20   |   10   | result
ex03.result ==> 100.result
System.out.println(ex003.result) ==> 110.result

��ü���� : 


		 
*/
	}

}
