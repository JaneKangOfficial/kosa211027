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
				System.out.println("�Էµ� ��ü�� �߸��Ǿ����ϴ�.");
			}
		}
	}
}

// public �� ������ �ȵȴ�.
// class�� ���� ��ŭ .class ������ ���������.
class Animal{}
class Dog extends Animal {}
class Cat extends Animal {}