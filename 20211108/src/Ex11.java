
public class Ex11 {

	public static void main(String[] args) {

		// 4행 5열짜리 배열을 만들어서 1부터 100까지의 Math.random()을 이용하여 값을 저장하시오.
		System.out.println("===== for 문 =====");
		int l[][] = new int[4][5];
		int num = (int)(Math.random() * 100) + 1;
		for (int i = 0; i < l.length; i++) {
			for(int j  = 0; j < l[i].length; j++) {
				l[i][j] = num;
				System.out.println("l[" + i + "][" + j + "] = " + l[i][j]);
			}
		}
		
		System.out.println("===== while 문 =====");
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
