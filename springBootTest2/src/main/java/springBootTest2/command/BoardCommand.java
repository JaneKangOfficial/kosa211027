package springBootTest2.command;

import lombok.Data;

@Data	// setter, getter
public class BoardCommand {
	Integer boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
}
