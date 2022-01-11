package main.service;

import main.DAO.MemberDAO;
import main.DTO.MemberDTO;

public class ChangePasswordService {
	// 의존객체 주입
	MemberDAO memberDao;
	public ChangePasswordService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	public void execute(String email, String oldPw, String newPw) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);
	}
}
