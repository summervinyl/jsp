<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 첫페이지입니다.</title>
</head>
<body>
  <!-- 액션태그:어떠한기능이있는태크 -->
  <!-- jsp기본적으로 제공해주는 action태그 -->
  <jsp:forward page="main.do"></jsp:forward>
  <!-- 요청페이지 재지정 -->
  
  <h3>Hello, World!!</h3>
  <a href="public/main.jsp">main 페이지로 이동</a>
</body>
</html>