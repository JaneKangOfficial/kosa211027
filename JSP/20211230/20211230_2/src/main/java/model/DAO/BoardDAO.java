package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.DTO.BoardDTO;

// 오라클 접속하기 위해서 ojdbc8.jar 사용
public class BoardDAO {
	String jdbcDriver;
	String jdbcUrl;
	Connection conn;
	PreparedStatement pstmt;
	
	public BoardDAO() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar(오라클이 자바에 접속할 수 있도록 만들어줌) 불러오는 코드
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	
	public Connection getConnection() { // 데이터베이스에 접속 (sqlDeveloper의 접속창과 같다.)
		Connection con = null;
		try {
			Class.forName(jdbcDriver); // OracleDriver 클래스 파일(ojdbc8.jar)이 존재하는지 확인
			con = DriverManager.getConnection(jdbcUrl,"kosa12","oracle"); // 데이터베이스 접속 정보
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void boardInsert(BoardDTO dto) { // db에 넘길 정보를 담은 dto를 받아옴
		conn = getConnection(); // return con 정보를 받아옴
		String sql = "insert into board(board_num, board_writer, board_subject, board_content, writer_ip)"
				+ "values(nvl((select max(board_num) from board),0) + 1, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql); // 쿼리문을 pstmt에 저장
			pstmt.setString(1, dto.getBoardWriter()); // DTO가 가진 값을 DB에 저장, ?의 순서대로
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setString(4, dto.getWriterIp());
			int i = pstmt.executeUpdate(); // 실행키(control + enter)와 같다.
			System.out.println(i + "행 이(가) 삽입되었습니다."); // BoardWriteController에 BoardDAO boardinsert() 추가해야 저장된다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
