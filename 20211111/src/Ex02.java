
public class Ex02 {
	
	// final 변수와 상수 이름은 모두 대문자
//	final int FIRST = 10;	// 초기값 : 선언시 or 생성자를 통해
	final int FIRST;	// 초기값 : 선언시 or 생성자를 통해
	final int SECOND;	// final 키워드 사용시 setter를 사용해서 값을 변경할 수가 없다.
	final String GOODS_PRICE;
	String name;
	
	public Ex02(int FIRST, int SECOND, String GOODS_PRICE) {
		this.FIRST = FIRST;
		this.SECOND = SECOND;
		this.GOODS_PRICE = GOODS_PRICE;
	}
	
	/* final은 setter를 사용해서 값을 변경할 수가 없다.
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
