<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
	<link rel="preconnect1" href="https://fonts.googleapis.com">
	<link rel="preconnect2" href="https://fonts.gstatic.com" crossorigin> 
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
</head>

<body class="is-preload">
	<div class="header1"  style="box-sizing: border-box;" >
		<div align="center">
			<img src="${pageContext.request.contextPath}/images/logo.png" style="width:130px; height:130px;" align="center">
		<div style="float: right;" >
			<a href="${pageContext.request.contextPath}/company/logout">Logout</a>
		</div>
	</div>
	
	<!-- Header -->
	<div id="header2">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class="image avatar48"><img src="../images/avatar.jpg" alt="" /></span>
				<h1 id="title">${sessionScope.employeename}</h1>
				<p>${sessionScope.email}</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="${pageContext.request.contextPath}/BoardServlet/boardallview"><span class="icon solid fa-home">자유 게시판</span></a></li>
					<li><a href="${pageContext.request.contextPath}/search/SearchServlet/allView" id="portfolio-link"><span class="icon solid fa-th">사원조회</span></a></li>
					<li><a href="message/viewmessage/${sessionScope.employeeNo}" id="portfolio-link"><span class="icon solid fa-envelope">메시지</span></a></li>
					<li><a href="todolist/viewtodolist/${sessionScope.employeeNo}" id="portfolio-link"><span class="icon solid fa-envelope">Todolist</span></a></li>
				</ul>
			</nav>


		</div>

		<div class="bottom">

			<!-- Social Icons -->
			<ul class="icons">
				<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon brands fa-github"><span	class="label">Github</span></a></li>
				<li><a href="#" class="icon brands fa-dribbble"><span class="label">Dribbble</span></a></li>
				<li><a href="#" class="icon solid fa-envelope"><span class="label">Email</span></a></li>
			</ul>

		</div>

	</div>

	<!-- Main -->
	<div class="page-title" align="center" style="font-size:40px"><strong>메시지</strong></div>
	<div id="main">
		<table align="center" border="1" cellpadding="15" cellspacing="15" width="100%" bordercolordark="white" bordercolorlight="black">
			<colgroup>
				<col width="10%"/>
				<col width="10%"/>
				<col width="60%"/>
				<col width="10%"/>
				<col width="10%"/>
			</colgroup>
				<tr>
					<td bgcolor="black">
						<p align="center">
							<font color="white"><b><span style="font-size: 20pt;">번호</span></b></font>
						</p>
					</td>
					<td bgcolor="black">
						<p align="center">
							<font color="white"><b><span style="font-size: 20pt;">보낸사람</span></b></font>
						</p>
					</td>
					<td bgcolor="black">
						<p align="center">
							<font color="white"><b><span style="font-size: 20pt;">내용</span></b></font>
						</p>
					</td>
<!-- 					<td bgcolor="black">
						<p align="center">
							<font color="white"><b><span style="font-size: 20pt;">수신일</span></b></font>
						</p>
					</td> -->
					<td bgcolor="black">
						<p align="center">
							<font color="white"><b><span style="font-size: 20pt;">삭제</span></b></font>
						</p>
					</td>
				</tr>
				<c:choose>
					<c:when test="${empty requestScope.list}">
						<tr>
							<td colspan="5">
								<p align="center">
									<b><span style="font-size: 9pt;">메시지가 없습니다.</span></b>
								</p>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.list}" var="m">
							<tr>
								<td bgcolor="">
									<p align="center">
										<span style="font-size: 9pt;"> ${m.no} </span>
									</p>
								</td>
								<td bgcolor="">
									<p align="center">
										<span style="font-size: 9pt;"> ${m.employeeNo.employeeNo} </span>
									</p>
								</td>
								<td bgcolor="">
									<p align="center">
										<span style="font-size: 9pt;"> ${m.content} </span>
									</p>
								</td>
								<%-- <td bgcolor="">
						            <p align="center">
							            <span style="font-size:9pt;"> ${m.writedate}</span>
						            </p>
							    </td> --%>
								<td bgcolor="">
									<p align="center">
										<span style="font-size: 9pt;">
											<input type="hidden" name="no" value="${m.no}">
											<button onclick="location.href='${pageContext.request.contextPath}/message/delete?no=${m.no}'"> 삭제 </button></p>
										</span>
									</p>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		<hr>
		<div align=right>
			<span style="font-size:9pt;">&lt;<a href="${pageContext.request.contextPath}/message/send.html">메시지 발송</a>&gt;</span></div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
		
</body>
</html>
