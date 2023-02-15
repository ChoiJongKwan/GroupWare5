<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="/css/bootstrap.css">
<title>Insert title here</title>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id = "dataView"></div>
<div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div align="center">
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea style="width: 1100px" rows="3" cols="30" id="reply" name="reply" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <a onClick="fn_comment('${boardData.no}')" class="btn pull-right btn-success">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="boardNo" name="boardNo" value="${boardData.no}" />  
        <input type="hidden" id="content" name="content" value="${content}" />  
          
    </form>
</div>
<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>
    </form>
</div>
<script>

	//댓글입력 메서드
 	function fn_comment(no){
	
		$("#reply").val();
		var text = $('textarea').val();
		
		console.log(text);
		axios({
			  method: 'GET',
			  url:'../BoardServlet/addreply?boardNo='+no+'&content='+text
			})
			.finally(function () {
				//댓글 리스트 불러오기
				reqResAxios2();
				//text박스 초기화
				document.getElementById("reply").value = ``;
			 });
	
		
	}
	
	

	//초기 실행 댓글리스트(로딩시 바로 실행)
	(function reqResAxios(){
		 reqResAxios2();
	})();
	
	//댓글 출력 메서드 
	function reqResAxios2(){
		axios({
			  method: 'POST',
			  url:'../BoardServlet/replyread?boardNo='+${boardData.no}
			}) 
			.then(function(resData){
				 
				 drawTable(resData.data);
				
		});
	}
	
	
	/*  function drawTable(list) {
	  document.getElementById("commentList").innerHTML = ``;

	  let table = document.createElement("table");  
	  table.classList.add('w3-table-all');

	  let tr = document.createElement("tr");  
	  let th = document.createElement("th"); 

	  th.style.textAlign = 'center';
	  th.innerHTML = '';
	  tr.appendChild(th); 
	  th = document.createElement("th");
	  th.style.textAlign = 'center';
	
	  th.innerHTML = '내용';
	  tr.appendChild(th);
	  table.appendChild(tr);  

	  console.log(list);
	  
	  list.forEach(function (item) {
		    let tr = document.createElement("tr");
		    tr.classList.add('w3-hover-green');

		  
		    for (let key in item) { 
		      let td = document.createElement("td");
		      td.style.textAlign = 'center';
		      td.innerHTML = item[key];
		      tr.appendChild(td);
		    };

		    table.appendChild(tr);
		  });

	  
	  return document.getElementById("commentList").appendChild(table);
	}  */ 
	
 	function drawTable(list) {
		  document.getElementById("commentList").innerHTML = ``;
		  
		  let fieldset =	document.createElement("fieldset");
		  let div = document.createElement("div"); 
		  //div.style.width = 75px;
		 
		  
		  div.appendChild(fieldset);
		  console.log(list);
		  
		  list.forEach(function (item) {
			  let fieldset =	document.createElement("fieldset");
			  let button1 = document.createElement("button");
			  let button2 = document.createElement("button");
			    for (let key in item) { 
			    	
			    let legend = document.createElement("legend");
			    let br =document.createElement("br");
			    div.appendChild(br);
			    legend.innerHTML = item[key];
			   /*  button1.type = "button";
			    button1.onclick = "update(${replyList.no})";
			    button1.innerHTML = "수정";	     
			    
			    button2.type = "button";
			    button2.onclick = "delete(${replyList.no})";
			    button2.innerHTML = "삭제"; */ 
			    
			    
			    fieldset.appendChild(legend);
			    
			    div.appendChild(br);
			    };
			   	
			    div.appendChild(fieldset);
			    /* div.appendChild(button1);
			   	div.appendChild(button2); */
			  });

		  
		  return document.getElementById("commentList").appendChild(div);
		}  
	
	 

	/* function update(){
		console.log("update");
	}
	
	function delete(){
		console.log("delete");
	} */
	



</script>


</body>
</html>