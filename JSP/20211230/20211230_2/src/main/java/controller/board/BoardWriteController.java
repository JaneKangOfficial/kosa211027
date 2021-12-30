package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.DTO.BoardDTO;

public class BoardWriteController {

	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String writeIp = request.getRemoteAddr();
		// controller 에 값 받아오기
		
		// dto 에 저장
		BoardDTO dto = new BoardDTO();
		dto.setBoardWriter(boardWriter);
		dto.setBoardSubject(boardSubject);
		dto.setBoardContent(boardContent);
		dto.setWriterIp(writeIp);
		
		// dto값을 dao에 전달
		
	}
}
