package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseInfo {
	String jdbcDriver;
	String jdbcUrl;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs; // 목록리스트의 전체 결과를 담아옴
	
	public DataBaseInfo() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver"; // ojdbc8.jar 안에 있는 OracleDriver class를 사용
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(jdbcDriver);	// 사용할 수 있는지, 존재하는지 확인
			conn = DriverManager.getConnection(jdbcUrl,"kosa12","oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
		if(rs != null) try{rs.close();} catch(Exception e) {}
		if(pstmt != null) try{pstmt.close();} catch(Exception e) {}
		if(con != null) try{con.close();} catch(Exception e) {}
	}
}
