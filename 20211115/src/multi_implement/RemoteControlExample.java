package multi_implement;

public class RemoteControlExample {

	public static void main(String[] args) {

		SmartTelevision tv = new SmartTelevision();
		Searchable sc = tv;
		RemoteControl rc = tv;
		
		// �θ� �ִ� �͸� ��� �����ϴ�.
		sc.search("ȫ�浿");
		rc.turnOn();
		rc.turnOff();
		
		// ��� ���� ��� ���� ����� �� �ִ�.
		tv.search("ȫ�浿");
		tv.turnOn();
		tv.turnOff();
		
	}

}
