/**
 * //reply(댓글관련 기능(목록, 단건조회, 등록, 삭제) 모아두기)
 */

 const svc = {
	//목록. = 원본글번호를 매개값으로 받기 =1은 안써도 되지만 // successCall = 매가값이 함수
	//replyListFnc의 함수를 매개값으로 받아서 successCall자리에 들어가서 실행된다.
	//콜백함수 = 나중에 정의해서 쓰겠다.
	replyList(bno = 1, successCall){
		const xhr = new XMLHttpRequest();
		xhr.open('get', 'replyListJson.do?bno=' + bno);
		xhr.send();
		xhr.onload = successCall;
	},
	
	//단건조회
	getReply(){

	},
	//등록 : 객체로 파라미터 전달
	addReply(rvo = {bno, reply, replyer}, successCall){
		const xhr = new XMLHttpRequest();
		xhr.open('post', 'addReply.do'); //get : 데이터 전달되는 양 한계가 있다. 그래서 post로 바꾸자. <header>
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); //키와 밸류가 쌍으로 전달/파일인지 텍스트인지
		//xhr.send('키=' + 밸류 + '&키=' + 밸류 + '&replyer=' + replyer);
		xhr.send('bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer); //<body> 
		xhr.onload = successCall;
	},
	
	//삭제
	removeReply(rno = 1, successCall){
		const xhr = new XMLHttpRequest();
		xhr.open('get', 'removeReply.do?rno=' + rno);
		xhr.send();
		xhr.onload = successCall;
	}
	
 }