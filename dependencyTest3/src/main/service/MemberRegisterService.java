package main.service;

import java.util.Date;

import main.DAO.MemberDAO;
import main.DTO.MemberDTO;
import main.DTO.RegisterRequest;

public class MemberRegisterService {
	// 생성자를 통해 의존객체(Dependency Object) 주입
	MemberDAO memberDao;
	public MemberRegisterService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public void execute(RegisterRequest request) {
		MemberDTO dto = memberDao.selectByEmail(request.getEmail()); 
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(request.getEmail());
			dto.setName(request.getName());
			dto.setPassword(request.getPassword());
			dto.setRegisterDate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록 완료되었습니다.");
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}
	
}
