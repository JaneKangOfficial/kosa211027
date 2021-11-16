package collectionFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LinkedListEx {

	public static void main(String[] args) {
		
		// 리스트를 만드는 3가지 방법
		List<String> list1 = new ArrayList<String>(); // 3 가장 느리다.
		List<String> list2 = new LinkedList<String>(); // 1 가장 빠르다.
		List<String> list3 = new Vector<String>(); // 2
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " + (endTime - startTime) + "ns"); // 걸린 시간 : 4918300ns
		
		System.out.println("---------------------");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " + (endTime - startTime) + "ns"); // 걸린 시간 : 1411000ns
		
		System.out.println("---------------------");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list3.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("걸린 시간 : " + (endTime - startTime) + "ns"); // 걸린 시간 : 4488800ns
		
		System.out.println("---------------------");
		
	}

}
