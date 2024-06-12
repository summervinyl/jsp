<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- "boardList"에 담긴 값을 읽어서 반복 처리. -->
<%@include file="../public/header.jsp" %>

<!-- https://www.w3schools.com/css/css3_pagination.asp에서 가져온 페이지클릭 스타일 -->

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


<%
  //request는 jsp의 내장 객체.
  List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList"); //request.getAttribute
  PageDTO pageDTO = (PageDTO) request.getAttribute("paging");
%>

<!-- pageDTO 출력 -->
<p><%=pageDTO %></p>

<h3>게시글 목록</h3>

<table class="table">

 <thead>
  <tr>
    <th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th>
  </tr>
 </thead>
 
 <tbody>
 
  <%for(BoardVO vo : list) { %>
  <tr>
    <td><%=vo.getBoardNo() %></td>
    <td><a href="getBoard.do?bno=<%=vo.getBoardNo()%>&page=<%=pageDTO.getPage()%>" style="color:black"><%=vo.getTitle() %></a></td>
    <td><%=vo.getWriter() %></td>
    <td><%=vo.getClickCnt() %></td>
  </tr> 
  <%} %>
 
 </tbody>
 
</table>

<!-- paging : https://www.w3schools.com/css/css3_pagination.asp에서 가져온 페이지클릭 -->
<div class="center">
  <div class="pagination">
  <h1>end page = <%= pageDTO.getEndPage() %></h1>
  <!-- 이전 페이지 -->
  <%if (pageDTO.isPrev()) {%>
    <a href="boardList.do?page=<%=pageDTO.getStartPage()-1%>">&laquo;</a>
  <%} %>
  
  <!-- 지금 보여지는 페이지가 같으면 액티브 실행 -->
  <%for (int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage(); p++) {%>
  <!-- 현재 보여지는 페이지에 커스  -->
  <%if(p == pageDTO.getPage()) {%>
    <a href="boardList.do?page=<%=p %>" class="active"><%=p %></a>
  <%}else {%>
    <a href="boardList.do?page=<%=p %>"><%=p %></a>
  <%} } %>
  
  <%if (pageDTO.isNext()) {%>
    <a href="boardList.do?page=<%=pageDTO.getEndPage()+1%>">&raquo;</a>
  <%}%>
  </div>
</div>
<!-- 나중에 for문 이용해서 재설정해줄 거야. -->

<a href="/boardForm.do"> 등록</a>


<%@include file="../public/footer.jsp" %>