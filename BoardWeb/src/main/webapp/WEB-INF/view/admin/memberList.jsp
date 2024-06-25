<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- memberList.jsp -->
<h3>회원목록(관리자용)</h3>

<%-- <ul>
	<!-- 회원아이디/이름/비밀번호/이미지 순으로 나오게 -->
	<c:forEach var="member" items="${memberList}">
		<li>id: ${member.userId}
			<!-- if문으로 쓸 경우 -->
	 		<c:choose>
				<c:when test="${empty member.image}">
					<img src="">
				</c:when>
				<c:otherwise>
					<img src="images/${member.image}">
				</c:otherwise>
			</c:choose>
			<!-- 삼항 연산자를 쓸 경우 -->
			<img width='200px' src="${empty member.image ? '' : 'images/'.concat(member.image)}"></li>
	</c:forEach>
</ul>  --%>

<table>
		<!-- 회원아이디/이름/비밀번호/이미지 순으로 나오게 -->
		<c:forEach var="member" items="${memberList}">
		<tr>
			<th>ID :&ensp;</th><td>${member.userId}&ensp;</td>
			<th>이름 :&ensp;</th><td>${member.userName}&ensp;</td>
			<th>비번 :&ensp;</th><td>${member.userPw}&ensp;</td>
			<th>사진 :&ensp;</th><td><img width='100px' src="${empty member.image ? '' : 'images/'.concat(member.image)}"></td>
		</tr>
		</c:forEach>	
</table>