package springBootTest2.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO2 {
	Integer boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
	Date boardDate;
	String writerIp;
}
