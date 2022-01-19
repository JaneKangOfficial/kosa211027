package springBootTest2.domain;

import lombok.Data;

@Data
public class LibraryDTO {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String memId;
	String ipAddr;
	String libPw;
	String originalFileName;
	String storeFileName;
	String fileSize;
}
