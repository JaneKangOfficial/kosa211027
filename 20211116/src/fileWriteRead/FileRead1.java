package fileWriteRead;

import java.io.FileInputStream;
import java.io.IOException;

public class FileRead1 {

	public static void main(String[] args) throws IOException {

		// byte 단위로 읽어옴
		byte[] b = new byte[1024]; // 1kb씩 읽어온다.
		FileInputStream input = new FileInputStream("out1.txt");
		input.read(b);
		System.out.println(new String(b));
		input.close();

	}

}
