package casting;

public class VehicleExample {

	public static void main(String[] args) {

		Vehicle vehicle = new Bus(); // �ڵ�����ȯ, �θ� �ִ� �͸� ��밡�� / promotion
		vehicle.run();
		
		// Bus�� ����ȯ �� checkFar() ��� ����
		Bus bus = (Bus)vehicle;	// ��������ȯ, �ڽİ�ü�� �ִ� �� ��밡�� / casting
		bus.checkFar();
		bus.run();
	
	}

}
