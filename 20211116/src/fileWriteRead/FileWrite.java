package fileWriteRead;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

	public static void main(String[] args) throws IOException {
		/*
		 *  ���̽� ���� �����
		 * f = open("���ϸ�","w")
		 * f.write("1")
		 * 
		 */

		// byte�� ����
		FileOutputStream output = new FileOutputStream("out.txt");
		output.write("1��°�Դϴ�.\n".getBytes());
		output.write("2��°�Դϴ�.\n".getBytes());
		
		for(int i = 1; i <= 10; i++) {
			String data = i + "��°�Դϴ�.\n";
			output.write(data.getBytes());
		}
		output.close();
	}

}
