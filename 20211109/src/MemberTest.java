
public class MemberTest {

	public static void main(String[] args) {

		Member m1 = new Member();
		Member m2 = new Member(10);
		Member m3 = new Member("홍길동");
		Member m4 = new Member(10, 17.5, "이순신");
		Member m5 = new Member(175.5, 20, "박준현");
		
		m1.setName("강감찬");
		String name = m1.getName();
		System.out.println(name);
		
		m2.setHeight(177.7);
		double height = m2.getHeight();
		System.out.println(height);
		
		m3.setAge(50);
		m3.setHeight(176.5);
		int age = m3.getAge();
		height = m3.getHeight();
		System.out.println(age);
		System.out.println(height);
		
	}

}
