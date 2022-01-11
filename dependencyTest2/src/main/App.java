package main;

import java.util.Scanner;

import main.DAO.CachedMemberDAO;
import main.DAO.MemberDAO;
import main.DTO.RegisterRequest;
import main.service.ChangePasswordService;
import main.service.MemberInfoPrinter;
import main.service.MemberListPrinter;
import main.service.MemberPrinter;
import main.service.MemberRegisterService;

// 2. 의존객체 주입
public class App {
	// 의존객체 주입
	//static MemberDAO memberDao = new MemberDAO();
	static MemberDAO memberDao = new CachedMemberDAO();
	static MemberPrinter printer = new MemberPrinter();
	
	/// FrontController
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("명령어를 입력하세요 : ");
			String command = sc.nextLine();
			if(command.startsWith("new ")) {
				String[] arg = command.split(" ");
				if(arg.length != 5) {
					printHelp();
					continue;
				}
				RegisterRequest req = new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if (!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				// 의존객체(Dependency Object) 주입
				MemberRegisterService action = new MemberRegisterService(memberDao);
				action.execute(req);
				
			}else if(command.equals("list")) {
				// 의존객체(Dependency Object) 주입
				MemberListPrinter listPrint = new MemberListPrinter(memberDao, printer);
				listPrint.printAll();
			}else if(command.startsWith("change ")) {
				String[] arg = command.split(" ");
				if(arg.length != 4) { 
					printHelp();
					continue;
				}
				// 의존객체(Dependency Object) 주입
				ChangePasswordService action = new ChangePasswordService(memberDao);
				action.execute(arg[1], arg[2], arg[3]);
			}else if(command.startsWith("info ")) {
				String[] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					continue;
				}
				// 의존객체(Dependency Object) 주입
				MemberInfoPrinter action = new MemberInfoPrinter(memberDao);
				action.execute(arg[1]);
			}else if(command.equals("exit")) {
				System.out.println("프로그램 종료");
				System.exit(0); // 프로그램 종료 명령어
				System.out.println();
			}else {
				printHelp();
			}
		}
	}
	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비밀번호 변경비밀번호");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("프로그램 종료는 exit");
	}
}

/*
	스프링 개념
	1. 의존객체 : 객체 생성시에 필요한 객체가 있는 경우 그 객체를 의존 객체라고 한다. 
			(FrontController안에 있는 Controller / Controller안에 있는 DAO)
			new DAO가 아닌 @Autowired DAO; 이러한 객체 생성을 위해서는 객체조립기가 필요
	   의존객체의 문제점 : 의존객체를 수정하기 위해서는 모든 객체를 수정해야 한다.
	2. 의존객체 주입 : 의존객체가 변경이 되어도 한번 수정으로 모두 적용된다.
	3. 의존객체 조립기 : 의존객체를 한번에 모두 가지고 있는 객체를 생성
	4. 의존객체 자동 주입
	
	자바 ===> 스프링 ===> 스프링부트(자동설정이어서 객체조립기 생략)
		@Autowired
		의존객체 자동 주입		의존객체 자동 주입
		의존객체 조립기
	
	스프링 			vs		 스프링 부트 
	의존객체 조립기가				자동설정이기 때문에 객체조립기 없이
	의존객체 자동 주입을 함			의존객체가 자동 주입 됨
	
	차이점 : 객체조립기의 유무
	
	스프링 : 객체 조립기내에서 객체 생성, 의존객체 자동 주입을 위해 필요한 것이 객체 조립기
	
	객체 조립기 : 객체 선언 MemberDAO dao = new MemberDAO(); 을 없앰
	스프링부트 : 객체조립기 자체를 생략
 */
