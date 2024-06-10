<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 String id = request.getParameter("id");// "user01";
	 String pw = request.getParameter("pw");// "1234";
	%>
	
	<p>아이디는 <%=id%></p> 
	<p>비밀번호는 <%=pw%></p>
	<a href="../index.html">첫 페이지로 이동</a>
</body>
</html>