package spring.dependencyTest4;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dependencyTest4.DTO.RegisterRequest;
import spring.dependencyTest4.service.Assembler;
import spring.dependencyTest4.service.ChangePasswordService;
import spring.dependencyTest4.service.MemberInfoPrinter;
import spring.dependencyTest4.service.MemberListPrinter;
import spring.dependencyTest4.service.MemberRegisterService;

// 스프링

// 3. 의존객체 조립기
public class App {
	// 의존객체 조립기 생성
	// static Assembler assembler = new Assembler();
	static GenericXmlApplicationContext ctx; // xml 파일을 객체로 만들어줌
	
	/// FrontController
	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
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
				MemberRegisterService action = ctx.getBean("memberRegisterService", MemberRegisterService.class); // xml id명
				action.execute(req);
				
			}else if(command.equals("list")) {
				// 의존객체(Dependency Object) 주입
				MemberListPrinter listPrint = ctx.getBean("memberListPrinter", MemberListPrinter.class); // xml id명
				listPrint.printAll();
			}else if(command.startsWith("change ")) {
				String[] arg = command.split(" ");
				if(arg.length != 4) { 
					printHelp();
					continue;
				}
				// 의존객체(Dependency Object) 주입
				ChangePasswordService action = ctx.getBean("changePasswordService", ChangePasswordService.class);
				action.execute(arg[1], arg[2], arg[3]);
			}else if(command.startsWith("info ")) {
				String[] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					continue;
				}
				// 의존객체(Dependency Object) 주입
				MemberInfoPrinter action = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
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
