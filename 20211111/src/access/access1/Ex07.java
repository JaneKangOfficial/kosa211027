package access.access1;

public class Ex07 {

	private int first;
	private int second;
	private int result;
	
	public void add() {
		result = first + second;
	}
	
	public void div() {
		result = first / second;
	}
	
}

/*

public : ��𼭵��� ���, ������ �����ϴ�.

protected : ���� ��Ű���� �ٸ� ��Ű���� �ִ� Ŭ���� ��ӵȴ�.
			�ٸ� ��Ű���� �ִ� Ŭ���������� ����� ����� �� ����.
			
default : ���� ��Ű�������� ��ӵ� �ǰ� ����� ����� �� �ִ�.
			�ٸ� ��Ű���� ���� ��ӵ� �ȵǰ� ��� ��뵵 �ȵȴ�.
			��� �ʵ忡 ���� �����ڸ� ���� ������ �⺻������ �����ȴ�.
	
private : Ŭ���������� ��� ���� (��� X)
			�ٸ� Ŭ�������� ����� ����� �� ����.

*/