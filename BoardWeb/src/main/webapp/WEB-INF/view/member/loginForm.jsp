<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->

<!-- 자바 코드를 빼고 최대한 태그로 표현하기 위한 -->
<!-- taglib 지시자 -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="cust" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%-- <%@include file="../public/header.jsp" %> --%>
<h3>로그인 화면(/loginForm.jsp)</h3>
<cust:line/>
<!-- 우리가 직접 만들었던 태그를 갖다 쓰겠다 (line.tag)-->
<!-- jsp에서 제공해서는 standard tag library = jstl-->

<!-- {} 이엘표현식? jsp에서만 -->
<%-- <c:set var="name" value="aa" />
<c:out value="${name == 'aa' ? '맞음' : '다름'}" /> --%>
<%-- <c:forEach var="i" begin="1" end="10" step="1">
	<p>${i}</p>
</c:forEach> --%>


<!-- form은 사용자가 클릭을 했을 때 액션 지정 -->
<!-- 줄 맞추기 위해서 테이블 쓴다. -->
<form action="login.do">
	<table class="table">
	
		<tr>
			<th>아이디</th><td><input type="text" name="id"></td>
		</tr>
		
		<tr>
			<th>비밀번호</th><td><input type="password" name="pw"></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="로그인"></td>
		</tr>
	
	</table>
</form>

<!-- footer -->
<%-- <%@include file="../public/footer.jsp" %> --%>
