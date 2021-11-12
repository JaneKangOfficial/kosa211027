
public class DmbCellPhone extends CellPhone{

	// 멤버 필드
	int channel;
	
	// 생성자
	DmbCellPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	// 메소드
	public void turnOnDmb() {
		System.out.println("채널 " + channel + " 입니다.");
	}

	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + " 입니다.");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	
	
	
}
