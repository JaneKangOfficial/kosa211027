package multi_implement;

// 클래스와 인터페이스간에는 다중상속이 되지만 클래스와 클래스간에는 다중상속이 안된다.
public class SmartTelevision implements RemoteControl, Searchable {

	// 필드
	private int volume;
	
	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	// 정의할것이 없는 경우 (재정의는 무조건 받아야 함) : 비워두면 된다.
//	@Override
//	public void setVolume(int volume) {}
	
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 Television 볼륨 : " + volume);
	}
	
	

	
}
