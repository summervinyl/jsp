<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<h3>게시글 삭제 화면</h3>

<!-- 삭제할 게시글 화면 보여주기. -->
<!-- 글번호, 제목, 내용, 작성자, 작성일시, 삭제 버튼 -->
<form action="removeBoard.do">
	<input type="hidden" name="bno" value="${board.boardNo}">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<table class="table">
		<tr>
			<th>글번호</th><td>${board.boardNo}</td>
		</tr>
		
		<tr>
			<th>제목</th><td>${board.title}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" readonly>${board.content}</textarea></td>
		</tr>
		
		<tr>
			<th>작성자</th><td>${board.writer}</td>
		</tr>
		
		<tr>
			<td><button type="submit">삭제</button></td>
		</tr>
	</table>
</form>

