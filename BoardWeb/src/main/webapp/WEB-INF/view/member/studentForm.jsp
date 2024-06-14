<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<h3>학생 등록 화면</h3>

	<c:set var="msg" value=""/>	
	<c:if test="${msg != null}">
		<c:out value="${'안녕하세요.' }"/>
	</c:if>
	
	<c:set var="name" value="홍길동"/>	
	<c:if test="${name == '홍길동'}">
		<c:out value="${'저는 홍길동이 맞습니다.' }"/>
	</c:if>

<form action="addStudent.do">

	<table class="table">
		<!-- 메인 속성이 파라미터  -->
	  <tr>
	    <th>학생번호</th><td><input type="text" name="sno"></td>
	  </tr>
	  
	  <tr>
	    <th>학생이름</th><td><input type="text" name="sname"></td>
	  </tr>
	  
	  <tr>
	    <th>연락처</th><td><input type="text" name="phone"></td>
	  </tr>
	  
	  <tr>
	    <th>혈액형</th><td><input type="text" name="btype"></td>
	  </tr>
	  
	   <tr>
	    <td colspan="2" align="center"><input type="submit" class="btn btn-warning" value="저장"></td> <!-- primary warning danger -->
	  </tr>
	 
	</table>
</form>
