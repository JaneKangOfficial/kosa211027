package runtime_exception;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		Cat cat = new Cat();
		changeDog(cat);
	}
	
	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) {
			try {
//				Dog dog = (Dog)animal;
				Cat cat = (Cat)animal;	// ClassCastException
			}catch(ClassCastException e) {
				System.out.println("입력된 객체가 잘못되었습니다.");
			}
		}
	}
}

// public 이 붙으면 안된다.
// class가 적힌 만큼 .class 파일이 만들어진다.
class Animal{}
class Dog extends Animal {}
class Cat extends Animal {}