<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="team3.groupware5.vo.*, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>직원 조회</title>

	<style type="text/css">
	.tg  {border-collapse:collapse;border-spacing:0; width: 60%;}
	.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
	  overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
	  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg .tg-baqh{text-align:center;vertical-align:top}
	.tg .tg-l4e4{background-color:#000000;border-color:inherit;color:#ffffff; font-weight:bold;text-align:center;vertical-align:top}
	</style>

</head>
<body>

<center>
<h3>직원 정보 조회</h3>

    <!-- board seach area -->
    <div id="board-search">
        <div class="container">
            <div class="search-window">
                <form action="/search/SearchServlet/allView">
                    <div class="search-wrap">
                        <label for="search" class="blind">직원 검색</label>
                        <input id="search" type="search" name="" placeholder="직원 사번 입력" value="${evo.employeeNo}">
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	<br>

<%-- 고객이 미 존재시 : 현존하는 고객은 없습니다 / 존재할 경우 table로 출력 --%>
<c:if test="${ not empty requestScope.allData }">

		<table class="tg">
		<thead>
		  <tr>
		    <th class="tg-l4e4">사번</th>
		    <th class="tg-l4e4">부서</th>
		    <th class="tg-l4e4">이름</th>
		    <th class="tg-l4e4">메일</th>
		    <th class="tg-l4e4">직급</th>
		    <th class="tg-l4e4">탈퇴</th>
		    <th class="tg-l4e4">수정</th>
		  </tr>
		</thead>	
		
		<c:forEach items="${requestScope.allData}" var="evo">
			<tr>
				<td class="tg-baqh">${evo.employeeNo}</td>
				<td class="tg-baqh">${evo.teamName}</td>
				<td class="tg-baqh">${evo.employeeName}</td>
				<td class="tg-baqh">${evo.email}</td>
				<td class="tg-baqh">${evo.positionName}</td>
				<td class="tg-baqh">
				  <button onclick='location.href="${pageContext.request.contextPath}/search/SearchServlet/delete?email=${evo.email}"'>탈퇴</button>
				</td>
				<td class="tg-baqh">
				  <button onclick='location.href="${pageContext.request.contextPath}/search/update.jsp"'>수정</button>
				</td>
			</tr>
		</c:forEach>
	 
	</table>
</c:if>

<!-- 	<div class="text-center">
		<ul class="pagination">
		<a href="#">1</a>
		<a href="#">2</a>
		<a href="#">3</a>
		</ul>
	</div> -->


<c:if test="${empty requestScope.allData}">
	현 시점엔 고객이 한 명도 없습니다.<br>
</c:if>

<p>
<a href="${pageContext.request.contextPath}/main.jsp">메인</a>  
<%-- <a href="${pageContext.request.contextPath}/SearchServlet/logout">로그아웃</a> --%>

</center>
</body>
</html>
