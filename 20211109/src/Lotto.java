
public class Lotto {

	public static void main(String[] args) {

		int lotto[] = new int[6];
		
		// 번호 생성
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			// 중복 번호 제거
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;	// 다시 생성하기 위해서
					break;
				}
			}
		}
		
		// 번호 출력
		for(int i=0; i<6; i++) {
			System.out.print(lotto[i] + " ");
		}	
		
	}

}
