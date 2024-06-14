<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<!-- 자바 코드 대신 태그를 사용하기 위한 설정 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!-- 태그를 사용하여 header 선언 -->

<!-- https://www.w3schools.com/css/css3_pagination.asp에서 가져온 스타일 -->
<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: gray;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #fac1c1;
  color: black;
  border: 1px solid fab4b4;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<!-- 자바 코드 -->
<%-- <%
  //request는 jsp의 내장 객체.
  List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList"); //request.getAttribute
  PageDTO pageDTO = (PageDTO) request.getAttribute("paging");
%> --%>
<!-- pageDTO 출력 -->
<%-- <p><%=pageDTO %></p> --%>

<h3>게시글 목록</h3>

<div class="center">
	<form action="boardList.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T">제목</option>
					<option value="W">작성자</option>
					<option value="TW">제목&작성자</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" class="form-control">
			</div>
			<div class="col-sm-2">
					<input type="submit" class="btn btn-warning">
			</div>
		</div>	
	</form>
</div>

<table class="table">
<p>sc: ${searchCondition } kw: ${keyword } page: ${page }</p>
	<thead>
		<tr>
		  <th>글번호</th>
		  <th>제목</th>
		  <th>작성자</th>
		  <th>조회수</th>
		</tr>
	</thead>
		 
	<tbody>
		<c:forEach var="vo" items="${boardList}">
		<tr>
			<td>${vo.boardNo}</td>
			<td><a href="getBoard.do?bno=${vo.boardNo}&page=${paging.page}&searchCondition=${searchCondition}&keyword=${keyword }" style="color:black"><c:out value="${vo.title}"/></a></td>
			<td><c:out value="${vo.writer}"/></td>
			<td><c:out value="${vo.clickCnt}"/></td>
		</tr>
		</c:forEach>
	</tbody>
 
</table>

<div class="center">
	<div class="pagination">
	<h1>end page = ${paging.startPage}</h1>
		<!-- 이전 페이지 -->
		<c:if test="${paging.prev}">
			<a href="boardList.do?page=${paging.startPage-1}&searchCondition=${searchCondition}&keyword=${keyword }">&laquo;</a>
		</c:if>
	  
	   <!-- 지금 보여지는 페이지가 같으면 액티브 실행 -->	
	   <c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
	  		<a href="boardList.do?page=${p }&searchCondition=${searchCondition}&keyword=${keyword }" class=${p == paging.page ? 'active' : ''}><c:out value="${p }" /> </a>
	   </c:forEach>
	  
		<c:if test="${paging.next}">
			<a href="boardList.do?page=${paging.endPage+1}&searchCondition=${searchCondition}&keyword=${keyword }">&raquo;</a>  
		</c:if>	
	</div>
</div>
<!-- 나중에 for문 이용해서 재설정해줄 거야. -->

