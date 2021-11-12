package abstract_class;

public abstract class Phone { // �θ� Ŭ������ abstract : (�߻� �޼��带 ����) �߻� Ŭ���� 

	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public abstract void turnOn();	// �߻�ȭ �޼��� (�ϼ����� �ʾұ� ������ ���� ������� ���� ����� �� �ִ�.)
	public abstract void turnOff();	// �߻�ȭ �޼��� (�ϼ����� �ʾұ� ������ ���� ������� ���� ����� �� �ִ�.)
	
}
