
public class Ex02 extends Ex01 {

	// 생성자
	public Ex02(int first) {
		super(first);
	}
	
	public void method2() {
		
		// 추상메서드가 있는 클래스는 객체 생성을 할 수가 없다.
//		Ex01 ex01 = new Ex01(12);
		
		// 확장해서 사용한다. extends Ex01
	}

	// 추상메서드가 있는 추상클래스를 상속하면 추상메서드는 오버라이딩을 해야 한다.
	@Override
	public void method01() {
		System.out.println("Ex02-method01");
	}
}
