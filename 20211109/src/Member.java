
public class Member {

	int age;
	double height;
	String name;
	
	// 생성자
	public Member() {} // 디폴트 생성자
	
	public Member(int age) { // 메서드 오버로딩 : 매개변수 개수가 다르거나 타입이 서로 다를 때 
		this.age = age;
	}
	
	public Member(String name) {
		this.name = name;
	}
	
	public Member(int age, double height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	public Member(double height, int age, String name) {
		this.height = height;
		this.age = age;
		this.name = name;
	}
	
	// 메서드
	// setter
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// getter
	public int getAge() {
		return this.age;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public String getName() {
		return this.name;
	}
	
}
