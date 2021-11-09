
public class Ex13 {

	public static void main(String[] args) {

		// 3행 4열인 2차원 배열에 1 ~ 100까지 사용하는 Math.random()을 이용하여 값을 입력한 후 합계를 출력하시오.
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
		
		// for each문을 사용해서는 값을 저장할 수 없어 for문이나 while문 사용
		for(int[] row : l) {
			for(int col : row) {
				sum += col;
			}
		}
		System.out.println(sum);
		System.out.println("=================");
		
		int[] score = {60,89,56,73,66,90,95};
		// 합계와 평균을 for each문을 사용해서 구하시오.
		sum = 0;
		for(int k : score) {
			sum += k;
		}
		System.out.println("합계는 " + sum);
		System.out.println("평균은 " + sum/score.length);
		
		
	}

}
