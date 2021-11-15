package casting;

public class VehicleExample {

	public static void main(String[] args) {

		Vehicle vehicle = new Bus(); // 자동형변환, 부모에 있는 것만 사용가능 / promotion
		vehicle.run();
		
		// Bus로 형변환 후 checkFar() 사용 가능
		Bus bus = (Bus)vehicle;	// 강제형변환, 자식객체에 있는 것 사용가능 / casting
		bus.checkFar();
		bus.run();
	
	}

}
