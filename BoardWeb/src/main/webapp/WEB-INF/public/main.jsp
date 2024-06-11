<%@page import="java.util.List"%>
<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="header.jsp" %>

	<h3>main 페이지</h3>
	
	<!-- 자바 코드 사용  -->
	<%
	 /* request.getAttribute("student"); //getAttribute 반환타입이 스트링 */
	 Student student = (Student) request.getAttribute("student"); //getAttribute 반환타입이 스트링 - 캐스팅 해주기
	 //import = ctrl+space해서 객체 찾고 클릭.
	 List<Student> list = (List<Student>) request.getAttribute("studentList");
	%>
	
	<p>학생번호 : <%=student.getStdNo()%></p>
	<p>학생이름 : <%=student.getStdName()%></p>
	<p>번호 : <%=student.getPhone()%></p>
	
	
	<!-- 반복문을 이용해 학생 목록 출력 -->
	<h3>학생목록</h3>
	<ul>
	<%for(Student std : list) {%>
	<!-- <span style=list</span> -->
		 <li> 학번: <%=std.getStdNo()%> 
		 이름: <a href="product.do?stdNo=<%=std.getStdNo()%>"> <%=std.getStdName()%></a>
		 연락처: <%=std.getPhone()%> </li>
		 <!-- html의 a 태그를 이용해서 원하는 주소입력 -->
	<%}%>
	</ul>

<%@include file="footer.jsp" %>