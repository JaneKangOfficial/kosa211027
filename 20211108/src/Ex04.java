
public class Ex04 {

	public static void main(String[] args) {
		// 배열의 크기 (배열명.length) / 배열일 때만 length 사용
		int i[] = new int[] {1,2,3,4,5};
		//                   0 1 2 3 4 
		System.out.println(i.length); // 5
		
		// 배열에 있는 값의 합계를 구하시오.
		int sum = 0;
		for(int j = 0; j < i.length; j++) {
			sum += i[j];
		}
		System.out.println(sum);
		
		// 크기가 10인 배열을 만들고 Math.random()을 1~100 이용하여 배열에 임의의 값을 저장하시오. for문 사용
		int j[] = new int[10];
		for(int k = 1; k < j.length; k++) {
			j[k] = (int)(Math.random() * 100) + 1;
		} // k가 0부터 9까지 임의의 값을 저장
		for(int k = 0; k < j.length; k++) {
			System.out.println(j[k]);
			sum += j[k];
		}
		System.out.println(sum);
		
		/*
			int i[]; // 배열 선언 / 초기값 null		1.
			i = new int[3];						2.
			
			1.								2.
				stack							heap
			주소		변수	 	값				주소			값
			1000	i		null			10000		0
											10004		0
											10008		0
			
			null은 값이 없거나 존재하지 않는다는 것이 아니라 어떠한 값인지 모른다.
			값은 존재하는데 어떠한 값인지 모르겠다.
		*/
	
	
	}
}
