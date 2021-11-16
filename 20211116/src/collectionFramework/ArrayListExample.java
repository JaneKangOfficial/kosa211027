package collectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// �ڹ� ����Ʈ�� �迭�� ������ ũ�Ⱑ ������ ���� �����ؼ� ����
		String str[] = {"����", "�ڹٰ�", "�ʹ�", "���ƿ�"};
		System.out.println(str.length);	
		str[3] = "�� ���ƿ�";
//		str[4] = "."; // �迭�� ũ��� �����̴�.
		// ����Ʈ�� ũ�Ⱑ �������̴�. �迭�� �Ȱ��� ���� Ÿ�Ը� ������ �� �ִ�.
		List list = new ArrayList();	// ���̽� ����Ʈ�� ����ϴ�.
		list.add("ȫ�浿");
		list.add("��浿");
		list.add("�̱浿");
		list.add(1);	// �ٸ� Ÿ�� : ������ �� ������ �� ���� �ʴ´�. ������ �� ������ Ÿ�Ը��� �з��ؼ� �����;� �ϱ� ����
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(3));
		System.out.println("-------");
		for(int i = 0; i < list.size(); i++ ) { 
			System.out.println(list.get(i));
		}
		System.out.println("-------");
		for(Object obj : list) {
			System.out.println(obj);
		}
		System.out.println("-------");
		
		List<String> list1 = new ArrayList<String>();	// String Ÿ�Ը� �����ϰڴ�.
		list1.add("ȫ�浿1");
		list1.add("��浿1");
		list1.add("�̱浿1");
		for(String s : list1) {
			System.out.println(s);
		}
		System.out.println("-------");
		
		int i = 10;
		Object obj1 = 10;
		System.out.println(obj1);
		String st = "�ڱ浿";
		obj1 = "�ڱ浿";
		System.out.println(obj1);
		double d = 10.5;
		obj1 = 10.5;
		System.out.println(obj1);
		
		// ���� ����Ѵ�.
		obj1 = new Calu();
		Calu calu = (Calu)obj1;	// ��������ȯ
		calu.setFirst(10); 
		System.out.println(calu.getFirst());
		
	}
}
