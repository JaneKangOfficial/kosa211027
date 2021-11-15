package interface_instanceof;

public class Taxi implements Vehicle {

	@Override
	public void run() {
		System.out.println("Taxi가 달립니다.");
	}

}
