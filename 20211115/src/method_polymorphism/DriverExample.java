package method_polymorphism;

public class DriverExample {

	public static void main(String[] args) {

		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		bus.run();
		taxi.run();
		
		Vehicle v = bus;
		v.run();
		v = taxi;
		v.run();
	
		// 클래스 사용
		Driver driver = new Driver();
		driver.drive(taxi);
		driver.drive(bus);
	
		// 함수 메서드 사용
		drive(bus);
		drive(taxi);
	}
	
	public static void drive(Vehicle v) {
		v.run();
	}

}
