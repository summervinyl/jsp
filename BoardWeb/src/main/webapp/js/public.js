/**
 * public.js
 */
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=W57adSxenoWiqpp%2BidzcUElFRHagkx%2FqmE96lKYfQRfYT%2BxTsYwbql1JVxiQP3QjmEGzjbIAL%2FDrttFlChwXJw%3D%3D';
/*const xhr = new XMLHttpRequest();
xhr.open('get', url);
xhr.send();
xhr.onload = function(){
	let data = JSON.parse(xhr.responseText);
	console.log(data);
	}*/
	
	//url==리소스 요청 결과를 받아오면 then메소드의 매개변수에 결과값(json 문자열을 파싱해서)이 담긴다. 
	/*fetch(url)
	.then(function(result){ //ten 메소드 함수 실행 매개값은 url
	return result.json(); //url을 json 문자열로 파싱해서 반환
	}) //then 
	.then(function(result){
		console.log(result.data);
		})*/
		
		
//센터 차트 만들기
/*fetch(url)
	.then(result => result.json())
	.then(result => {
		
	})*/
	

		

//센터 DB 정보 생성하기 (get과 post)
document.getElementById('centerDB').addEventListener('click', createCenterInfo);
function createCenterInfo(){
	// 1. OpenAPI 호출해서 데이터 fetch로 받아오기 (xml or json)
	// 2. 컨트롤 호출 DB 입력
	fetch(url)
		.then(result => result.json()) // ten의 매개값은 함수, 함수의 매개값은 result=url -> 즉, url에 있는 데이터를 json 뮨자열로 변환
		.then(result => {
			//console.log(result);
			let centers = result.data; // [{}, {}, {}] => [{"id":"hong"}]
			return fetch('uploadCenter.do', {  //문자열 값을 DB에 전달 -- uploadCenter.do:옵션객체에 전달
				method: 'post', //전달되는 값이 body영역에 저장. get은 헤드에 들어가기 때문에 인코딩이 필요없음.
				headers: { 'Content-Type' : "application/json" }, //키=값&키=값
				//Content-Type : Http 통신에서 전송되는 데이터의 타입을 명시하기 위해 header에 실리는 정보. 즉, api 요청 시 request에 실어 보내는 데이터(body)의 타입 정보다. -> application:지원
				body: JSON.stringify(centers) //stringify안에 자바스크립트 객체를 넣어주면 json 문자열로 변환
				//stringify : 문자열화하다, JSON.stringify : 자바스크립트의 값을 JSON 문자열로 변환
			});

		})
		.then(result => result.json()) //{"txtCnt" : 2} 이런식으로 넘겨줌
		.then(result => {
			if (result.txtCnt > 0) {
				alert(result.txtCnt + '건 처리 성공');
			} else {
				alert('실패');				
			}			
		})
		.catch(err => console.log(err));
}


let searchList = document.getElementById('searchList');		
const target = document.querySelector('#centerList'); //하위 목록
// 화살표 함수로 간략하게
//리소스 요청 결과를 받아오면 then메소드의 매개변수에 결과값(json 문자열을 파싱해서)이 담긴다.
fetch(url) //promise 객체로 반환
	.then(result => result.json()) // 문자열 [{"id":"1", "center":...}] -> [{}, {}]
	//result.json()) = 페치가 반환해주는 데이터를 json 문자열로 변환해서 반환
	.then(result => {
		let sidos = [];
		result.data.forEach(center => { //result.datad를 순회한다, result.data의 요소 중에 center를 갖고 온다.
			target.appendChild(makeRow(center));
			console.log(center);
			if(sidos.indexOf(center.sido) == -1){
				//console.log(sidos);
				sidos.push(center.sido);
				let option = document.createElement('option');
				option.setAttribute("value", center.sido);
				option.innerHTML = center.sido;
				searchList.appendChild(option);
			}
		});
	})
	.catch(err => console.log(err)); //예외 발생시 에러 메세지 출력


//3) change event
document.getElementById('searchList').addEventListener('change', searchFnc2);
function searchFnc2(){
	let searchValue = document.getElementById('searchList').value;
	fetch(url)
		.then(result => result.json()) // 문자열 [{"id:"1, "center:"...}] -> [{}, {}]
		.then(result => {
			target.innerHTML = '';
			result.data.forEach(center => {				
				if(center.sido.indexOf(searchValue) != -1){ //indexOf, search
					target.appendChild(makeRow(center));
					//searchValue.style('color', 'red');
				}
			});
		});
}


//2) 주소 검색 기능
document.getElementById('findBtn').addEventListener('click', searchFnc);

function searchFnc(){
	let searchValue = document.getElementById('search').value;
	fetch(url)
		.then(result => result.json()) // 문자열 [{"id:"1, "center:"...}] -> [{}, {}]
		.then(result => {
			target.innerHTML = '';
			result.data.forEach(center => {				
				if(center.address.indexOf(searchValue) != -1){ //indexOf, search
					target.appendChild(makeRow(center));
					//searchValue.styr('color', 'red');
				}
			});
		});
		// document.getElementById('search').value = ''; // 검색 후 검색 창에 값 삭제
}


//1) 목록 출력
const feilds = ['id', 'centerName', 'phoneNumber', 'address']; //실제 데이터값과 이름이 같아야 한다.

function makeRow(center = {}){
	//console.log(center.lat);
	let tr = document.createElement('tr');
	//tr에 클릭 이벤트 등록 : 지도 보여주기
	//console.log(tr, "현재 tr");	
	tr.addEventListener('click', function(){
		//location.href = "map.do?x=" + center.lat + "&y=" + center.lng;
		//window.open("map.do?x=" + center.lat + "&y=" + center.lng + "&name=" + center.centerName);
		window.open("map.do?x=" + center.lat + "&y=" + center.lng + "&name=" + center.centerName.replace('코로나19', ''));
	});
	target.appendChild(tr);
	
	feilds.forEach(feild => {
		let td = document.createElement('td');
		td.innerHTML = center[feild];
		tr.appendChild(td);
	});
	return tr;

} // end of makeRow().
	