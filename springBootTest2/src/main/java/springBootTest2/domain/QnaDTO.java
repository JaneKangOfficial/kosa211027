package springBootTest2.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QnaDTO {
	Integer qnaNum;
	String qnaSubject;
	String qnaContent;
	Integer visitCount;
	Date qnaRegiDate;
}
