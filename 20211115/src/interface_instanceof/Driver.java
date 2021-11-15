package interface_instanceof;

public class Driver {
	// instanceof�� Ŭ������ ��ü�� ������ ���� �� ���
	public void drive(Vehicle vehicle) {
		
		// Bus�� ������� vehicle�Դϱ�?
		if (vehicle instanceof Bus ) {	// instanceof : ��ü�� ���� �� ��� 
			// vehicle ��ü�� Bus Ŭ������ ������� ��ü�Դϱ�?
			// instanceof �� ������� boolean �̴�.
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
}
