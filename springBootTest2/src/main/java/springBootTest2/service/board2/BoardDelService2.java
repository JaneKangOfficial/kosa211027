package springBootTest2.service.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.BoardMapper2;

@Component
@Service
public class BoardDelService2 {
	@Autowired
	BoardMapper2 boardMapper;
	
	public void execute(Integer boardNum) {
		boardMapper.boardDel(boardNum);
	}
}
