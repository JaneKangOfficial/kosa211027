package interface_instanceof;

public class DriverExample {

	public static void main(String[] args) {

		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		bus.run();
		taxi.run();

		//
		Vehicle vehicle = bus;
		vehicle.run();
		vehicle = taxi;
		vehicle.run();
		
		//
		drive(bus);
		drive(taxi);
		
		Driver driver = new Driver();
		driver.drive(taxi);
		driver.drive(bus);
	}

	public static void drive(Vehicle vehicle) {
		vehicle.run();
	}
	
}
