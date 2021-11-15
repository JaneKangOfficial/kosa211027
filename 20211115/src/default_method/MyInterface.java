package default_method;

public interface MyInterface {

	public void method1(); // 무조건 재정의 (오버라이드)
	
	// 오버라이드를 할 수도 있고 안 할 수도 있는 메서드 : 자바 7까지는 abstract 클래스만 사용가능했는데 자바 8부터는 interface default 메서드를 사용해서 가능하다.
	public default void method2() {
		System.out.println("MyInterface-method2 실행");
	}
	
	
}
