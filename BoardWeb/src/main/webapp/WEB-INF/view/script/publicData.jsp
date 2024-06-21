<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
<h3>공공 데이터 연습 (public data)</h3>

<!-- sido 정보에서 중복된 값을 제거해서 위 option 태그를 생성하고 검색하기 -->
시도 검색:
<select id="searchList">
    <!-- <option value="서울특별시">서울특별시</option>
    <option value="인천광역시">인천광역시</option>
    <option value="대전광역시">대전광역시</option> -->
</select>

<!-- 검색 조건 입력하고 목록에서 출력. -->
주소 검색: <input type="text" id="search" class="col-sm-6" placeholder="ex)'동구'입력하고 검색하면 동구를 포함한 목록이 출력">
<button id="findBtn">검색</button>


<table class="table">
    <thead>
        <tr>
            <th>센터ID</th>
            <th>센터명</th>
            <th>연락처</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody id="centerList"></tbody>
</table>



<script src="js/public.js"></script>