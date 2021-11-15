package runtime_exception;

public class MultiExceptionEx {

	public static void main(String[] args) {

		int data1 = 0;
		int data2 = 0;

		try {
			data1 = Integer.parseInt(args[0]);
			data2 = Integer.parseInt(args[1]);
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data1 / data2);
		} catch (ArrayIndexOutOfBoundsException e) { // ������ ū error�� ���� ���� �Ʒ� ���� error�� ������� �ʾƼ� ������ �߻��Ѵ�. ū error�� ������.
			System.out.println("�Է� ���� 2���� �ʿ��մϴ�.");
		} catch (Exception e) { // ��� error�� ó���Ѵ�. (���̽� => } except : { )
			if (data2 == 0) {
				System.out.println(0);
			} else {
				System.out.println(data1 / data2);
			}
		}

	}

}
