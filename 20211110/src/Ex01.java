// ĸ��ȭ
public class Ex01 {

	// ��� �ʵ�, ��� ����
	int first;
	int second;
	int result;

	// ������
	public Ex01() {} // �⺻ ������ : �ٸ� �����ڰ� ���� ��� byte�ڵ� ���Ͽ� �ڵ����� ����� ������
	//								�ٸ� �����ڰ� �ִ� ��� ����Ʈ �����ڸ� ����� �־�� �Ѵ�.
	
	public Ex01(int first) {
		this.first = first;
		this.second = 20;
	}
	
	public Ex01(int first, int second) { // �̸��� ������ �Ű������� ����, Ÿ��, ������ �ٸ� : ������ �����ε�
		this.first = first;
		this.second = second;
	}
	
	// �޼���
	public void setFirst(int first)  {
		this.first = first;
	}
	
	public int getFirst() {	 // �Ű������� ���� ��� ��� �ʵ� this ���� ����
		return first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public int add() { // �޼��� �����ε�
		return this.first + this.second;
	}
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public void add(int num1) {
		System.out.println(num1 + this.first);
	}
	
	
	
	
}
