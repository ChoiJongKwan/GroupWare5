<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>updateSuccess.jsp</title>
</head>
<body>
	<center>
	
	<!-- 
		http://localhost/step05_customer/updateSuccess.jsp
		  -> http://localhost/step05_customer/CustomerServlet/allView
	 -->
	
		축하합니다. 회원정보 update 성공하셨습니다.
		<a href="${pageContext.request.contextPath}/CustomerServlet/allView">모두보기</a>

	</center>
</body>
</html>