
public class Ex11 {

	public static void main(String[] args) {

		// 4�� 5��¥�� �迭�� ���� 1���� 100������ Math.random()�� �̿��Ͽ� ���� �����Ͻÿ�.
		System.out.println("===== for �� =====");
		int l[][] = new int[4][5];
		int num = (int)(Math.random() * 100) + 1;
		for (int i = 0; i < l.length; i++) {
			for(int j  = 0; j < l[i].length; j++) {
				l[i][j] = num;
				System.out.println("l[" + i + "][" + j + "] = " + l[i][j]);
			}
		}
		
		System.out.println("===== while �� =====");
		int i[][] = new int[4][5];
		int row = 0;
		while (row < i.length) {
			int col = 0;
			while(col < i[row].length) {
				i[row][col] = (int)(Math.random() * 100) + 1;
				col++;
			}
			row++;
		}
		
		
		
		
	}

}
