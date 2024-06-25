<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ajax.jsp -->
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 0;
	border: 1px solid #888;
	width: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}

/* Add Animation */
@
-webkit-keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.close {
	color: white;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

.modal-body {
	padding: 2px 16px;
}

.modal-footer {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}
</style>

<h3>ajax 연습</h3>
<div id="register">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" id="uid"></td>
		</tr>

		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="upw"></td>
		</tr>

		<tr>
			<th>이름</th>
			<td><input type="text" id="uname"></td>
		</tr>

		<tr>
			<th>권한</th>
			<td><select id="auth">
					<option value="User">사용자</option>
					<option value="Admin">관리자</option>
			</select></td>
		</tr>
		
		<tr>
			<th>파일</th><td><input class="form-control" type="file" id="myPic"></td> <!-- onchange="console.log(event)" 사진을 선택했을 때 정보보기-->
		</tr>
		
		<tr align="center">
			<td colspan="2"><button id="addBtn" class="btn btn-primary">등록</button></td>
		</tr>


		<!-- 		<tr>
			<td><button id="delBtn">삭제</button></td>
		</tr> -->
	</table>
</div>


<div id="show">
	<table class="table">

		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<!-- 				<th>이메일</th>
				<th>급여</th> -->
				<th>비밀번호</th>
				<th>권한</th>
				<th style="color: red;">삭제</th>
			</tr>
		</thead>

		<tbody id="list"></tbody>

	</table>
</div>

<!-- modal창. -->
<div id="myModal" class="modal">

	<!-- Modal content -->
	<div class="modal-content">
		<div class="modal-header">
			<span class="close">&times;</span> <!-- &times:X 닫기버튼  -->
			<h2>사용자 정보 수정</h2>
		</div>
		<div class="modal-body">
			<input type="hidden" id="modify_id">
			<p>변경할 이름: <input type="text" id="modify_name"></p>
			<p>변경할 비밀번호: <input type="text" id="modify_pass"></p>
			<p><button id="modBtn">수정</button></p>
		</div>
		<div class="modal-footer">
			<h3>Modal Footer</h3>
		</div>
	</div>

</div>

<!-- modal 창 열고 닫기 -->
<script>
	// Get the modal
	var modal = document.getElementById("myModal");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	// 밖을 눌러도 닫혀지는 기능
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>

<script src="js/ajax3.js"></script>