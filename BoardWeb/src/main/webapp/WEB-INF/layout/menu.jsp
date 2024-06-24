<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
    <div class="list-group list-group-flush">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">main</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글 목록</a>
        
        <c:choose>
          <c:when test="${empty loginID }">
	        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">login</a>
	        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signupForm.do">sign up</a>
          </c:when>
          <c:otherwise>
	        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">게시글 등록</a>
	        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">logout</a>
	        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="deleteAccout.do">delete account</a>
          </c:otherwise>
        </c:choose>
        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="script.do">java script</a>
        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="ajax.do">Ajax 연습</a>
        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="publicData.do">공공데이터포털</a>
        	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="chartForm.do">센터 차트</a>
    </div>
</div>