
public class Ex02 {
	
	// final ������ ��� �̸��� ��� �빮��
//	final int FIRST = 10;	// �ʱⰪ : ����� or �����ڸ� ����
	final int FIRST;	// �ʱⰪ : ����� or �����ڸ� ����
	final int SECOND;	// final Ű���� ���� setter�� ����ؼ� ���� ������ ���� ����.
	final String GOODS_PRICE;
	String name;
	
	public Ex02(int FIRST, int SECOND, String GOODS_PRICE) {
		this.FIRST = FIRST;
		this.SECOND = SECOND;
		this.GOODS_PRICE = GOODS_PRICE;
	}
	
	/* final�� setter�� ����ؼ� ���� ������ ���� ����.
	public void setFirst(int first) {
		this.first = first;
	}
	*/
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFirst() {
		return this.FIRST;
	}
	
	public int getSecond() {
		return this.SECOND;
	}
	
}
