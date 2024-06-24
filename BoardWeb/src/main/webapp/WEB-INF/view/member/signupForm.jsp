<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3> 회원가입 페이지 </h3>

<form action="signup.do" method="post" enctype="multipart/form-data"> <!-- multipart : 파일 전송 -->
  <table class="table">
  	<tr>
  		<th>이름</th><td><input type="text" name="name"></td>
  	</tr>
  	
  	<tr>
  		<th>아이디</th><td><input type="text" name="id"></td>
  	</tr>
  	
  	<tr>
  		<th>비밀번호</th><td><input type="password" name="pw"></td>
  	</tr>
  	
  	<tr>
  		<th>권한</th><td><input type="text" name="res"></td>
  	</tr>
  	
	<tr>
  		<th>이미지</th><td><input class="form-control" type="file" name="myImage"></td>
  	</tr>
  	
  	<tr>
  		<td><input type="submit" value="회원가입"></td>
  	</tr>

  </table>





</form>