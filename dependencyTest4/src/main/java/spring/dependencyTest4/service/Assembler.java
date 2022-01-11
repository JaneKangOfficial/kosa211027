package spring.dependencyTest4.service;

import spring.dependencyTest4.DAO.CachedMemberDAO;
import spring.dependencyTest4.DAO.MemberDAO;

public class Assembler { // 객체 조립기
	MemberDAO memberDao;
	MemberPrinter printer;
	MemberRegisterService memberRegisterService;
	MemberListPrinter memberListPrinter;
	ChangePasswordService changePasswordService;
	MemberInfoPrinter memberInfoPrinter;
	
	public Assembler() {
		//this.memberDao = new MemberDAO();
		this.memberDao = new CachedMemberDAO();
		this.printer = new MemberPrinter();
		this.memberRegisterService = new MemberRegisterService(memberDao);
		this.memberListPrinter = new MemberListPrinter(memberDao, printer);
		this.memberInfoPrinter = new MemberInfoPrinter(memberDao);
	}
	
	// 생성자에 의존객체 주입을 했기 때문에 setter는 필요가 없다.
	public MemberDAO getMemberDao() {
		return memberDao;
	}
	public MemberPrinter getPrinter() {
		return printer;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public MemberListPrinter getMemberListPrinter() {
		return memberListPrinter;
	}
	public ChangePasswordService getChangePasswordServce() {
		return changePasswordService;
	}
	
	
}
