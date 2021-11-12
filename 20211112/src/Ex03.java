
public class Ex03 extends Ex02{	// 자식클래스

	String subject;
	
	public Ex03(int radius, double pi, String subject) {
		super(radius, pi);
		this.subject = subject;
	}
	
	@Override
	public double area() {	// 오버라이딩 : 재정의
		return radius * radius * Math.PI;
	}
	
	public double area(double p) {	// 오버로딩 : 이름은 같지만 타입,개수,순서가 다르다.
		return radius * radius * p;
	}
	
	public double area1() {
		return super.area();	// 부모클래스가 가진 area()
	}

	
}
