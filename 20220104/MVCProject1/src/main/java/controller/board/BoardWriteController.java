package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

public class BoardWriteController {
	public void execute(HttpServletRequest request) {
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String writerIp = request.getRemoteAddr();
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardWriter(boardWriter);
		dto.setBoardSubject(boardSubject);
		dto.setBoardContent(boardContent);
		dto.setWriterIp(writerIp);
		
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
		
	}
}
