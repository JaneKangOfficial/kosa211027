
public class Ex13 {

	public static void main(String[] args) {

		// 3�� 4���� 2���� �迭�� 1 ~ 100���� ����ϴ� Math.random()�� �̿��Ͽ� ���� �Է��� �� �հ踦 ����Ͻÿ�.
		int l[][] = new int[3][4];
		int sum = 0;
		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {
				l[i][j] = (int)(Math.random() * 100) + 1;
				System.out.println("l[" + i + "][" + j + "] = " + l[i][j]);
//				sum += l[i][j];
			}
		}
//		System.out.println(sum);
		
		// for each���� ����ؼ��� ���� ������ �� ���� for���̳� while�� ���
		for(int[] row : l) {
			for(int col : row) {
				sum += col;
			}
		}
		System.out.println(sum);
		System.out.println("=================");
		
		int[] score = {60,89,56,73,66,90,95};
		// �հ�� ����� for each���� ����ؼ� ���Ͻÿ�.
		sum = 0;
		for(int k : score) {
			sum += k;
		}
		System.out.println("�հ�� " + sum);
		System.out.println("����� " + sum/score.length);
		
		
	}

}
