
public class Ex01 {

		// ���� ���� 10���� ����
	public static void main(String[] args) {
		// �л��� ���� 10��, 10�� ���� ����
		
		int score1 = 20;
		int score2 = 30;
		//	...
		int score10 = 30;
		
		// ���� �ϳ��� 10���� ���� �����ϵ��� ������ = �迭
		int [] score = {1,2,3,4,5,6,7,8,9,10};
		// 				0 1 2 3 4 5 6 7 8 9
		// python�� ����Ʈ�� �������� ������ �����͸� ������ ����
		// java������ �迭�� �ϳ��� �ڷ����� �����͸� ������ ����
		System.out.println(score[5]);
		
		double[] d = {10.5, 12.5, 15.5};
		//				0	  1		2
		// �迭�� ����� ���� indexing�� �Ѵ�.
		System.out.println(d[2]);
		
		// �迭�� ��� �����͸� ���
		for (int i = 0; i <= 2; i++) {
			System.out.println(d[i]);
		}

		// score�� �ִ� ���� ��� ���Ͻÿ�.
		int sum = 0;
		for(int i = 0; i <= 9; i++) {
			sum += score[i];
		}
		System.out.println(sum);
		
		
		
	}

}
