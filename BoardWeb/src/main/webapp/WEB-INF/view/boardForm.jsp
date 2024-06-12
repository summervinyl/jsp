<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->
<%@include file="../public/header.jsp" %>


<!-- 제목, 작성자, 내용, 등록버튼 -->
<!-- 액션이 있을 경우엔 무조건 submit -->
<form action="addBoard.do">
	
	<label>제목</label>
	<input type="text"></input>
	
	<label>작성자</label>
	<input type="text"></input>
	
	<label>내용</label>
	<textarea class="form-control"></textarea>
	<!-- <textarea rows="" cols=""></textarea> -->
	
	<button type="submit">등록</button>
</form>






<!-- footer -->
<%@include file="../public/footer.jsp" %>