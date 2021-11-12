package interface_declaration;

// 익명구현객체 (implements 없이 구현)
public class RemoteControlNoNameExample {

	public static void main(String[] args) {

		RemoteControl rc = new RemoteControl() {
			// 필드
			int vol;

			@Override
			public void turnOn() {
				System.out.println("cd를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("cd를 끕니다.");
			}

			@Override
			public void setVolume(int volume) {
				if(volume > RemoteControl.MAX_VOLUME)  {
					vol = RemoteControl.MAX_VOLUME;
				}else if(volume < RemoteControl.MIN_VOLUME) {
					vol = RemoteControl.MIN_VOLUME;
				}else {
					vol = volume;
				}
				System.out.println("현재 cd 볼륨 : " + volume);
			}
		};
		rc.turnOn();
		rc.turnOff();
	}

}
