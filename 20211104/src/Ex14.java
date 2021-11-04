
public class Ex14 {

	public static void main(String[] args) {
		// 파이썬 : num = random.randint(0, 6)
//		int num = (int)(Math.random() * 6); // 0 ~ 0.9999 * 6
//		           (int)5.99999 = 5
		int num = (int)(Math.random() * 6) + 1; // 1 ~ 6
		if (num == 1)  {
			System.out.println("1입니다.");
		}else if (num == 2) {
			System.out.println("2입니다.");
		}else if (num == 3) {
			System.out.println("3입니다.");
		}else if (num == 4) {
			System.out.println("4입니다.");
		}else if (num == 5) {
			System.out.println("5입니다.");
		}else if (num == 6) {
			System.out.println("6입니다.");
		}
	}

}
