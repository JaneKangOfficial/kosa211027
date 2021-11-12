package method_polymorphism;

public class DriverExample {

	public static void main(String[] args) {

		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
//		Vehicle vehicle = new Vehicle();	// 추상 클래스여서 객체 생성을 하지 못한다.
		driver.drive(bus);
		driver.drive(taxi);
	}

}
