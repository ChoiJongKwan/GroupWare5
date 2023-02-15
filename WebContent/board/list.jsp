<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<style>

</style>
<title>Prologue by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="preconnect1" href="https://fonts.googleapis.com">
<link rel="preconnect2" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../assets/css/yy.css" />



</head>
<body class="is-preload">
	<div class="header1" style="box-sizing: border-box;">
		<h1>header</h1>
	</div>
	<!-- Header -->
	<div id="header2">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class="image avatar48">
					<img src="../images/avatar.jpg" alt="" />
				</span>
				<h1 id="title">유재석</h1>
				<p>인사팀</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="../BoardServlet/boardallview"><span class="icon solid fa-home">자유 게시판</span></a></li>
					<li><a href="../NoticeServlet/noticeallview"><span class="icon solid fa-home">공지사항</span></a></li>
					<li><a href="#portfolio" id="portfolio-link"><span class="icon solid fa-th">Portfolio</span></a></li>
					<li><a href="#about" id="about-link"><span class="icon solid fa-user">About Me</span></a></li>
					<li><a href="#contact" id="contact-link"><span class="icon solid fa-envelope">Contact</span></a></li>
				</ul>
			</nav>

		</div>

		<div class="bottom">

			<!-- Social Icons -->
			<ul class="icons">
				<li><a href="#" class="icon brands fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon brands fa-facebook-f"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon brands fa-github"><span
						class="label">Github</span></a></li>
				<li><a href="#" class="icon brands fa-dribbble"><span
						class="label">Dribbble</span></a></li>
				<li><a href="#" class="icon solid fa-envelope"><span
						class="label">Email</span></a></li>
			</ul>

		</div>

	</div>

	<!-- Main -->
	<br><br>
	<div id="main">


		<div class="page-title">
			<div class="container1">
				<h3>자유게시판</h3>
			</div>
		</div>

		<!-- board seach area -->
		<!-- <div id="board-search">
			<div class="container1">
				<div class="search-window">
					<form action="">
						<div class="search-wrap">
							<label for="search" class="blind">공지사항 내용 검색</label> <input
								id="search" type="search" name="" placeholder="검색어를 입력해주세요."
								value="">
							<button type="submit" class="btn btn-dark">검색</button>
						</div>
					</form>
				</div>
			</div>
		</div> -->

		<!-- board list area -->
		<div id="board-list">
			<div class="container1">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">이름</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>

						<c:choose>
							<c:when test="${empty requestScope.allData}">
								<tr>
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 12pt;">등록된 방명록이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>

								<c:forEach items="${requestScope.allData}" var="e">

									<tr>
										<td>${e.no}</td>
										<th><a href="../BoardServlet/boardread?no=${e.no}">${e.title}</a></th>
										<td>${e.employeeNo.employeeName}</td>
										<td>${e.writedate}</td>
									</tr>

								</c:forEach>
							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
			</div>
		</div>
	<br>
	<div align="right">
	<button type="button" onclick="location.href = '../board/write.html'" style="background-color:#555">
		<i class='far fa-file-alt' style='font-size:18px;color:white' >&nbsp;글쓰기</i>
		
	</button>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	</div>
	<br><br>


		<!-- Scripts -->
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/jquery.scrolly.min.js"></script>
		<script src="../assets/js/jquery.scrollex.min.js"></script>
		<script src="../assets/js/browser.min.js"></script>
		<script src="../assets/js/breakpoints.min.js"></script>
		<script src="../assets/js/util.js"></script>
		<script src="../assets/js/main.js"></script>
</body>
</html>