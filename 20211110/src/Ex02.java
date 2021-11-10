
public class Ex02 {

	public static void main(String[] args) {
		int[] i = new int[3];
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		
		int i1 = 10;
//		ÀÚ·á¸í		º¯¼ö		°´Ã¼
		Account ac1 = new Account();
		Account ac2 = new Account();
		Account ac3 = new Account();
		
		Account[] accs = new Account[3];
//		º¯¼ö			°´Ã¼
		accs[0] = new Account("1111", "È«±æµ¿", 100);
		accs[1] = new Account("2222", "È«ÀÌ¸§", 100);
		
		String[] str = new String[3];
		str[0] = "È«±æµ¿";
		str[1] = "È«ÀÌ¸§";
		
		
		
	}
}