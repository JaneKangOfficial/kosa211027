package package01;

public class Member {

	int age;
	double height;
	String name;
	boolean gender;
	
	public Member() {}
	
	public Member(int age, double height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
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
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	// getter
	public int getAge() {
		return age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public String getName() {
		return name;
	}
	
	// boolean의 get은 is / get으로 사용도 가능하지만 일반적으로는 is를 사용한다.
	public boolean isGender() {
		return gender;
	}
	
}
