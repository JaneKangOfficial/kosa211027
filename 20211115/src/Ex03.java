
public interface Ex03 {
	// interface는 상수, 추상메서드를 가지고 있음
	
	// 상수
	static final int FIRST = 0;
	
	// 추상메서드
	public void method01();	// 오버라이딩해서 사용
	
	// 객체생성을 할 수 없는 추상메서드를 가진 interface에서는 생성자가 필요없다.
	// 일반메서드 없다. 오버라이딩해서 사용할 것이기 때문에. // 값을 전달할 멤버필드 필요없다.
	// 메서드가 하는 역할은 외부로부터 멤버필드 값을 전달 받거나 멤버필드에 있는 값을 외부에 전달하기 위해서 사용. setter, getter 없다.
	
	// 자바 버전 8부터 default, static 추가 됨 
	default void method02() {
		System.out.println("default-method");
	}
	
	static void method03() {
		System.out.println("static-method");
	}
	
}
