
public class Ex03 {

	int first; // ��� �ʵ�
	int second;
	int result;
//							�Ű�����, �Ű�����
	public void setData(int first, int second) {
		this.first = first;
		this.second = second;
//		��� �ʵ�		�Ű�����
	}
	
	public void setFirst(int first) {
		this.first = first;
	} //setter
	
	public void setSecond(int second) {
		this.second = second;
	}
	
	public int getFirst() {
		return this.first;
	} //getter
	
	public int getSecond() {
		return this.second;
	}
	
	public void add() {
		this.result = this.first + this.second;
	}
	
	public void sub() {
		this.result = this.first - this.second;
	}
	
}

