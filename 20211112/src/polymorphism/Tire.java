package polymorphism;

public class Tire {
	// �ʵ�
	public int maxRotation;	// �ִ� ȸ���� : int �ʱⰪ 0
	public int accumulatedRotation;	// ���� ȸ���� : int �ʱⰪ 0
	public String location;	// Ÿ�̾� ��ġ
	
	// ������
	public Tire(String location, int maxRotation) { //  accumulatedRotation : ����(�ٲ�� ��)�̶� �ʱⰪ�� �ʿ����.
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {	// Ÿ�̾ �������� �޼ҵ�
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire ���� : " + (maxRotation - accumulatedRotation) + "ȸ");
			return true;
		}else {
			System.out.println("*** " + location + " Tire ��ũ ***");
			return false;
		}
	}
	
}
