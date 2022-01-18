package springBootTest2.command;

import lombok.Data;

@Data
public class LibraryCommand {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String memId;
	String ipAddr;
	String libPw;
}
