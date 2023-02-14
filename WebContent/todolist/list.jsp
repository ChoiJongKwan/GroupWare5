<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sendDelete() {
	document.requestForm.command.value ="/delete";
	document.requestForm.submit();
}

</script>

</head>
<body>
<form name="requestForm" method="post" action="delete">
<table align="center" border="1" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<colgroup>
		<col width="20%"/>
		<col width="40%"/>
		<col width="10%"/>
		<col width="3%"/>
		<col width="3%"/>
		<col width="14%"/>

	</colgroup>
	<tr>
        <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">내용</span></b></font></p>
        </td>
        <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">중요도</span></b></font></p>
        </td>
         <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">시</span></b></font></p>
        </td>
         <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">분</span></b></font></p>
        </td>
         <td bgcolor="black">
            <p align="center"><font color="white"><b><span style="font-size:25pt;">삭제</span></b></font></p>
        </td>

    </tr>
    <c:choose>
    <c:when test="${empty requestScope.list}">
	<tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 할일이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="e">
		    <tr>
		        <td bgcolor="">
					<p align="center"><span style="font-size:9pt;">
					${e.title}</span></p>
					
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">		
						${e.content}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">		
						${e.importance}
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">		
						${e.date}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">		
						${e.time}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">		
						<input type="hidden" name="num" value="${e.num}">
						<button onclick="sendDelete()">삭제 </button>
					</span></p>
		        </td>
		    </tr>
		 
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
	
</form>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="../todolist/write.html">일정추가 </a>&gt;</span></div>
</body>