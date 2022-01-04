package model.DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.EmployeeDTO;

public class EmployeeDAO extends DataBaseInfo{
	// final 상수의 변수명은 대문자 
	final String COLUMNS = "emp_num, emp_name, emp_id, emp_pw, emp_hire_date, emp_email, emp_salary, emp_phone";

	public void employeeInsert(EmployeeDTO dto) {
		con = getConnection();
		String sql = "insert into employees("+ COLUMNS + ")"
						+ " values(?,?,?,?,?,?,?,?)"; // dto로부터 받아오는 갯수만큼 ?를 적는다.
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpNum());
			pstmt.setString(2, dto.getEmpName());
			pstmt.setString(3, dto.getEmpId());
			pstmt.setString(4, dto.getEmpPw());
			// DB에 들어갈때는(set) java.sql.Date 사용 / 자바내에서는 java.util.Date 사용
			// java.util.Date를 java.sql.Date로 변환
			pstmt.setDate(5, new Date(dto.getEmpHireDate().getTime())); 
			pstmt.setString(6, dto.getEmpEmail());
			pstmt.setInt(7, dto.getEmpSalary());
			pstmt.setString(8, dto.getEmpPhone());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public List<EmployeeDTO> selectAll() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		con = getConnection();
		String sql = "select " + COLUMNS + " FROM employees order by emp_num desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 받아오는 값이 없으니 실행만 시키면 된다. / rs는 하나의 행, 레코드 하나
			while(rs.next()) {
				// rs에 있는 컬럼 값을 dto의 멤버 필드에 저장
				EmployeeDTO dto = new EmployeeDTO(); // 데이터의 개수만큼 dto를 만들기 위해 while문 안에 만든다.
				// dto.setEmpEmail(rs.getString("컬럼명에 해당하는 컬럼 값"));
				dto.setEmpEmail(rs.getString("emp_email"));
				// sql.Date ==> util.Date
				// dto(util.Date)이고 rs.getDate(sql.Date)이기 때문에 util.Date로 변환
				dto.setEmpHireDate(new java.util.Date(rs.getDate("emp_hire_date").getTime()));
				dto.setEmpId(rs.getString("emp_id"));
				dto.setEmpName(rs.getString("emp_name"));
				dto.setEmpNum(rs.getInt("emp_num"));
				dto.setEmpPhone(rs.getString("emp_phone"));
				dto.setEmpPw(rs.getString("emp_pw"));
				dto.setEmpSalary(rs.getInt("emp_salary"));				
				list.add(dto); // dto는 레코드(행) 하나이다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
		
		return list;
	}
	
	public EmployeeDTO selectOne(String num) {
		EmployeeDTO dto = new EmployeeDTO();
		con = getConnection();
		String sql = "select " + COLUMNS + " from employees where emp_num = ?";
		
		try {
			pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setEmpNum(rs.getInt("emp_num")); // select 컬럼 순서대로 "emp_num" 대신에 숫자를 적어도 된다.
				dto.setEmpName(rs.getString("emp_name"));
				dto.setEmpId(rs.getString(3));
				dto.setEmpPw(rs.getString("emp_pw"));
				dto.setEmpHireDate(new java.util.Date(rs.getDate("emp_hire_date").getTime()));
				dto.setEmpEmail(rs.getString("emp_email"));
				dto.setEmpSalary(rs.getInt("emp_salary"));
				dto.setEmpPhone(rs.getString("emp_phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {close();}
		
		return dto;
	}

	public void empDelete(String num) {
		con = getConnection();
		String sql = "delete from employees where emp_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
	public void empUpdate(EmployeeDTO dto) {
		con = getConnection();
		String sql = "update employees set emp_name=?, emp_id=?, emp_email=?, emp_salary=?, emp_phone=? where emp_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmpName());
			pstmt.setString(2, dto.getEmpId());
			pstmt.setString(3, dto.getEmpEmail());
			pstmt.setInt(4, dto.getEmpSalary());
			pstmt.setString(5, dto.getEmpPhone());
			pstmt.setInt(6, dto.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {close();}
	}
	
}
