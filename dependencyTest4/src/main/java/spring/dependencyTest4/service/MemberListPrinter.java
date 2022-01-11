package spring.dependencyTest4.service;

import java.util.Collection;

import spring.dependencyTest4.DAO.MemberDAO;
import spring.dependencyTest4.DTO.MemberDTO;


public class MemberListPrinter {
	// 의존객체 주입
	MemberDAO memberDao;
	MemberPrinter print;
	public MemberListPrinter(MemberDAO memberDao, MemberPrinter print) {
		this.memberDao = memberDao;
		this.print = print;
	}
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		for(MemberDTO dto : lists) {
			print.print(dto);
		}
	}
}
