<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">



function subDel(subNum){
	/*
	var subNum;
	$("input[id=subjectNum]").each(function(){
		subNum = $(this).val();
	}); 
	*/
	
	$.ajax({
		type: "post",
		dataType: "text",
		url: "subDel",
		data: {"subjectNum" : subNum},
		success : function(result){
			if(result.trim() > '0'){
				alert("삭제되었습니다.");
				location.href="professor/subInsertList"
			}else {
				alert("삭제되지 않았습니다.");
			}
		},
		error : function(){
			console.log(subjectNum);
			alert("error");
			return false;
		}
		
	});
};

</script>
</head>
<body>
<form action="subDeletes" method="post">
<table border="1">
	<tr>
		<td>교수번호</td>
		<td>과목번호</td>
	<!-- 	<td>과목명</td> -->
		<td>상태</td>
		<td><input type="submit" value="삭제"/></td>
	</tr>
	
	<c:forEach items="${lists}" var="dto" varStatus="status">
	<tr align="center">
		<td><a href="subInfo?num=${dto.professorNum}&num2=${dto.subjectNum}" >${dto.professorNum}</a></td>
<%--  		<td><input type="hidden" value="${dto.subjectNum}" name="subject${status.index}" id="subjectNum" />${dto.subjectNum}</td> --%>
 		<td><input type="hidden" value="${dto.subjectNum}" name="subjectNum" id="subjectNum" />${dto.subjectNum}</td>
		<%-- <td>${dto.subjectDTO.subjectName}</td> --%>
		<td>${dto.status}</td>
		<td>
<%-- 			<input type="button" value="삭제" onclick="subDel(subject${status.index})" /> --%>
			<input type="checkbox" name="delete" value="${dto.professorNum}`${dto.subjectNum}"/>  
		</td>
	</tr>
	</c:forEach>
</table> 
</form>
<a href="../subject/subList">과목 정보</a>
</body>
</html>