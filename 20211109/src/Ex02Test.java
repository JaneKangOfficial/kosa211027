
public class Ex02Test {

	public static void main(String[] args) {
		int i = 10;
		/*
		 	���̽�
		 	cal = calculator()
		 	cal.first = 10
		 	
		 	cal1 = calculator()
		 	cal1.first = 20
		*/
		Ex02 ex02 = new Ex02(); 
//		�ڷ��� ������
//(ù���� �빮��)(ù���� �ҹ���)
		ex02.addr = "�д�";
		ex02.age = 35;
		ex02.name = "ȫ�浿";
		ex02.gender = false;
		System.out.println(ex02.addr);
		System.out.println(ex02.gender);
		
		Ex02 ex021 = new Ex02();
		ex021.addr = "�д�";
		ex021.age = 28;
		ex021.name = "�̻��";
		System.out.println(ex021.name);
		
		
		
	}

}
