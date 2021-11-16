package collectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {

		List list = new ArrayList();
		list.add("������");	// Object
		list.add("�󸶹�");
		list.add("�����");
		list.add("�����");	// list������ ���� �� ���� �ȴ�. (set������ �ȵȴ�.)
		list.set(3, "Ȳ�浿"); // list�� �ִ� �� ����
		
		// ���� ����Ѵ�. ObjectŸ���̱� ������ �� ����ȯ �� ���
		for(int i = 0; i < list.size(); i++) {
			String s = (String)list.get(i);	// ObjectŸ���� String���� ��ȯ�ϰڴ�.
			System.out.println(s);
		}
		
		// Object�� ����� ��� �Ʒ�ó�� ������� �ʴ´�. (����ȯ ���� �ʰ�)
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// ���� ����Ѵ�. Integer�� ��������Ƿ� ����ȯ ���� ����ص� �ȴ�.
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		// ����Ʈ�� �ִ� ���� ����
		list1.remove(0);
		System.out.println(list1.size());

		System.out.println("-------------------");
		System.out.println(list.size());
		for(Object obj : list) {
			String s = (String)obj;
			System.out.println(s);
		}
		// ����Ʈ�� �ִ� ���� ����
		list.remove(2);
		System.out.println(list.size());
		list.remove("�󸶹�");
		System.out.println(list.size());
//		list.removeAll(list); // removeAll ���ٴ� clear ���
		list.clear();
		System.out.println(list.size());
		System.out.println(list.isEmpty()); 	// true �������
		
		list.add("ȫ�浿");
		System.out.println(list.isEmpty()); 	// false ������� ����
		
		// List : add, remove, size, isEmpty, removeAll ��� clear
	
	}
}

/* 
 *	�⺻�ڷ��� (�⺻�ڷ��� ����, ���� API�̴�.)
 *	���ڿ�
 *	�迭 : ũ�Ⱑ �������ִ�. ���� ������ ������. index ���.
 *	����� �ڷ��� : class
 *	Integer(Wrapper) 
 *	�÷���(list, set, map) : ũ�Ⱑ ���������� �ʴ�. add, remove. ���� ������ �����͸� �����Ѵ�. index ���.
 * 
*/