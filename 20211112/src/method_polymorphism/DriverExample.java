package method_polymorphism;

public class DriverExample {

	public static void main(String[] args) {

		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
//		Vehicle vehicle = new Vehicle();	// �߻� Ŭ�������� ��ü ������ ���� ���Ѵ�.
		driver.drive(bus);
		driver.drive(taxi);
	}

}
