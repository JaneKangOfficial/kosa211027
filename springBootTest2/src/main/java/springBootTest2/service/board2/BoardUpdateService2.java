package springBootTest2.service.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.BoardCommand2;
import springBootTest2.domain.BoardDTO2;
import springBootTest2.mapper.BoardMapper2;

@Component
@Service
public class BoardUpdateService2 {
	@Autowired
	BoardMapper2 boardMapper;
	
	public void execute(BoardCommand2 boardCommand) {
		BoardDTO2 dto = new BoardDTO2();
		
		dto.setBoardNum(boardCommand.getBoardNum());
		dto.setBoardWriter(boardCommand.getBoardWriter());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardContent(boardCommand.getBoardContent());
		
		System.out.println("aaaaaaa " + dto.getBoardNum());
		System.out.println("aaaaaaabbbbbbbb " + boardCommand.getBoardNum());
		System.out.println("bbbbbbbbb " + dto.getBoardWriter());
		System.out.println("cccccc " + dto.getBoardSubject());
		System.out.println("eeeeeeee " + dto.getBoardContent());
		
		boardMapper.boardUpdate(dto);
	}
}
