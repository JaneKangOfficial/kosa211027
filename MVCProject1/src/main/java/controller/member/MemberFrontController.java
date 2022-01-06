package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet implements Servlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberList.mem")) { // 회원 리스트
			MemberListController action = new MemberListController();
			action.execute(request); // dao.selectAll()
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberRegist.mem")) { // 회원 등록 페이지
			MemberNumberController action = new MemberNumberController(); // 자동 회원 번호
			action.execute(request); // dao.numberGenerate()
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberWrite.mem")) { // 회원 정보 저장 후 리스트 페이지로 이동
			MemberWriteController action = new MemberWriteController(); // 회원정보 저장
			action.execute(request); // dao.memberInsert(dto)
			response.sendRedirect("memberList.mem");
		}else if(command.equals("/memberDetail.mem")) { // 회원 정보 상세보기
			MemberDetailController action = new MemberDetailController();
			action.execute(request); // dao.selectOne(memNum)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDelete.mem")) { // 회원 강퇴 후 회원 리스트 페이지로 이동
			MemberDeleteController action = new MemberDeleteController();
			action.execute(request); // dao.memberDelete(num)
			response.sendRedirect("memberList.mem");
			
		}else if(command.equals("/memberModify.mem")) { // 회원정보 수정 양식
			MemberDetailController action = new MemberDetailController();
			action.execute(request); // dao.selectOne(memNum)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberUpdate.mem")) { // 회원정보 수정완료
			MemberModifyController action = new MemberModifyController(); // 수정된 회원 정보 불러오기
			action.execute(request); // dao.memberUpdate(dto)
			response.sendRedirect("memberDetail.mem?num=" + request.getParameter("memNum"));
		
		}else if(command.equals("/memberAgree.mem")) { // 가입 약관 동의
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/agree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberJoin.mem")) { // 가입 양식
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberJoinForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberJoinOk.mem")) { // 가입 완료
			MemberJoinController action = new MemberJoinController();
			action.execute(request); // dao.memberJoin(dto)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/welcome.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/memberDescript.mem")) { // 내 정보 보기
			MemberDescriptController action = new MemberDescriptController(); // 정보 불러오기
			action.execute(request); // dao.selectUser(memId)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/memberDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberInfoModify.mem")) { // 내 정보 수정
			MemberDescriptController action = new MemberDescriptController(); // 정보 불러와서 수정 저장
			action.execute(request); // dao.selectUser(memId)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/memberModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberInfoUpdate.mem")) { // 비밀번호 비교 후 수정 완료
			MemberMyUpdateController action = new MemberMyUpdateController();
			action.execute(request,response); // dao.memberMyUpdate(dto) : 비밀번호 비교 확인 / dao.memberMyUpdate(dto) : 비밀번호 수정
			
		}else if(command.equals("/memberDrop.mem")) { // 정말 탈퇴하시겠습니까? 비밀번호 입력
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/memberDrop.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDropOk.mem")) { // 비밀번호 맞으면 탈퇴, 안 맞으면 back
			MemberDropController action = new MemberDropController();
			// alert 창을 띄우기 위해서는 response가 필요하다.
			action.execute(request, response); // dao.selectUser(memId) : 비밀번호 비교 확인 / dao.memberDelete(dto.getMemNum()) : 비밀번호 일치 탈퇴
		
		}else if(command.equals("/memberPass.mem")) { // 비밀번호 변경 양식
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/memberPass.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberPassword.mem")) { // 현재 비밀번호 확인 / 일치하지 않으면 메세지 띄우기, 일치하면 변경 페이지 이동
			MemberPassController action = new MemberPassController();
			String path = action.execute(request); // dao.selectUser(memId) : 비밀번호 비교 확인
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/memberPassModify.mem")) { // 변경 페이지
			MemberPassModifyController action = new MemberPassModifyController();
			action.execute(request, response); // dao.selectUser(memId) : 비밀번호 비교 확인 / dao.memberPassUpdate(memId, newMemPw) : 비밀번호 수정 저장
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}
