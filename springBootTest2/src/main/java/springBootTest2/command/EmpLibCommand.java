package springBootTest2.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmpLibCommand {
	Integer libNum;
	String libWriter;
	String libSubject;
	String libContent;
	String ipAddr;
	String libPw;
	MultipartFile[] report;
}
