
public class Ex03 {

	// private�� �ƴϱ� ������ ���� ������ �����ϴ�. ������ setter/getter ���� �ʿ䰡 ����.
	int first;
	int second;
	static int val;
	int val1;
	
	public int add(/* Ex03 this */ ) {	// ��� �޼��� // this �Ͻ������� ������
		return val + this.first;	// ex031.add()���� this.first�� ex031�� first�̴�.	
	}
	
	public static int sub() {	// static �޼��� 
//		return val - val1;	// static �޼��峻������ instance ������ ����� ���� ����.
		return val;
	}
	
	
}
