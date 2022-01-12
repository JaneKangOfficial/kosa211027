package spring.dependencyTest5.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dependencyTest5.DAO.MemberDAO;
import spring.dependencyTest5.DTO.MemberDTO;

public class MemberInfoPrinter {
	// 의존객체 자동 주입
	@Autowired
	MemberDAO memberDao;
		
	public void execute(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null ) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		// print.print(dto);
	}
}
