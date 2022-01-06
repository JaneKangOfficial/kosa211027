package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.BoardDTO;

public class BoardDAO extends DataBaseInfo{

	public void boardInsert(BoardDTO dto) {
		con = getConnection();
		String sql = "insert into board(board_num, board_writer, board_subject, board_content, writer_ip)" 
					+ " values((select nvl(max(board_num),0) + 1 from board),?,?,?,?)"; // 행바꿈하면 공백문자를 넣어야 오류 발생하지 않음
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setString(4, dto.getWriterIp());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();} catch(Exception e) {e.printStackTrace();}
			if(con != null) try{con.close();} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	// 리스트 출력
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		con = getConnection();
		String sql = "select board_num, board_writer, board_subject, board_content, writer_ip, visit_count from board order by board_num desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 각 목록(dto) 리스트 전체 결과값(rs)을 가져옴 / rs값은 그대로 사용할 수가 없어서 list에 담아서 사용
			while(rs.next()) { // rs.next()할 때마다 커서가 한 행씩 이동한다. EOF를 만나면 더 이상 반복하지 않는다.
				BoardDTO dto = new BoardDTO();
				dto.setBoardContent(rs.getString("board_content"));
				dto.setBoardNum(rs.getInt("board_num"));
				dto.setBoardSubject(rs.getString("board_subject"));
				dto.setBoardWriter(rs.getString("board_writer"));
				dto.setVisitCount(rs.getInt("visit_count"));
				dto.setWriterIp(rs.getString("writer_ip"));
				list.add(dto); // list에 하나씩 add
			}
			System.out.println("인출된 모든 행 : " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try{rs.close();} catch(Exception e) {}
			if(pstmt != null) try{pstmt.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
		return list;
	}
	
	public BoardDTO selectOne(String num) {
		BoardDTO dto = new BoardDTO();
		con = getConnection();
		String sql =  "select board_num, board_writer, board_subject, board_content, writer_ip, visit_count from board where board_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBoardContent(rs.getString("board_content"));
				dto.setBoardNum(rs.getInt("board_num"));
				dto.setBoardSubject(rs.getString("board_subject"));
				dto.setBoardWriter(rs.getString("board_writer"));
				dto.setVisitCount(rs.getInt("visit_count"));
				dto.setWriterIp(rs.getString("writer_ip"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try{rs.close();} catch(Exception e) {}
			if(pstmt != null) try{pstmt.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
		
		return dto;
	}
	
	public void boardDel(String num) {
		con = getConnection();
		String sql = "delete from board where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
	}
	
	public void boardUpdate(BoardDTO dto) {
		con = getConnection();
		String sql = "update board set board_writer = ?, board_subject = ?, board_content = ? where board_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setInt(4, dto.getBoardNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
	}
	
	public void visitCount(String num) {
		con = getConnection();
		String sql = "update board set visit_count = visit_count + 1 where board_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
	}
	
}
