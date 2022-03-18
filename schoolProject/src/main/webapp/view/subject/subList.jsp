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
function subInsert() {
	var chk_arr = [];
	$("input:checkbox[id=subCk]:checked").each(function(){
		var checkVal = $(this).val();
		chk_arr.push(checkVal);
	});
	
	$.ajax({
		type : "post",
		url : "/professor/subInsert",
		dataType  : "text",
		data : {"subjectNum" : chk_arr},
		success : function(result){
			if(result.trim() > "0") {
				alert("신청되었습니다.");
				location.href="/professor/subInsertList";
			}else {
				alert("신청되지 않았습니다.");
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
<form action="../professor/subIn" method="post">
<table border="1">
총 과목 수 : ${count} <br />
현재 페이지 과목 수 : ${list.size()}
	<tr>
		<td>과목 번호</td>
		<td>과목명</td>
		<td>과목 제목</td>
		<td>과목 내용</td>
		<td>
<!-- 			<input type="button" onclick="javascript:subInsert()" value="수강 신청" /> -->
			<input type="submit" value="수강 신청" />
		</td>
	</tr>
	
	<c:forEach items="${list}" var="subjectCommand">
	<tr align="center">
		<td><a href="subInfo/${subjectCommand.subjectNum}">${subjectCommand.subjectNum}</a></td>
		<td>${subjectCommand.subjectName}</td>
		<td>${subjectCommand.subjectTitle}</td>
		<td>${subjectCommand.subjectContent}</td>
		<td align="center">
<%-- 			<input type="checkbox" id="subCk" value="${subjectCommand.subjectNum}"/> --%>
			<input type="checkbox" name="subIn" value="${subjectCommand.subjectNum}"/>
		</td>
	</tr>
	</c:forEach>
	
	<tr>
		<th colspan="5">
			<c:if test="${page <= 1}">
				[이전]
			</c:if>
			<c:if test="${page > 1}">
				<a href="subList?page=${page - 1}">[이전]</a>
			</c:if>
			
			<c:forEach begin="${startPage}" end="${endPage}" var="i" step="1">
				[<a href="subList?page=${i}">${i}</a>]
			</c:forEach>
			
			<c:if test="${page < maxPage}">
				<a href="subList?page=${page + 1}">[이후]</a>
			</c:if>
			<c:if test="${page >= maxPage}">
				[이후]
			</c:if>
		</th>
	</tr>
</table>
</form>
<a href="subRegist">과목 등록</a>
</body>
</html>