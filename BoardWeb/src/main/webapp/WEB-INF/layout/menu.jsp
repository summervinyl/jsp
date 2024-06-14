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
          </c:when>
          <c:otherwise>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addForm.do">게시글 등록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">logout</a>
          </c:otherwise>
        </c:choose>
        
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="studentForm.do">student insert</a>
        
    </div>
</div>