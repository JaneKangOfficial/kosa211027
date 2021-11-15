package interface_extends;

// interface에서 interface를 상속 : interface 는 구현할 수 없기 때문에 inplement가 안되고 extends가 된다.
// 									다중상속이 가능하다.
public interface InterfaceC extends InterfaceA, InterfaceB {
	public void methodC();
}
