<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../public/header.jsp" />

<div align="center">
	<!-- webapp/WEB-INF/view/product.jsp -->
	<h2 style="color: navy;"><br>PRODUCT PAGE</h2><br>
	
	<table border="1">
		<tr>
			<th>학생번호</th><td> ${student.stdNo}</td>		
		</tr>
		<tr>
			<th>학생이름</th><td> ${student.stdName}</td>		
		</tr>
		<tr>
			<th>연락처</th><td> ${student.phone}</td>		
		</tr>	
		<tr>
			<th>혈액형</th><td> ${student.bldType}</td>
		</tr>	
	</table>
	
	<a href="main.do" style="text-decoration: none; color:blue;"><br>목록 보기</a>
</div>
<jsp:include page="../public/footer.jsp"/> 