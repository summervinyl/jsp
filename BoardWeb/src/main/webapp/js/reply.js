/**
 * 진짜 reply.js
 */

 //▶ 목록 가져오기 ◀
 //매가값을 2개 넘겨줘야 된다. bno, successCall 함수
 // 01. 익명함수로 구현
/* svc.replyList(bno, function(){ //익명함수
	//console.log(this); // = XMLHttpRequest
	console.log(this.responseText); //
	let data = JSON.parse(this.responseText);
	
 });*/
 
 // 02. 함수명으로 구현 
 svc.replyList(bno, replyListFnc);
 //replyList의 매개값으로 사용될 함수
 function replyListFnc(){
	let data = JSON.parse(this.responseText);
	console.log(data); //배열형태
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
	
 } 
 
 // 댓글 정보로 li 생성
 function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true); //똑같은 노드를 복제하여 만들 수 있는 함수
	//console.dir(template);
	template.style.display = 'block';
	
	//rno
	template.setAttribute('id', reply.replyNo);
	
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	return template;
}


//▶ 삭제 : 삭제 버튼을 클릭하면 해당 댓글 삭제 기능 구현 ◀
function deleteRow(e){
	let li = e.target.parentElement.parentElement;
	let rno = li.getAttribute('id');
	
	svc.removeReply(rno, deleteReplyFnc);
	//removeReply 메소드의 매개값으로 전달될 함수 : 화면에서 댓글 한 건 지우기. 
	function deleteReplyFnc(){
		console.log(this);
		let result = JSON.parse(this.responseText);
		if(result.retCode == 'OK'){
			alert('삭제 성공');
			//document.getElementById(rno).remove();
			li.remove();
		} else {
			alert('삭제 실패' + result.retMsg);
		}		
	}	
} // end of deleteRow().


//▶ 댓글 등록 이벤트 ◀
document.getElementById('addReply').addEventListener('click', addReplyFnc);
// 버튼이 눌려지면 실행되는 함수
function addReplyFnc(){
	//로긴 안 하면 댓글 등록 못함
	console.log('replyer=' + replyer);
	if(!replyer){
		alert('로그인하세요.');
		return; //종료
	}
	//로그인한 사람만 댓글 달 수 있게 하기.
	let reply = document.getElementById('reply').value;
	//svc.addReply({replyer:replyer, reply:reply, bno:bno}, addReplyCallback); //속성과 변수의 값이 같으면 줄일 수 있다.
	svc.addReply({replyer, reply, bno}, addReplyCallback);
}

function addReplyCallback(){
	console.log(this.responseText);
	//화면에 있는 댓글정보목록에 추가.
	let result = JSON.parse(this.responseText);
	if(result.retCode == 'OK'){
		alert('등록 성공');
		let li = cloneRow(result.retVal);
		document.querySelector('div.content>ul').appendChild(li);
		document.getElementById('reply').value = ''; //입력후 댓글 입력란 공백으로 초기화
	} else {
		alert('등록 실패' + result.retval);
	}
} // end of addReplyCallback().