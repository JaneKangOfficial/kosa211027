
public class Ex03Test {

	public static void main(String[] args) {

		Ex03 ex031 = new Ex03();
		ex031.first = 10;
		ex031.second = 20;
		ex031.val = 30;
		
		Ex03 ex032 = new Ex03();
		System.out.println(ex032.first); 	// 0
		System.out.println(ex032.second); 	// 0
		System.out.println(ex032.val);		// 30
		
		System.out.println(Ex03.val); 		// 30
		
		int result = ex031.add();			// 30 + 10 = 40
		System.out.println(result);
		
		result = ex032.add();				// 30 + 0 = 30
		System.out.println(result);
		
		
		result = Ex03.sub(); // sub 메소드에 static이 있기 때문에 instance명은 사용 불가. 클래스명으로 호출
		// 메서드에 static 키워드가 있는 경우 클래스명을 이용해서 사용하기 위한 메서드이다.
		// static 메서드내에서 this 키워드를 사용할 수 없다. 
		
		
	}

/*
 * 정적(static) 변수는 모든 instance(객체)에서 값을 공유하기 위해서 
 * 클래스내에 존재하도록 만들어진 변수이다.
 * 클래스명.변수
 * 
 * 정적 메서드는 instance(객체)가 아닌 클래스명을 이용해서 메서드를 사용하기 위해 만들어진 메서드이다. 
 * 그래서 this 키워드를 사용하지 못하므로 instance(객체)변수 (멤버변수)를 사용하지 못하므로 static 변수만 사용해야 한다. 
 * 
 * 
 * 
 */
	
	
	
}
