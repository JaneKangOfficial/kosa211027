package main.service;

import java.util.Date;

import main.DAO.MemberDAO;
import main.DTO.MemberDTO;
import main.DTO.RegisterRequest;

public class MemberRegisterService {
	// 의존객체(Dependency Object)
	MemberDAO memberDao = new MemberDAO();
	
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
