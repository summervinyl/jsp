/**
 * js/reply.js
 */
// 댓글을 입력하면 li 생성.
function makeRow(reply = {}){
	let fields = ['replyNo', 'reply', 'replyer', 'replyDate'];
	//li 태그 만들기
	let li = document.createElement('li');
	fields.forEach(field => {
		let span = document.createElement('span');
		span.innerHTML = reply[field];
		
		//출력된 값에 스타일 적용
		if(field == 'reply') {
			width = '4';
		} else if(field == 'replyDate') {
			width = '3';
		} else {
			width = '2';
		}
		span.setAttribute('class', 'col-sm-' + width);
		//span.setAttribute('속성명', '값') //qualifiedName = 자격있는이름
		
		li.appendChild(span);
	});
	return li;
}


//모든 속성 복제
function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true); //똑같은 노드를 복제하여 만들 수 있는 함수
	//console.dir(template);
	template.style.display = 'block';
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	return template;
}
//cloneRow();


const listAjax = new XMLHttpRequest();
listAjax.open('get', 'replyListJson.do?bno=' + bno); //board.jsp에서 ${board.boardNo}를 담아둔 변수 갖고 오기.
listAjax.send();
//코드 정렬 간결하게 쓰기
listAjax.onload = function(){
	let data = JSON.parse(listAjax.responseText);
	console.log(data); //데이터가 배열이므로 포이치를 이용
	data.forEach(reply => {		
		//document.querySelector('div.content>ul').appendChild(makeRow(reply));
		document.querySelector('div.content>ul').appendChild(cloneRow(reply));
	})
}



//댓글 삭제 -- 삭제 버튼을 클릭하면 해당 댓글 삭제 기능 구현
function deleteRow(e){
	//버튼을 지우면 안 되고 해당 행이 삭제 되어야 한다.
	//console.log(e.target.parentElement.parentElement);
	//e.target.remove();
	
	//console.log(e.target.parentElement.parentElement.children[0]);
	let replyNo = e.target.parentElement.parentElement.children[0].innerHTML;
	console.log(replyNo);
	const delReplyAjax = new XMLHttpRequest();
	delReplyAjax.open('get', 'removeReply.do?replyNo=' + replyNo);
	delReplyAjax.send();
	delReplyAjax.onload = function(){
		let result = JSON.parse(delReplyAjax.responseText);
		if(result.return == 'success'){
			alert('삭제 성공');
			 e.target.parentElement.parentElement.remove();			
		} else {
			alert('삭제 실패');
		}
	}
}