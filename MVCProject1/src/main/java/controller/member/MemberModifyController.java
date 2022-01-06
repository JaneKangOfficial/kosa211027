package controller.member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

// MemberWriteController (등록)insert 와 같음
public class MemberModifyController {
	public void execute(HttpServletRequest request) {
		String memNum = request.getParameter("memNum");
		String memName = request.getParameter("memName");
		String memId = request.getParameter("memId");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memAddr = request.getParameter("memAddr");
		String memEmail = request.getParameter("memEmail");
		String memGender = request.getParameter("memGender");
		
		//============================== 문자열을 date로 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date regiDate = null; // util.Date
		String memRegiDate = request.getParameter("memRegiDate");
		try {
			regiDate = sdf.parse(memRegiDate);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String memBirth = request.getParameter("memBirth");
		// System.out.println("memBirth " + memBirth); // datatime-local : 2022-01-04T10:34
		// System.out.println("memRegiDate " + memRegiDate); // date : 2022-01-05
		String[] dateTime = memBirth.split("T");
		// System.out.println("dateTime[0] " + dateTime[0]); // 2022-01-04
		//------------------------------ 문자열을 date로 변경
		
		//------------------------- 문자열을 Date로 변경한 후에 다시 Timestamp로 변경해야 한다.
		Date memBirthDay = null;
		try {
			memBirthDay = sdf.parse(dateTime[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Timestamp birthDay = new Timestamp(memBirthDay.getTime());
		//========================= 문자열을 Date로 변경한 후에 다시 Timestamp로 변경해야 한다.
		
		MemberDTO dto = new MemberDTO();
		dto.setMemAddr(memAddr);
		dto.setMemBirth(birthDay);
		dto.setMemEmail(memEmail);
		dto.setMemGender(memGender);
		dto.setMemId(memId);
		dto.setMemName(memName);
		dto.setMemNum(memNum);
		dto.setMemPhone1(memPhone1);
		dto.setMemPhone2(memPhone2);
		dto.setMemRegiDate(regiDate);
		
		MemberDAO dao = new MemberDAO();
		dao.memberUpdate(dto);
	}
}
