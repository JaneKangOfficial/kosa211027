package interface_extends;

// 클래스에서 interface를 구현해야 하므로 implements
public class ClassA implements InterfaceA, InterfaceB {

	@Override
	public void methodB() {
		
	}

	@Override
	public void methodA() {
		
	}

}

/*
 * 같은 것끼리의 상속은 extends
 * 클래스와 클래스간의 상속은 extends, 단일상속
 * interface와 interface간의 상속은 extends, 다중상속
 * 
 * 다른 것끼리의 상속은 implements
 * 클래스에서 interface 상속은 implements이다, 다중상속
 * 
 */
