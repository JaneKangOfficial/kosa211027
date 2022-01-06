package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.MemberDTO;

public class MemberDAO extends DataBaseInfo{
	final String COLUMNS = "mem_num, mem_name, mem_regi_date, mem_id, mem_pw, mem_phone1, mem_phone2, mem_addr, mem_email, mem_gender, mem_birth";
	
	public void memberInsert(MemberDTO dto) {
		con = getConnection();
		String sql = "insert into member(" + COLUMNS + ") values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemNum());
			pstmt.setString(2, dto.getMemName());
			pstmt.setDate(3, new java.sql.Date(dto.getMemRegiDate().getTime()));
			pstmt.setString(4, dto.getMemId());
			pstmt.setString(5, dto.getMemPw());
			pstmt.setString(6, dto.getMemPhone1());
			pstmt.setString(7, dto.getMemPhone2());
			pstmt.setString(8, dto.getMemAddr());
			pstmt.setString(9, dto.getMemEmail());
			pstmt.setString(10, dto.getMemGender());
			pstmt.setTimestamp(11, dto.getMemBirth());
			int i = pstmt.executeUpdate(); // i : 저장이 됐는지 확인하기 위해 / executeUpdate() : int 정수 반환
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public String numberGenerate() {
		String num = null;
		con = getConnection();
		String sql = "select nvl(max(substr(mem_num,5)),100000) + 1 from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getString(1); // nvl(max(mem_num),100000) 대신에 순서대로 번호 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
		return num;
	}
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		con = getConnection(); // DB 연결
		String sql = "select " + COLUMNS + " from member";
		try {
			pstmt = con.prepareStatement(sql); // sql문
			rs = pstmt.executeQuery(); // query 실행 결과를 rs에 저장
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(new java.util.Date(rs.getDate("mem_regi_date").getTime()));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; 		
	}
	
	public MemberDTO selectOne(String num) {
		MemberDTO dto = new MemberDTO();
		con = getConnection();
		String sql = "select " + COLUMNS + " from member where mem_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery(); // dto는 rs로 받아온다.
			if(rs.next()) {
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(new java.util.Date(rs.getDate("mem_regi_date").getTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
		return dto;
	}
	
	public void memberDelete(String num) {
		con = getConnection();
		String sql = "delete from member where mem_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public void memberUpdate(MemberDTO dto) {
		con = getConnection();
		String sql = "update member set mem_name=?, mem_phone1=?, mem_phone2=?, mem_addr=?, mem_email=?, mem_gender=?, mem_birth=? where mem_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemPhone1());
			pstmt.setString(3, dto.getMemPhone2());
			pstmt.setString(4, dto.getMemAddr());
			pstmt.setString(5, dto.getMemEmail());
			pstmt.setString(6, dto.getMemGender());
			pstmt.setTimestamp(7, dto.getMemBirth());
			pstmt.setString(8, dto.getMemNum());
			// executeQuery() : select
			// executeUpdate() : insert, update, delete
			int i = pstmt.executeUpdate(); 
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public void memberJoin(MemberDTO dto) {
		con = getConnection();
		String sql = "insert into member (" + COLUMNS 
									+ ") values(( select concat('kosa', nvl(max(substr(mem_num,5)),100000) +1) from member " 
										+ "),?,sysdate,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName()); // 물음표 순서대로! 
			pstmt.setString(2, dto.getMemId());
			pstmt.setString(3, dto.getMemPw());
			pstmt.setString(4, dto.getMemPhone1());
			pstmt.setString(5, dto.getMemPhone2());
			pstmt.setString(6, dto.getMemAddr());
			pstmt.setString(7, dto.getMemEmail());
			pstmt.setString(8, dto.getMemGender());
			pstmt.setTimestamp(9, dto.getMemBirth());
			int i = pstmt.executeUpdate(); // sql 실행
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public MemberDTO selectUser(String memId) {
		MemberDTO dto = new MemberDTO();
		con = getConnection();
		String sql = "select " + COLUMNS + " from member where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				// Timestamp 그냥 가져오기, 넣을 때만 변환
				// date 넣을 때는 sql, 가져올 때는 util
				// sql.Date를 util.Date로 형변환
				dto.setMemRegiDate(new java.util.Date(rs.getDate("mem_regi_date").getTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;		
	}
	
	public void memberMyUpdate(MemberDTO dto) {
		con = getConnection();
		String sql = "update member set mem_name=?, mem_phone1=?, mem_phone2=?, mem_addr=?, mem_email=?, mem_gender=?, mem_birth=? where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemPhone1());
			pstmt.setString(3, dto.getMemPhone2());
			pstmt.setString(4, dto.getMemAddr());
			pstmt.setString(5, dto.getMemEmail());
			pstmt.setString(6, dto.getMemGender());
			pstmt.setTimestamp(7, dto.getMemBirth());
			pstmt.setString(8, dto.getMemId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public void memberPassUpdate(String memId, String memPw) {
		con = getConnection();
		String sql = "update member set mem_pw=? where mem_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memPw);
			pstmt.setString(2, memId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}

}
