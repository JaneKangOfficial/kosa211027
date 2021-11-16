package collectionFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LinkedListEx {

	public static void main(String[] args) {
		
		// ����Ʈ�� ����� 3���� ���
		List<String> list1 = new ArrayList<String>(); // 3 ���� ������.
		List<String> list2 = new LinkedList<String>(); // 1 ���� ������.
		List<String> list3 = new Vector<String>(); // 2
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("�ɸ� �ð� : " + (endTime - startTime) + "ns"); // �ɸ� �ð� : 4918300ns
		
		System.out.println("---------------------");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("�ɸ� �ð� : " + (endTime - startTime) + "ns"); // �ɸ� �ð� : 1411000ns
		
		System.out.println("---------------------");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list3.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("�ɸ� �ð� : " + (endTime - startTime) + "ns"); // �ɸ� �ð� : 4488800ns
		
		System.out.println("---------------------");
		
	}

}
