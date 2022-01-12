package spring.dependencyTest5;

import java.util.Date;

public class NumberTest {
	// 모든 멤버는 privete이므로 setter로 값을 저장  num.setI(10);
	// public이면 setter 없이도 저장이 가능하다. i = 10;
	private int i;
	private int j;
	// int, Test1(사용자가 정의) 모두 자료형
	Test1 tt; // 객체 주입을 받음으로써 Test1 tt = new Test1(); 
	Date date;
	
	public NumberTest() {}
	
	public NumberTest(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public NumberTest(int i, int j, Test1 tt) {
		this.i = i;
		this.j = j;
		this.tt = tt;
	}
	public void print() {
		System.out.println(tt.getX());
	}
	
	public void datePrint() {
		System.out.println(date.getDate());
	}
	
	public NumberTest (Test1 tt) {
		this.tt = tt;
	}
	public void setTt(Test1 tt) {
		this.tt = tt;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
