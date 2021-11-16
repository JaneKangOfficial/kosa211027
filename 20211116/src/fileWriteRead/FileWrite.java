package fileWriteRead;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

	public static void main(String[] args) throws IOException {
		/*
		 *  파이썬 파일 입출력
		 * f = open("파일명","w")
		 * f.write("1")
		 * 
		 */

		// byte로 저장
		FileOutputStream output = new FileOutputStream("out.txt");
		output.write("1번째입니다.\n".getBytes());
		output.write("2번째입니다.\n".getBytes());
		
		for(int i = 1; i <= 10; i++) {
			String data = i + "번째입니다.\n";
			output.write(data.getBytes());
		}
		output.close();
	}

}
