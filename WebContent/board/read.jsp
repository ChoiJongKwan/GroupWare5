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


			<script language=javascript>

				function sendUpdate() {
					document.requestForm.category.value = "mdservice";
					document.requestForm.command.value = "updateForm";
					
					document.requestForm.submit();
				}

				
				function sendDelete() {
					
					var pw = prompt("삭제할 게시물의 비밀번호를 입력하세요");

					if (pw) {//데이터가 있으면 true
						document.requestForm.category.value = "mdservice";
						document.requestForm.command.value = "delete";
						document.requestForm.pw.value = pw;
						document.requestForm.submit();
					} else {
						return false;
					}
				}
			</script>

			</HEAD>

			<table align="center" cellpadding="5" cellspacing="2" width="60%"
				border='1'>
				<tr>
					<td width="1220" height="20" colspan="4" bgcolor="black">
						<p align="center">
							<font color="white" size="3"> <b>${boardData.no}번 게시물 자세히보기</b>
							</font>
						</p>
					</td>
				</tr>
				<%--
			request.setAttribute("resultContent", gContent);  GuestBookBean객체
		--%>

				<tr>
					<td width="100" height="20">
						<p align="right">
							<b><span style="font-size: 12pt;">작성자</span></b>
						</p>
					</td>
					<td width="450" height="20" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.employeeNo.employeeName}</b></span>
					</td>
				</tr>


				<tr>
					<td width="100" height="20">
						<p align="right">
							<b><span style="font-size: 12pt;">작성일</span></b>
						</p>
					</td>
					<td width="450" height="20" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.writedate}</b></span>
					</td>
				</tr>
				<tr>
				<tr>
					<td width="100" height="20">
						<p align="right">
							<b><span style="font-size: 12pt;">제 목</span></b>
						</p>
					</td>
					<td width="450" height="20" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.title}</b></span>
					</td>
				</tr>


				<tr>
					<td width="100" height="200" valign="top">
						<p align="right">
							<b><span style="font-size: 12pt;">내 용</span></b>
						</p>
					</td>
					
					<td width="450" height="200" valign="top" colspan="3"><span
						style="font-size: 12pt;"><b>${boardData.content}</b></span></td>
				</tr>

				<tr>
					<td height="20" colspan="4" align="center" valign="middle">

						<%-- <form name="requestForm" method="post" action="mandoo">
							<input type="hidden" name="mdserviceNo"
								value="${requestScope.resultContent.mdserviceNo}"> 
								<input type="hidden" name="command" value="">
								<input type="hidden" name="category" value="">
								 <input type="hidden" name="pw" value=""> --%>
							<div id = "myId">
							<button type="button" onClick="location.href='../board/update.jsp?no=${boardData.no}'">수정</button>
							<button type="button" onclick="message(); location.href='../BoardServlet/boarddelete'">삭제</button>
							</div> 
					<%--	</form>  --%>

					</td>
				</tr>
			</table>

			
			<hr>
			<div align=right>
				<span style="font-size: 12pt;">&lt;<a
					href="mandoo?category=mdservice&command=list">리스트로 돌아가기</a>&gt;
				</span>
			</div>
			
		
</body>
</html>

<script>

/* (function myId(){
	var con = document.getElementById("myId");
	
	if( ${boardData.employeeNo.employeeName} == ${myId} ){
		console.log(${boardData.employeeNo.employeeName});
		console.log(${myId});
		con.style.display = "none";
	}
})(); */

function message(){
	var pw = prompt("삭제할 게시물의 비밀번호를 입력하세요");
	
	if(pw){
		window.alert("정말 삭제하시겠습니까?");
		return true;
	}else{
		return false;
	}
	
}



</script>

<%@ include file="reply.jsp" %>

