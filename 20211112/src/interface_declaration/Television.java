package interface_declaration;

public class Television implements RemoteControl {

	// �ʵ�
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Television�� �մϴ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("Television�� ���ϴ�.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("���� Television ���� : " + volume);
	}

}
