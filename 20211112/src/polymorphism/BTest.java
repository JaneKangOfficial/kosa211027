package polymorphism;

public class BTest {

	public static void main(String[] args) {

		// 오버라이드 안하면 다형성을 할 필요가 없다.
//		B b = new B();
//		A a = b;
//		a.method0();
		
		A a1 = new A();
		a1.method0();
	}

}
