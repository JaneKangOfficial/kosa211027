package spring.dependencyTest5;

import java.util.Date;

public class Test {
	public static void main (String[] args) {
		NumberTest num = new NumberTest();
		// 멤버필드가 public이면 num.i = 10; 
		// 멤버필드가 parivate이기 때문에 num.setI(10); setter를 사용해서 값을 저장
		num.setI(10);
		System.out.print("1 num : ");
		System.out.println(num.getI());
		
		// 저장은 생성자, setter로 가능하지만 값 전달은 무조건 return이 있는 getter로 한다.
		NumberTest num1 = new NumberTest(20,30);
		System.out.print("2 num1 : ");
		System.out.println(num1.getI());
		
		// 객체 주입
		// 객체 초기화 가능
		NumberTest num2 = new NumberTest(new Test1());
		num1.setDate(new Date());
		
		System.out.print("3 num2 : ");
		num2.print();
		
		System.out.print("4 num : ");
		// num.setTt(new Test1());
		// num.print();
		// 객체 주입
		num.setDate(new Date());
		num.datePrint();
	}
}
