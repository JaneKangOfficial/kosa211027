package abstract_class;

public abstract class Phone { // 부모 클래스만 abstract : (추상 메서드를 가진) 추상 클래스 

	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public abstract void turnOn();	// 추상화 메서드 (완성되지 않았기 때문에 내가 마음대로 만들어서 사용할 수 있다.)
	public abstract void turnOff();	// 추상화 메서드 (완성되지 않았기 때문에 내가 마음대로 만들어서 사용할 수 있다.)
	
}
