
public class Ex03 {

	// private이 아니기 때문에 직접 접근이 가능하다. 때문에 setter/getter 만들 필요가 없다.
	int first;
	int second;
	static int val;
	int val1;
	
	public int add(/* Ex03 this */ ) {	// 멤버 메서드 // this 암시적으로 존재함
		return val + this.first;	// ex031.add()에서 this.first은 ex031의 first이다.	
	}
	
	public static int sub() {	// static 메서드 
//		return val - val1;	// static 메서드내에서는 instance 변수를 사용할 수가 없다.
		return val;
	}
	
	
}
