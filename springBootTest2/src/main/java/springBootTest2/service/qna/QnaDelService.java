package springBootTest2.service.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.QnaMapper;

@Component
@Service
public class QnaDelService {
	@Autowired
	QnaMapper qnaMapper;
	
	public void execute(Integer qnaNum) {
		qnaMapper.qnaDel(qnaNum);
		
	}
}
