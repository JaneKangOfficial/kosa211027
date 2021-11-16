package fileWriteRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) throws IOException {

		// 문자열 단위로 읽어옴
		FileReader fr = new FileReader("out.txt");
		BufferedReader br = new BufferedReader(fr);
//		BufferedReader br = new BufferedReader(new FileReader("out.txt"));
		
		while(true) {
			String line = br.readLine();	// 라인별로 읽어옴
			if (line == null) break;
			System.out.println(line);
		}
		br.close();
	}

}
