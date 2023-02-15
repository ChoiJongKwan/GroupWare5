<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<title>cart.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


</head>
<body>


<form action="../BoardServlet/boardupdate" method="post">
	  <!-- update Form  -->	
	  <table border="1" cellspacing="1" width="60%">
		<%--  <tr>
			<td width=30%>사용자 아이디</td>
			<td width=70%>	
				${notice.no}
			</td>
		  </tr> 
 		  <tr>
 			<td width="30%">이름</td>
			<td width="70%">	
				${sessionScope.cvo.name}
			</td>
		  </tr> --%>
		   <tr>
		
			<td width="30%">제목</td>
			<td width="70%">
				<input type="type" name="title" >
			</td>		  
		  <tr>	
		 <tr>
		
			<td width="30%">이메일 주소</td>
			<td width="70%">
				<input type="type" name="content" >
			</td>		  
		  <tr>	 
		 <tr>
			<td width="30%">비밀번호 수정</td>
			<td width="70%">
				<input type="password" name="password" >
			</td>
		  </tr>	 	  	
  
	</table>  
	<p/>


	<input type="submit" value="수정" > &nbsp;
	<input type="reset" value="취소">&nbsp;
	<input type="button" value="모두보기" Onclick="location.href='CustomerServlet/allView'">
</form>
			<hr>
			<div align=right>
				<span style="font-size: 9pt;">&lt;<a href="mandoo">리스트로
						돌아가기</a>&gt;
				</span>
			</div>

			<!-- Footer -->
			<footer class="w3-center w3-light-grey w3-padding-32">
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a>
				</p>
			</footer>
</body>
</html>