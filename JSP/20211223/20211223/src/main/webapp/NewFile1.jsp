<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public void test(){
		System.out.println("선언문 : 함수선언은 선언문 안에서만 가능하다.");
	}

/*
	메서드 안에 메서드는 만들 수 없다. 선언문은 주로 위에 만든다.
	html, 스플립트 코드는 전부 _jspService 메서드 안에서 만들어지기 때문에 스플립트 안에서 메서드를 만드는 것은 메서드 안에 메서드를 만드는 것이다.
	따라서 메서드 밖인 스플립트 밖에서 선언문을 통해 메서드를 만든다. 
*/

	public double calculator(double num1, double num2, String operator) {
		double result = 0.0;
		if(operator.equals("+")) result = num1 + num2;
		else if(operator.equals("-")) result = num1 - num2;
		else if(operator.equals("*")) result = num1 * num2;
		else if(operator.equals("/")) result = num1 / num2;
		return result;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 100까지 합 구하기</title>
<script>
	var sum = 0;
	for(var i = 1; i <= 100; i++) {
		sum += i;
	}
	document.write("script : 1 ~ 100까지의 합은 : " + sum + "<br />");
</script>
</head>
<body>

10 + 5 = <%= calculator(10, 5, "+") %> <br />
10 - 5 = <%= calculator(10, 5, "-") %> <br />
10 * 5 = <%= calculator(10, 5, "*") %> <br />
10 / 5 = <%= calculator(10, 5, "/") %> <br />

<%
	int sum = 0;
	for(int i = 1; i <= 100; i++) {
		sum += i;
	}	
%>
<%=	"jsp : 1 ~ 100까지의 합은 : " + sum + "<br />" %>

<%--
	<%@   %> : 지시문 
	<% java 코드 %> : 스프립트릿, 여러번 사용 가능하므로 한줄씩 사용할 수 있다. 이 안에 있는 코드는 html 코드가 아니다. servlet으로 변환시 out.write로 묶이지 않는다. 자바코드로 그대로 사용, 변수선언(지역변수)
	<%=    %> : 표현식 : out.print() , 코드 마지막에 ; 없다.
	<%!     %> : 선언문 : 함수선언 , 함수는 선언문 안에서만 가능, 스프립트릿 안에서 만들어지지 않는다. 변수선언(멤버 필드)
	<%— —%> : jsp 주석
--%>

</body>
</html>