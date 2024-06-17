<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- script/js.jsp -->
<h3>자바스크립트 연습 페이지</h3>

<ul id="fruit">
  <li> apple </li>
  <li> banana </li>
</ul>

<!-- 자바스크립트로 편집할 거라서 form 없음 -->
<table class="table">
   <tr>
      <th>회원아이디</th><td><input id="mid"></td>
   </tr>
   <tr>
      <th>회원이름</th><td><input id="mname"></td>   
   </tr>
   <tr>
      <th>회원연락처</th><td><input id="mphone"></td>   
   </tr>
   <tr>
      <th>회원점수</th><td><input id="mpoint"></td>   
   </tr>
   <tr>
      <td colspan="2">
      <button id="addBtn">추가 </button>
      <button id="modBtn">수정</button>
      <button id="delBtn">선택삭제</button>
      </td>   
   </tr>
</table>

<!-- 목록 보여주기 -->
<table class="table">
  <thead>
	 <tr>
	    <th>아이디</th>
	    <th>이름</th>
	    <th>연락처</th>
	    <th>포인트</th>
	    <th>삭제</th>
	    <th><input type="checkbox"></th>
	 </tr>
  </thead>
  <tbody id="memberList"></tbody>
</table>

<script src="js/data.js">
</script>
<script src="js/dom1.js">
</script>