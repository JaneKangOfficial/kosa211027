package fileWriteRead;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite1 {

	public static void main(String[] args) throws IOException {

		// ���ڿ��� ����
		FileWriter f = new FileWriter("out1.txt");
		f.write("1 ��°�Դϴ�.\n");
		f.write("2 ��°�Դϴ�.\n");
		f.write("3 ��°�Դϴ�.\n");
		
		for(int i = 1; i <= 10; i++) {
			f.write(i + "��°�Դϴ�.\n");
		}
		f.close();
	}

}