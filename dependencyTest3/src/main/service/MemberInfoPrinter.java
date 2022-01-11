package main.service;

import main.DAO.MemberDAO;
import main.DTO.MemberDTO;

public class MemberInfoPrinter {
	// 의존객체 주입
	MemberDAO memberDao;
	MemberPrinter print = new MemberPrinter();
	public MemberInfoPrinter(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public void execute(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null ) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		print.print(dto);
	}
}
