
public class Ex14 {
	
	int result;
	int first;
	int second;
	int add; // ���� (��ȣ�� ������ ����) : ����, �Լ� �̸� ���Ƶ� �ȴ�.
	public Ex14(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	// �޼����� 4���� ����
	// 1. �Է� ���� �ְ� �����(��ȯ��)�� �ִ� �޼���
	public int add(int num1, int num2) { // �Լ� (��ȣ�� ������ �Լ�) : ����, �Լ� �̸� ���Ƶ� �ȴ�.
		return num1 + num2;
	}
	
	// �޼��� �����ε�
	public int div(int num1, int num2) {
		return num1/ num2;
	}
		
	// 2. �Է� ���� �ְ� ��� ���� ���� �޼���
	public void sub(double num1, int num2) {
		this.result = (int)num1 - num2;
		System.out.println(this.result);
	}
	
	// �޼��� �����ε� // �Ű������� ������ �ٸ���.
	// ��ȯ���� �ٸ��ٰ� �ٸ� �޼���� �ƴϴ�. �޼��� ����, Ÿ���� �޶�� �ٸ� �޼����̴�.
	public int sub(int num1, double num2) {
		return num1 - (int)num2;
	}
	
	// 3. �Է°��� ���� ������� �ִ� �޼���
	public int mul() {
		return this.first * this.second;
	}
	
	// 4. �Է°��� ���� ������� ���� �Լ�
	public void div() {
		System.out.println(this.first / this.second);
	}
	
	
	
}
