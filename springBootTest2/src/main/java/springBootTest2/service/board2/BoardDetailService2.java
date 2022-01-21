package springBootTest2.service.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.BoardDTO2;
import springBootTest2.mapper.BoardMapper2;

@Component
@Service
public class BoardDetailService2 {
	@Autowired 
	BoardMapper2 boardMapper;
	
	public void execute(Integer boardNum, Model model) {
		BoardDTO2 dto = boardMapper.selectOne(boardNum);
		model.addAttribute("dto", dto);
	}
}
