package multi_implement;

// 익명구현(클래스명을 갖고 있지 않음) : 상속된 클래스명이 없이 사용, 클래스에 상속하지 않고 사용
public class RemoteControlNoNameExample {

	public static void main(String[] args) {

		// interface를 이용해서 객체생성시에 재정의하는 것 - 익명구현
		RemoteControl rc = new RemoteControl() {
			int volume;

			@Override
			public void turnOn() {
				System.out.println("TV를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("TV를 끕니다.");
			}

			@Override
			public void setVolume(int volume) {
				if (volume > RemoteControl.MAX_VOLUME) { // 상수는 클래스명.상수명
					this.volume = RemoteControl.MAX_VOLUME;
				} else if (volume < RemoteControl.MIN_VOLUME) {
					this.volume = RemoteControl.MIN_VOLUME;
				} else {
					this.volume = volume;
				}
				System.out.println("현재 TV 볼륨 : " + this.volume);
			}

		};
		rc.turnOn();
		rc.turnOff();
	}
}
