package method_polymorphism;

public abstract class Vehicle { // 추상 클래스

	public abstract void run(); // 내용없는 메서드 / 추상 메서드
	// 부모 클래스에 있는 메서드의 내용을 사용하지 않고 자식 클래스에서 재정의하여 사용하므로 부모 클래스에 있는 메서드
	// 내용이 필요없어서 내용이 없는 메서드를 만들었다. (자식 클래스에서 override를 해서 내용을 바꿔서 사용할 수 있도록 만들어둠.)

}