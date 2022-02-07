<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>

<script type="text/javascript">
/* jquery 사용 */
	$(function(){
		$("#delete").click(function(){
			//location.href="memDelete?num=[[${memberCommand.memberNum}]]";
			$.ajax({
				type : "post",
				url : "../memDelete",
				data : {"num" : "${memberCommand.memberNum}"},
				dataType : "text",
				success : function(result){
					if(result.trim() == '1') {
						alert("정상 삭제");
						location.href="../memList";
					}else {
						alert("삭제되지 않았습니다.");
						return false;
					}
				},
				error : function() {
					alert("페이지 열리지 않음, ERROR!!!");
					return;
				}
			});
		});
	});

/* 함수 사용 */
	function del() {
		$.ajax({
			type : "post",
			url : "../memDelete",
			data : {"num" : "${memberCommand.memberNum}"},
			dataType : "text",
			success : function(result){
				if(result.trim() == '1') {
					alert("정상 삭제");
					location.href="../memList";
				}else {
					alert("삭제되지 않았습니다.");
					return false;
				}
			},
			error : function() {
				alert("페이지 열리지 않음, ERROR!!!");
				return;
			}
		});
	};
</script>

</head>
<body>
상세정보 <br />
번호 : ${memberCommand.memberNum}<br />
아이디 : ${memberCommand.memberId}<br />
이름 : ${memberCommand.memberName}<br />
주소 : ${memberCommand.memberAddr}<br />
등록일 : <fmt:formatDate value="${memberCommand.memberRegist}" pattern="yyyy-MM-dd"/><br />
성별 : <c:if test="${memberCommand.gender=='F'}">여자</c:if>
	  <c:if test="${memberCommand.gender=='M'}">남자</c:if><br />
전화번호 : ${memberCommand.memberPhone}<br />
생일 : <fmt:formatDate value="${memberCommand.memberBirth}" pattern="yyyy-MM-dd"/><br />
이메일 : ${memberCommand.memberEmail}<br />

<a href="../memList">목록</a> |
<a href="../memModify?num=${memberCommand.memberNum}">수정</a> |
<a href="javascript:del();">삭제</a>
<input type="button" value="jquery삭제" id="delete"/>
<input type="button" value="function삭제" onclick="del();"/>

</body>
</html>