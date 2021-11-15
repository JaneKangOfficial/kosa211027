package default_method_extends;

public class DefaultMethodExtendsExample {

	public static void main(String[] args) {

		ChildInterface1 ci1 = new ChildInterface1() {
			
			@Override
			public void method1() {	// 추상메서드
				System.out.println("ParentInterface-method1-재정의");
			}
			
			@Override
			public void method3() {	// 추상메서드
				System.out.println("ChildInterface1-method3-재정의");
			}
		};
		ci1.method1();	// ParentInterface-method1-재정의
		ci1.method2();	// ParentInterface-method2 // 재정의 안한 default 메서드
		ci1.method3();	// ChildInterface1-method3-재정의
		
		ChildInterface2 ci2 = new ChildInterface2() {
			
			@Override
			public void method1() {
				System.out.println("ParentInterface-method1-재정의");
			}
			
			@Override
			public void method3() {
				System.out.println("ChildInterface2-method3-재정의");
			}
		};
		ci2.method1();	// ParentInterface-method1-재정의
		ci2.method2();	// ChildInterface2-method2
		ci2.method3();	// ChildInterface2-method3-재정의
		
		ChildInterface3 ci3 = new ChildInterface3() {
			
			@Override
			public void method1() {
				System.out.println("ParentInterface-method1-재정의");
			}
			
			@Override
			public void method3() {
				System.out.println("ChildInterface3-method3-재정의");
			}
			
			@Override
			public void method2() {
				System.out.println("ChildInterface3-method2-재정의");
			}
		};
		ci3.method1();	// ParentInterface-method1-재정의
		ci3.method2();	// ChildInterface3-method2-재정의
		ci3.method3();	// ChildInterface3-method3-재정의 // default 메서드를 추상메서드로 만들어서 재정의, 꼭 재정의해야 하는 메서드가 됨
		
	}
}
