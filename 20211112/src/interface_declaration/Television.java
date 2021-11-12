package interface_declaration;

public class Television implements RemoteControl {

	// ÇÊµå
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TelevisionÀ» ÄÕ´Ï´Ù.");
	}

	@Override
	public void turnOff() {
		System.out.println("TelevisionÀ» ²ü´Ï´Ù.");
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
		System.out.println("ÇöÀç Television º¼·ý : " + volume);
	}

}
