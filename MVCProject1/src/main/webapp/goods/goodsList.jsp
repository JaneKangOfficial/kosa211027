<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList.jsp</title>
</head>
<body>
제품 리스트 페이지입니다. <br />
<table border=1 width="600px">
	<tr>
		<td>그림</td>
		<td>이름</td>
		<td>가격</td>
	</tr>
	<C:forEach items="${list }" var="dto">
	<tr>
		<td>
			<%-- for == 반복 / Tokens == split --%>
			<%-- 범위 지정 : begin 0부터 end 0까지 --%>
			<C:forTokens items="${dto.goodsImages}" delims="`" var="img" begin="0" end="0">
				<a href="goodsInfo.gd?num=${dto.goodsNum}">
					<img src="goods/upload/${img}" height="30px" />
				</a>
			</C:forTokens>
		</td>
		<td><a href="goodsInfo.gd?num=${dto.goodsNum}">${dto.goodsName}</a></td>
		<td>${dto.goodsPrice}</td>
	</tr>
	</C:forEach>
</table>

<a href="goodsEnter.gd">제품등록</a>
</body>
</html>

<%-- 위 코드<C:forTokens>와 같음
<hr />
<%@ page import="java.util.*, model.DTO.*" %>
<%
	List<GoodsDTO> list = (List<GoodsDTO>)request.getAttribute("list");
	for(GoodsDTO dto : list) {
		out.print(dto.getGoodsImages() + "<br />");
		
		String[] images = dto.getGoodsImages().split("`");
		int i = 0;
		for(String img : images) {
			out.print(img + "<br />");			
			i++;
			if(i <= 1) break;
		}
		out.print("<br />");			
	}
%>
 --%>