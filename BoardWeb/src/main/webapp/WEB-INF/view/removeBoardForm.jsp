<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp" %>

<h3>게시글 삭제 화면</h3>

<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<!-- 삭제할 게시글 화면 보여주기. -->
<!-- 글번호, 제목, 내용, 작성자, 작성일시, 삭제 버튼 -->
<form action="removeBoard.do">
	<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=board.getBoardNo() %></td>
		</tr>
		
		<tr>
			<th>제목</th><td><%=board.getTitle() %></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea class="form-control"><%=board.getContent() %></textarea></td>
		</tr>
		
		<tr>
			<th>작성자</th><td><%=board.getWriter() %></td>
		</tr>
		
		<tr>
			<td><button type="submit">삭제</button></td>
		</tr>
	</table>
</form>

<%@include file="../public/footer.jsp" %>