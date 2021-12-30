package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DAO.BoardDAO;
import model.DTO.BoardDTO;
// DTO 값 저장
public class BoardWriteController { //Controller
	// frontController request 값을 받아오기 위한 메서드
	public void execute(HttpServletRequest request) { // frontController 에 BoardWriteController 생성
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		String boardWriter = request.getParameter("boardWriter"); // jsp name
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String writeIp = request.getRemoteAddr();
		// == controller 에 받아옴
		
		// 값을 boardDTO에 저장
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardContent(boardContent);
		boardDTO.setBoardSubject(boardSubject);
		boardDTO.setBoardWriter(boardWriter);
		boardDTO.setWriterIp(writeIp);
		System.out.println("여기는 BoardWriterController execute() : 내용 : " + boardDTO.getBoardContent());
		
		// DTO 값을 DAO에 전달
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(boardDTO);
	}
}
