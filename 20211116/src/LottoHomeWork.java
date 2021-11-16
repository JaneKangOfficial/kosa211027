import java.util.LinkedList;
import java.util.List;

public class LottoHomeWork {

	public static void main(String[] args) {

		List<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < 6; i++) {
			int ran = (int) ((Math.random() * 45) + 1);
			list.add(ran);
			for (int j = 0; j < i; j++) {
				if (list.get(j) == list.get(i)) {
					i--;
					break;
				}
			}
		}
		list.sort(null);
		System.out.println(list);
	}

}