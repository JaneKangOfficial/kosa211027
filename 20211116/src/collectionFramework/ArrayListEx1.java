package collectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {

	public static void main(String[] args) {

		List list = new ArrayList();
//		list.add(1);	// �׻� ���� Ÿ�Ը� �����Ѵ�.
		list.add(new Board("����1", "����1", "�۾���1"));
		list.add(new Board("����2", "����2", "�۾���2"));
		list.add(new Board("����3", "����3", "�۾���3"));
		list.add(new Board("����4", "����4", "�۾���4"));
		for(int i = 0; i < list.size(); i++) {
			Board s = (Board)list.get(i);	// ��������ȯ
			System.out.println(s.getContent());
		}
		
		System.out.println("-------");
		
		list.add(1, new Board("����5", "����5", "�۾���5")); // 1 �ڸ��� �߰��Ѵ�.
		for(int i = 0; i < list.size(); i++) {
			Board s = (Board)list.get(i);	// ��������ȯ
			System.out.println(s.getContent());
		}
		
		System.out.println("-------");
		
		// ���ʸ� Ÿ�� <Board>
		List<Board> list1 = new ArrayList();
		list1.add(new Board("����1", "����1", "�۾���1"));
		list1.add(new Board("����2", "����2", "�۾���2"));
		list1.add(new Board("����3", "����3", "�۾���3"));
		list1.add(new Board("����4", "����4", "�۾���4"));
		for(int i = 0; i <list1.size(); i++)  {
			Board s = list1.get(i);
			System.out.println(s.getContent());
			System.out.println(list1.get(i).getContent());
		}
		
	}

}
