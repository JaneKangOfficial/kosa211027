
public class Ex06 {

	public static void main(String[] args) {

		String location = "서울";
		
		System.out.println("================ if ===================");
		
		if(location.equals("서울")) { // if(location == "서울") // String은 equals() 사용한다.
			System.out.println("서울 버스요금은 1350원입니다.");
		}else if (location.equals("인천")) {
			System.out.println("인천 버스요금은 1400원입니다.");
		}else if (location.equals("성남")) {
			System.out.println("성남 버스요금은 1450원입니다.");
		}
		
		System.out.println("================ switch ===================");
		
		switch(location) {
		case "서울" : 
			System.out.println("서울 버스요금은 1350원입니다."); 
			break;
		case "인천" : 
			System.out.println("인천 버스요금은 1400원입니다."); 
			break;
		case "성남" : 
			System.out.println("성남 버스요금은 1450원입니다."); 
			break;
		}
		
	}

}
