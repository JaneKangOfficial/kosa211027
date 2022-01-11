package main.service;

import main.DAO.MemberDAO;
import main.DTO.MemberDTO;

public class MemberInfoPrinter {
	// 의존객체 (객체 생성이 꼭 되어야 한다. 따라서 생성이 안될수도 있고 null일수도 있는 DTO는 의존객체라고 할 수 없다.)
	MemberDAO memberDao = new MemberDAO();
	MemberPrinter print = new MemberPrinter();
	
	public void execute(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null ) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		print.print(dto);
	}
}
