package fileWriteRead;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite2 {

	public static void main(String[] args) throws IOException {

		// append 하려면 true
		FileWriter fw = new FileWriter("out1.txt", true);
		for(int i = 11; i <= 20; i++) {
			fw.write(i + "번째입니다.\n");
		}
		fw.close();
	}

}
