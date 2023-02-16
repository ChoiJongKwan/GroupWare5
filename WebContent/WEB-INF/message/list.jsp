<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>Prologue by HTML5 UP</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../assets/css/yy.css" />
	<script type="text/javascript">
		function sendDelete() {
			document.requestForm.command.value = "/delete";
			document.requestForm.submit();
		}
	</script>
</head>
<body class="is-preload">
	<div class="header1" style="box-sizing: border-box;">

		<span>
			<a href="${pageContext.request.contextPath}/company/logout">Logout</a>
		</span>
		<span class="mypage_span">
			<a href="">MyPage</a>
		</span>
		
	</div>
	
	<!-- Header -->
	<div id="header2">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class="image avatar48"><img src="../images/avatar.jpg" alt="" /></span>
				<h1 id="title">유재석</h1>
				<p>인사팀</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="NoticeServlet/noticeallview"><span class="icon solid fa-home">공지사항</span></a></li>
					<li><a href="todolist/allview" id="portfolio-link"><span class="icon solid fa-th">todolist</span></a></li>
					<li><a href="#about" id="about-link"><span class="icon solid fa-user">About Me</span></a></li>
					<li><a href="#contact" id="contact-link"><span class="icon solid fa-envelope">Contact</span></a></li>
					<li><a href="message/view" id="portfolio-link"><span class="icon solid fa-envelope">메시지</span></a></li>
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
	<div id="main">
		<section id="top" class="one dark cover">
			<form name="requestForm" method="post" action="delete">
				<table border="1">
					<colgroup>
						<col width="20%" />
						<col width="40%" />
						<col width="10%" />
						<col width="3%" />
						<col width="3%" />
						<col width="14%" />
					</colgroup>
					<tr>
						<td bgcolor="black">
							<p align="center">
								<font color="white"><b><span style="font-size: 25pt;">번호</span></b></font>
							</p>
						</td>
						<td bgcolor="black">
							<p align="center">
								<font color="white"><b><span style="font-size: 25pt;">보낸사람</span></b></font>
							</p>
						</td>
						<td bgcolor="black">
							<p align="center">
								<font color="white"><b><span style="font-size: 25pt;">내용</span></b></font>
							</p>
						</td>
						<td bgcolor="black">
							<p align="center">
								<font color="white"><b><span style="font-size: 25pt;">작성일자</span></b></font>
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
											<span style="font-size: 9pt;"> ${m.employeeNo} </span>
										</p>
									</td>
									<td bgcolor="">
										<p align="center">
											<span style="font-size: 9pt;"> ${m.content} </span>
										</p>
									</td>
									<%-- <td bgcolor="">
								            <p align="center"><span style="font-size:9pt;">		
												${m.writedate}
											</span></p>
								    </td> --%>
									<td bgcolor="">
										<p align="center">
											<span style="font-size: 9pt;"> <input type="hidden"
												name="no" value="${m.no}">
												<button onclick="sendDelete()">삭제</button>
											</span>
										</p>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
			<hr>
			<div align=right>
				<span style="font-size: 9pt;">&lt;<a
					href="../message/sendmessage.html">메시지 발송</a>&gt;
				</span>
			</div>
		</section>
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