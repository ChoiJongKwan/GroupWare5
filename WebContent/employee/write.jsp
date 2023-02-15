<%@page import="team3.groupware5.vo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
<style>
  table{
    text-align: center;
    border: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid gray;
    height: 75px;
  }
  th{   
    height:100px;
    background-color: black;
    color:white;
    font-size: 30px;
    font-weight: bold;
  }
  .title{
    font-weight: bold;
  }
  .form-wrapper {
    width:600px;
    text-align: center;
    margin: 200px auto;          
  }
  #joinForm{
    text-align: center;
  }
  input[type=text], input[type=password]  {
    border: 0 solid black;
    width: 200px;
    height:30px;
  }
  

  select {
    width: 200px;
    height:40px;
    font-size: 15px;  
  }
  option {
    padding-left: 40px;
  }
  #check {
    font-size: 10px; 
  }
  
  /* button */
  .btn_join{
    width: 130px; 
    height:45px;
    background-color:black;
    color:white;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_cancel{
    width: 130px; 
    height:45px;
    background-color:black;
    color:white;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_join:hover{
    width: 130px; 
    height:45px;
    background-color:white;
    border: 1px solid black;
    color:black;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_cancel:hover{
    width: 130px; 
    height:45px;
    background-color:white;
    border: 1px solid black;
    color:black;
    font-size: 16px;
    font-weight: bold;
  }
  .btn_div{
    margin-top: 50px;
    text-align: center;
  }
  .btn_span1 {
    margin-right: 10px;
  }  

</style>
</head>
<body>
   <div class="entire-wrap">
    <main>
      
        <div class="form-wrapper">
          
          <form id="joinForm" action="${pageContext.request.contextPath}/company/join"  method="post">
            <table width="100%">   
              <tr>
                <th colspan='2'>Registration</th>
              <tr>
              <td width=30% class="title">Email</td>
              <td width=70%>
                  <input type="text" name="email" >
              </td>
              </tr>
              <tr>
              <td width=30% class="title">Password</td>
              <td width=70%>
                  <input type="password" id="pw" name="password" placeholder="영문, 숫자 포함 8~16자이내 ">
              </td>
              </tr>  
              <tr>
              <td width=30% class="title">Password Check</td>
              <td width=70%>
                <input type="password" id="pw_chk" name="password" placeholder="영문, 숫자 포함 8~16자이내">
              </td>
              </tr>
              <tr>
              <td width=30% class="title">Name</td>
              <td width=70% >
                  <input type="text" name="employeeName">
              </td>
              </tr>        
              <tr>
              <td width=30% class="title">Team</td>
                <td width=70% >     
                   <input type="text" name="teamName">  
                </td>
              </tr> 
              <tr>
              <td width=30% class="title">Position</td>
                <td width=70% >   
                  <input type="text" name="positionName">  
                </td>
              </tr>    
            </table>
            <div class="btn_div">
              <span class="btn_span1">
                <button class="btn_join" type="submit" value="회원가입">Sign Up</button>
              </span>
              <span class="btn_span2">
                <button class="btn_cancel" type="reset" value="취소">Cancel</button>
              </span>
            </div>
          </form>    
      </div>
      </main>
   </div>
</body>
</html>