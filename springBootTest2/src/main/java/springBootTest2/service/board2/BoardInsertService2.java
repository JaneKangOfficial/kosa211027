package springBootTest2.service.board2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.BoardCommand2;
import springBootTest2.domain.BoardDTO2;
import springBootTest2.mapper.BoardMapper2;

@Component
@Service
public class BoardInsertService2 {
	@Autowired
	BoardMapper2 boardMapper;
	
	public void execute(BoardCommand2 boardCommand, HttpServletRequest request) {
		String writerIp = request.getRemoteAddr();
		
		BoardDTO2 dto = new BoardDTO2();
		
		dto.setBoardWriter(boardCommand.getBoardWriter());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setWriterIp(writerIp);
		
		boardMapper.boardInsert(dto);
		
	}
}
