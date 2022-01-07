<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsForm.jsp</title>
</head>
<body>
<form action="goodsRegist.gd" method="post" name="frm" id="frm" enctype="multipart/form-data" >
제품 등록 페이지입니다. <br />
제품번호 : <input type="text" name="goodsNum" readonly="readonly" value="kosa${goodsNum}" /> : 자동 부여 <br />
제품명 : <input type="text" name="goodsName" /> <br />
제품가격 : <input type="number" name="goodsPrice" min="1000" value="1000"/> <br />
제조일 : <input type="date" name="goodsDate" /> <br />
제품설명 : <textarea rows="6" cols="40" name="goodsContent"></textarea> <br />
수량 : <input type="number" min="1" value="1" name="goodsQty" /> <br />
제조사 : <input type="text" name="goodsCompany" /> <br />
제품이미지 : <input type="file" name="img1" /><br />
  		 <input type="file" name="img2" /><br />
		 <input type="file" name="img3" /><br />
<input type="submit" value="제품등록" /> 
</form>
</body>
</html>