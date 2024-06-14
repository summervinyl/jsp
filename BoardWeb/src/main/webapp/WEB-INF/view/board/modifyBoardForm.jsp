<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<h3>게시글 수정 화면</h3>

<%-- <%
  BoardVO board = (BoardVO) request.getAttribute("board");
%> --%>

<form action="modifyBoard.do">
	<!--hidden 화면에 보이진 않지만 전달-->
	<!-- 페이지 이동할 때마다 -->
	<input type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">
	<input type="hidden" value="${page }" name="page">
	<table class="table">
		<tr>
			<th>글번호</th><td><input type="text" class="form-control" readonly value="<c:out value="${board.boardNo}" />" name="bno"></td> <!-- value는 DB로 넘길 값 -->
			<th>조회수</th><td>${board.clickCnt }</td>
		</tr>
		<tr>
			<th>제목</th><td colspan="3"><input type="text" value="${board.title}" name="title"> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
			<textarea class="form-control" name="content">${board.content}</textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th><td>${board.writer}</td>
			<th>작성일시</th><td><c:out value="${board.creationDate}"/></td>
		</tr>
		<tr>
			<td colspan="4"><input class="btn btn-warning" type="submit" value="변경ㅋ"></td>
		</tr>
	</table>
</form>

