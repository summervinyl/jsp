<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <style>
 	div.reply div{
 		margin: auto;
 	}
 	div.reply ul{
 		list-style-type: none;
 		margin-top: 3px;
 	}
 	div.reply li{
 		padding-top: 1px;
 		padding-bottom: 1px; 		
 	} 
 	div.reply span{
 		display: inline-block;
 	}
 </style>
 
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


<!-- 댓글 관련 시작 -->
<div class="container reply">
<!-- 2.  -->
	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3" id="addReply">등록</button>
	</div>
	
<!-- 1. 댓글 목록 보여주기 -->
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-1">글번호</span> <!-- 전체가 12라서 1/12만큼 자리 차지 / 스타일도 있으니 11기준으로 설정-->
				<span class="col-sm-4">글내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-3">작성일시</span>
				<span class="col-sm-1">삭제</span>
			</li>
			<li><hr /></li>
			<!-- dom요소를 활용해서 아래와 같이 만들기, 템플릿 역할. -->
			<li style="display: none">
				<span class="col-sm-1">3</span>
				<span class="col-sm-4">글을 잘 보았습니다.</span>
				<span class="col-sm-2">user01</span>
				<span class="col-sm-3">2024-05-08 11:08:10</span>			
				<span class="col-sm-1"><button onclick="deleteRow(event)">삭제</button></span>			
			</li>
		</ul>
	</div>	

	<div class="footer">
		<div class="center">
			<div class="pagination">
				<a href="#">1</a>
				<a href="#" class="active">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
			</div>
		</div>
	</div>

</div>
<!-- 댓글 관련 끝 -->


<script>
	//글번호 담아두기 - 댓글관련
	const bno = "${board.boardNo}"; //${board.boardNo} jsp 표현식 //원본글에대한 정보
	const replyer = "${loginID}"; //댓글 등록시 아이디값 저장
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


<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>