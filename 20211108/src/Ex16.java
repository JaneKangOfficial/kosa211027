
public class Ex16 {

	public static void main(String[] args) {

		// for문 for each문을 이용해서 출력
		int [] i = {1, 2, 3, 4, 5, 6};
		
		for(int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
		System.out.println();
		
		for(int k : i) {
			System.out.println(k);
		}
		
		System.out.println("===================");
		
		String [] str = {"홍길동", "강감찬", "이순신", "유관순"};
		
		for(int k = 0; k < str.length; k++) {
			System.out.println(str[k]);
		}
		System.out.println();
		
		for(String k : str) {
			System.out.println(k);
		}
		
		System.out.println("===================");
		
		double[] d = {10.5, 20.6, 40.7, 200.8};
		
		for(int j = 0; j < d.length; j++) {
			System.out.println(d[j]);
		}
		System.out.println();
		
		for (double j : d) {
			System.out.println(j);
		}
		
		System.out.println("===================");
		
		WEEK1[] days = WEEK1.values();
		
		for(int i1 = 0; i1 < days.length; i1++) {
			System.out.println(days[i1]);
		}
		
		System.out.println();
		
		for(WEEK1 i1 : days) {
			System.out.println(i1);
		}
		
		System.out.println("===================");
		
		String[][] locations = {{"영등포","노량진","종로"},{"가","나","다"},{"모란","수내","미금"}};
		
		for (int j = 0; j < locations.length; j++) {
			for (int k = 0; k < locations[j].length; k++) {
				System.out.println(locations[j][k]);
			}
		}
		System.out.println();
		
		for (String [] j : locations)  {
			for (String k : j)
				System.out.println(k);
		}
		
		System.out.println("===================");
		
		int [][] vals = {{1,2,3},{4,5},{6,7,8,9}};
		
		for (int j = 0; j < vals.length; j++) {
			for(int k = 0; k < vals[j].length; k++) {
				System.out.println(vals[j][k]);
			}
		}
		System.out.println();
		
		for (int [] j : vals) {
			for( int k : j) {
				System.out.println(k);
			}
		}
		
		System.out.println("===================");
		
		
		
		
		
	}

}
