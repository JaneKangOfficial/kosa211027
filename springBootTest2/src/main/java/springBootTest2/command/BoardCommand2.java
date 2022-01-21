package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardCommand2 {

	Integer boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date boardDate;
	String writerIp;
}
