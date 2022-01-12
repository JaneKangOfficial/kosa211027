package spring.dependencyTest5.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dependencyTest5.DAO.MemberDAO;
import spring.dependencyTest5.DTO.MemberDTO;


public class MemberListPrinter {
	// 의존객체 자동 주입
	@Autowired
	MemberDAO memberDao;

	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		for(MemberDTO dto : lists) {
			// print.print(dto);
		}
	}
}
