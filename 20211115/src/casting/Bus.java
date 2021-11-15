package casting;

public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("Bus가 달립니다.");
	}

	public void checkFar() {
		System.out.println("승차요금을 체크합니다.");
	}
	
}
