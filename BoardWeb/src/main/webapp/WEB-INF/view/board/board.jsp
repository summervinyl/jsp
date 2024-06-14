<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
    
<%-- <%@include file="../public/header.jsp" %> --%>
<!-- include:포함시키다. -->
<!-- 사용자 정의 태그   뒤에 /는 닫는 태그와 함께 씀-->

<%-- <%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
  String yyyymmdd = sdf.format(board.getCreationDate());
  String paging = (String) request.getAttribute("page");
  //현재 로그인 아이디 받아오기
  String loginID = (String) session.getAttribute("loginID");
%> --%>
<!-- 태그로 변수 선언과 출력방법 -->

<!-- boardㅓ는 어트리뷰트를 -->

<form name="myForm" action="removeForm.do">
	<input type="hidden" value="${board.boardNo}" name="bno"> <!-- getBo~ 대신 필드명 작성  -->
	<%-- <input type="hidden" value="<%=board.getBoardNo() %>" name="bno"> --%> <!-- 폼태그 안의 파라미터는 인풋태그  -->
	<!--hidden 화면에 보이진 않지만 전달-->
	<input type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">
	<input type="hidden" value="${page }" name="page">
	<table class="table table-sm">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-7"><c:out value="${board.boardNo}"/></td>
			<%-- <td class="col-sm-7"><%=board.getBoardNo() %></td> --%>
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-3"><c:out value="${board.clickCnt}"/> </td> <!-- 출력이라 out으로  -->
			<%-- <td class="col-sm-3"><%=board.getClickCnt() %></td> --%>
		</tr>
		<tr>
			<th>제목</th><td colspan="3" ><c:out value="${board.title}"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
			<textarea class="form-control" readonly><c:out value="${board.content}"/></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th><td colspan="3"><c:out value="${board.writer}"/></td>
		</tr>
		<tr>
			<th>작성일시</th><td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate}"/> </td>
		</tr>
		<tr align="center">
			<td colspan="3">
			<!-- c태그의 if else -->
			<c:choose>
				<c:when test="${!empty loginID && loginID == board.writer}">
				  <button type="submit" class="btn btn-danger">삭제 이동</button>
				  <button type="button" class="btn btn-warning">수정 이동</button>
				</c:when>
				<c:otherwise>
				  <button type="submit" disabled class="btn btn-danger">삭제 이동</button>
				  <button type="button" disabled class="btn btn-warning">수정 이동</button>
				</c:otherwise>
			</c:choose>
			<a href="boardList.do?page=${page}&searchCondition=${searchCondition}&keyword=${keyword }" class="btn btn-success">목록</a> <!-- 클라이언트가 요정하는 주소 입력 -->
			</td>
		</tr>
	</table>
</form>

<script>
	//button일 경우엔 클릭이벤트ㄹ를 해주ㅑ아 함.
	document.querySelector('button.btn-warning').addEventListener('click', function(e){
		//삭제 화면 이동일 경우에는 removeForm.do로 이동
		//수정 화면 이동으로 처리할 경우에는 action="modifyForm.do"로 이동
	document.forms.myForm.action = "modifyForm.do";
	document.forms.myForm.submit();
	});
	
</script>
<%-- <%@include file="../public/footer.jsp" %> --%>
<%-- <jsp:include page="../public/footer.jsp"/> --%>