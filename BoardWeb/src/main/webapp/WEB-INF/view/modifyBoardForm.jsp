<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../public/header.jsp" />


<h3>게시글 수정 화면</h3>

<%-- <%
  BoardVO board = (BoardVO) request.getAttribute("board");
%> --%>

<form action="modifyBoard.do">
	<table class="table">
		<tr>
			<th>글번호</th><td><input type="text" class="form-control" readonly <c:out value="${board.boardNo}" /> name="bno"></td> <!-- value는 DB로 넘길 값 -->
			<th>조회수</th><td></td>
		</tr>
		<tr>
			<th>제목</th><td colspan="3"><input type="text" <c:out value="${board.title}" />> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
			<textarea class="form-control" name="content"><c:out value="${board.content}" /></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th><td><c:out value="${board.writer}" /></td>
			<th>작성일시</th><td><c:out value="${board.creationDate}" /></td>
		</tr>
		<tr>
			<td colspan="4"><input class="btn btn-warning" type="submit"></td>
		</tr>
	</table>
</form>

<jsp:include page="../public/footer.jsp" />