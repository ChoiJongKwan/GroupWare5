<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<% System.out.println("view.jsp실행 확인"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원정보 보기</title>
</head>

<body>

	<h3>개인 회원 정보 보기</h3>
	<br>
	<!-- view Form
		http://localhost/step05_customer/CustomerServlet/insert
			- 가입 정보 입력 후 가입 후 실행된 url
				- view.jsp
		http://localhost/step05_customer/CustomerServlet/allView
	  -->
	<form action="allView">
		
		<table border="1" cellspacing="1" width="60%">
			<tr>
				<td width=30%>사용자 아이디</td>
				<td width=70%>${cvo.id}</td>
			</tr>
			<tr>
				<td width="30%">비밀번호</td>
				<td width="70%">${cvo.password}</td>
			</tr>
			<tr>
				<td width="30%">이름</td>
				<td width="70%">${cvo.name}</td>
			</tr>
			<tr>
				<td width="30%">이메일 주소</td>
				<td width="70%">${cvo.email}</td>
			</tr>
		</table>
		<br>
		<br> 
		
		<!-- 
		http://ip:port/context명/update.jsp
		${pageContext.request.contextPath} : 코드 사용 권장
		즉 현 jsp의 실행 위치가 어디에 있든지 <http://ip:port/context명/> 을 의미하는 코드
		 -->
		
		<input type="button" value="update" Onclick="location.href='${pageContext.request.contextPath}/update.jsp'">&nbsp; 
		<input type="submit" value="allView"> 
	</form>


</body>
</html>
