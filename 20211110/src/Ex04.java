
public class Ex04 {

	static int first;
	static int second;
	// static ������ �����ڸ� �̿��ؼ� �ʱ�ȭ �� �� ����.
	// static ������ �ʱ�ȭ �� ������ static ���� �̿��Ѵ�.
	// ���� ����� ��ü �������� �ʰ� Ŭ���������� �ٷ� ������ ���
	static {
		first = 10;
		second = 20;
	}
	
	int val;

	public Ex04() {}
	
	public Ex04(int val) {
		this.val = val;
	}
	
	public Ex04(int first, int second) {
//		this.first = first; 	// static ���� this ��� ����. => �����ڸ� �̿��ؼ� �ʱ�ȭ ����.
//		this.second = second;	// static ���� �̿��ؼ� �ʱ�ȭ�Ѵ�.
	}
	

}
