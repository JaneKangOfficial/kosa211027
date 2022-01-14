package springBootTest2.service.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.QnaDTO;
import springBootTest2.mapper.QnaMapper;

@Component
@Service
public class QnaDetailService {
	@Autowired
	QnaMapper qnaMapper;
	
	public void execute(Integer qnaNum, Model model) {
		QnaDTO dto = qnaMapper.selectOne(qnaNum);
		System.out.println("AAAAAAAAA" + dto.getQnaRegiDate());
		model.addAttribute("dto", dto);
	}

}
