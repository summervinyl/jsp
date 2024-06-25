<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>회원등록</h3>

<form action="addMember.do" method="post" enctype="multipart/form-data"> <!-- addMember.do로 가면 멀티파트를 처리하는 기능이 있음. -->
	<table class="table">
		<tr>
			<th>아이디</th><td><input class="form-control" type="text" name="id"></td>
		</tr>
		
		<tr>
			<th>비밀번호</th><td><input class="form-control" type="password" name="pw"></td>
		</tr>
		
		<tr>
			<th>이름</th>	<td><input class="form-control" type="text" name="name"></td>
		</tr>
		
		<tr>
  			<th>이미지</th><td><input class="form-control" type="file" name="myImage"></td>
  		</tr>
  		
		<tr align="center">
			<td colspan="2"><input type="submit" value="등록" class="btn btn-primary"></td>
		</tr>
	</table>
</form>