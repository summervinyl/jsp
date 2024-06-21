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

let searchList = document.getElementById('searchList');		
const target = document.querySelector('#centerList'); //하위 목록
// 화살표 함수로 간략하게
//리소스 요청 결과를 받아오면 then메소드의 매개변수에 결과값(json 문자열을 파싱해서)이 담긴다.
fetch(url)
	.then(result => result.json()) // 문자열 [{"id:"1, "center:"...}] -> [{}, {}]
	.then(result => {
		//console.log(result.data);
		let sidos = [];
		result.data.forEach(center => {
			target.appendChild(makeRow(center));

			if(sidos.indexOf(center.sido) == -1){
				console.log(sidos);
				sidos.push(center.sido);
				let option = document.createElement('option');
				option.setAttribute("value", center.sido);
				option.innerHTML = center.sido;
				searchList.appendChild(option);
			}
		});
	});

//3) sido 정보에서 중복된 값을 제거해서 위 option 태그를 생성하고 검색하기
document.getElementById('searchList').addEventListener('change', searchFnc2);
function searchFnc2(){

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
	let tr = document.createElement('tr');
	target.appendChild(tr);
	
	feilds.forEach(feild => {
		let td = document.createElement('td');
		td.innerHTML = center[feild];
		tr.appendChild(td);
	});
	return tr;

} // end of makeRow().
	