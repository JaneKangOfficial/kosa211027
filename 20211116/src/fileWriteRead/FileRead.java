package fileWriteRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) throws IOException {

		// ���ڿ� ������ �о��
		FileReader fr = new FileReader("out.txt");
		BufferedReader br = new BufferedReader(fr);
//		BufferedReader br = new BufferedReader(new FileReader("out.txt"));
		
		while(true) {
			String line = br.readLine();	// ���κ��� �о��
			if (line == null) break;
			System.out.println(line);
		}
		br.close();
	}

}
