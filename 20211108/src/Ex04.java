
public class Ex04 {

	public static void main(String[] args) {
		// �迭�� ũ�� (�迭��.length) / �迭�� ���� length ���
		int i[] = new int[] {1,2,3,4,5};
		//                   0 1 2 3 4 
		System.out.println(i.length); // 5
		
		// �迭�� �ִ� ���� �հ踦 ���Ͻÿ�.
		int sum = 0;
		for(int j = 0; j < i.length; j++) {
			sum += i[j];
		}
		System.out.println(sum);
		
		// ũ�Ⱑ 10�� �迭�� ����� Math.random()�� 1~100 �̿��Ͽ� �迭�� ������ ���� �����Ͻÿ�. for�� ���
		int j[] = new int[10];
		for(int k = 1; k < j.length; k++) {
			j[k] = (int)(Math.random() * 100) + 1;
		} // k�� 0���� 9���� ������ ���� ����
		for(int k = 0; k < j.length; k++) {
			System.out.println(j[k]);
			sum += j[k];
		}
		System.out.println(sum);
		
		/*
			int i[]; // �迭 ���� / �ʱⰪ null		1.
			i = new int[3];						2.
			
			1.								2.
				stack							heap
			�ּ�		����	 	��				�ּ�			��
			1000	i		null			10000		0
											10004		0
											10008		0
			
			null�� ���� ���ų� �������� �ʴ´ٴ� ���� �ƴ϶� ��� ������ �𸥴�.
			���� �����ϴµ� ��� ������ �𸣰ڴ�.
		*/
	
	
	}
}
