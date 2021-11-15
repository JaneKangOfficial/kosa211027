package runtime_exception;

public class ClassNotFoundExceptionExample {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.util.List111");	// 클래스가 없을수도 있으니 미리 try catch문을 사용하면 좋겠습니다.
			System.out.println("클래스가 있습니다.");
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); // 오류 메세지 출력 , 개발 단계에서 오류 확인 // 개발자가 어떠한 오류인지 확인하기 위한 코드
			System.out.println("클래스가 없습니다.");
		}
		System.out.println("프로그램 끝");	// 출력된다면 위에서 끝난거 아님, 위에는 그저 오류코드 출력일 뿐.
	}
}
