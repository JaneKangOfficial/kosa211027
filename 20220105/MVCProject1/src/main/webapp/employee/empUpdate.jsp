<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empUpdate.jsp</title>
</head>
<body>
직원 수정 페이지입니다. <br />
<form action="employeeUpdate.emp" method="get" name="frm" id="frm" >
	직원 번호 : <input type="text" name="empNum" value="${dto.empNum}" required="required" readonly="readonly"/><br /> 
	직원 이름 : <input type="text" name="empName" value="${dto.empName}" required="required" /><br /> 
	직원 아이디 : <input type="text" name="empId" value="${dto.empId}" required="required" /><br /> 
	비밀번호 : <input type="password" name="empPw" id="empPw" required="required" /><br /> 
	비밀번호 확인 : <input type="password" name="empPwCon" id="empPwCon" required="required" /><br /> 
	입사일 : <input type="date" name="empHireDate" value="<fmt:formatDate value='${dto.empHireDate}' pattern='yyyy-MM-dd'/>" required="required" /><br />
	직원 이메일 : <input type="email" name="empEmail" value="${dto.empEmail}" /><br /> 
	직원 급여 : <input type="number" min="100" value="100" name="empSalary" value="${dto.empSalary}" /><br /> 
	직원 연락처 : <input type="tel" name="empPhone" value="${dto.empPhone}" placeholder="031-1234-1234" /><br /> 
	<input type="submit" value="수정완료" />
</form>
</body>
</html>