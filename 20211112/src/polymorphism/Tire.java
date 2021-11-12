package polymorphism;

public class Tire {
	// 필드
	public int maxRotation;	// 최대 회전수 : int 초기값 0
	public int accumulatedRotation;	// 누적 회전수 : int 초기값 0
	public String location;	// 타이어 위치
	
	// 생성자
	public Tire(String location, int maxRotation) { //  accumulatedRotation : 누적(바뀌는 수)이라 초기값이 필요없다.
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {	// 타이어가 굴러가는 메소드
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire 수명 : " + (maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
	
}
