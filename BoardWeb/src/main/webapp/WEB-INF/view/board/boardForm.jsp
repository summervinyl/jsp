<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- header -->

<%-- <%
 String id = (String) session.getAttribute("loginID");
%> --%>

<!-- 제목, 작성자, 내용, 등록버튼 -->
<!-- 액션이 있을 경우엔 무조건 submit -->
<form action="addBoard.do">
	
	<label>제목</label>
	<input type="text" name="title">
	
	
	<label>작성자</label>
	<input type="text" name="writer" readonly value=<c:out value="${loginID}" /> >
	
	<label>내용</label>
	<textarea class="form-control" name="content"></textarea>
	<!-- <textarea rows="" cols=""></textarea> -->
	
	<button type="submit">등록</button>
</form>


<!-- footer -->
