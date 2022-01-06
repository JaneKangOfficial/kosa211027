package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberPassController {
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		String path = null;
		String memId = authInfo.getUserId();
//		String memId = (String)session.getAttribute("id");
		String memPw = request.getParameter("memPw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectUser(memId);
		
		if(!memPw.equals(dto.getMemPw())) {
			// setAttribute(msg,) : .jsp에서 ${msg} 가 된다.
			request.setAttribute("msg", "비밀번호가 맞지 않습니다."); 
			path = "/myPage/memberPass.jsp";
		}else {
			path = "/myPage/memberPassCon.jsp";
		}
		
		return path;
	}
}
