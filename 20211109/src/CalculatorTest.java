
public class CalculatorTest {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		Calculator cal1 = new Calculator();
		
		cal.add(10, 20);
		System.out.println(cal.result);
		
		cal1.add(20, 30);
		System.out.println(cal1.result);
		
	}

}
