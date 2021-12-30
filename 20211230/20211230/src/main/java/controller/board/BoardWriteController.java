package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;

// DTO 값 저장
public class BoardWriteController {
	// frontController request 값을 받아오기 위한 메서드
	public void execute(HttpServletRequest request) { // frontController 에 BoardWriteController 생성
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		System.out.println(request.getParameter("boardContent"));	// jsp name
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String writerIp = request.getRemoteAddr();
		// ======== controller 에 받아옴
		
		// BoardDTO : 값을 DTO에 저장
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardSubject(boardSubject);
		dto.setBoardWriter(boardWriter);
		dto.setWriterIp(writerIp);
		
		// DTO 값을 DAO에 전달
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(dto);
	}
}
