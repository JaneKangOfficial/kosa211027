
public class Board {

	// 번호, 제목, 글쓴이, 내용, 글쓴이의 ip주소, 방문자수
	// 멤버 필드
	int num;
	String subject;
	String writer;
	String content;
	String ip;
	int readCount;
	
	// 생성자
	public Board() {}
	
	public Board(int num, String subject, String writer, 
			String content, String ip, int readCount) {
		this.num = num;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.ip = ip;
		this.readCount = readCount;
	}
	
	// 메서드
	// setter
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	// getter
	public int getNum() {
		return this.num;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public int getReadCount() {
		return this.readCount;
	}
	
	// 클래스 : 멤버필드, 생성자, 메서드의 집합체이다.
	
}
