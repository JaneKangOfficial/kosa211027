package springBootTest2.service.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.QnaCommand;
import springBootTest2.domain.QnaDTO;
import springBootTest2.mapper.QnaMapper;

@Component
@Service
public class QnaModifyService {
	@Autowired
	QnaMapper qnaMapper;
	
	public void execute(QnaCommand qnaCommand) {
		QnaDTO dto = new QnaDTO();
		dto.setQnaNum(qnaCommand.getQnaNum());
		dto.setQnaSubject(qnaCommand.getQnaSubject());
		dto.setQnaContent(qnaCommand.getQnaContent());
		qnaMapper.qnaUpdate(dto);
	}
}
