/**
 * js/ary3.js
 */

//reduce : 배열 메소드 반복문
//배열에 들어있는 값 만큼 메소드에 정의되어있ㅎ는 함수 실행
//어떤 값이든지 만들어서 반환 가능 
//매개값이 4개 acc, ele, idx, ary
//acc 누적값 = 리턴값에 따라 acc의 값이 달라진다.
//리듀스에 의해서 만들어질 값을 초기화
let sum =
	[10, 20, 30, 40, 50].reduce(function(acc, ele, idx, ary) {
		console.log('acc : ' + acc);
		console.log('ele : ' + ele);
		//console.log('idx : ' + idx);
		//console.log('ary : ' + ary);
		return acc + ele;
	}, 0);

console.log('결과 : ' + sum);


sum = [10, 20, 30, 40, 50].reduce(function(acc, ele, idx, ary) {
		console.log('acc : ' + acc);
		console.log('ele : ' + ele);
		//console.log('idx : ' + idx);
		//console.log('ary : ' + ary);
		if (ele > 25) {
			acc.push(ele);
		}
		return acc;

	}, []);

console.log('결과 : ' + sum);

//제일 큰 값을 반환하는 결과를 출력하시오.
sum = [10, 20, 30, 40, 50].reduce(function(acc, ele, idx, ary) {
		console.log('acc : ' + acc);
		console.log('ele : ' + ele);
		//console.log('idx : ' + idx);
		//console.log('ary : ' + ary);
		if (acc > ele) {
			return acc;
		}
		return ele;
	}, 0); //acc의 초기값 = 0, 그 다음의 acc값은 현재 리턴되는 값. 즉 여기에선 ele의 값이 다음 acc의 값이 된다.

console.log('최대값 : ', sum);



//제일 작은 값을 반환하는 결과를 출력하시오.
sum = [10, 20, 30, 40, 50].reduce(function(acc, ele, idx, ary) {
		console.log('acc : ' + acc);
		console.log('ele : ' + ele);
		//console.log('idx : ' + idx);
		//console.log('ary : ' + ary);
		if (acc < ele) {
			return acc;
		}
		return ele;
	}, 100); //acc의 초기값 = 0, 그 다음의 acc값은 현재 리턴되는 값. 즉 여기에선 ele의 값이 다음 acc의 값이 된다.

console.log('최대값 : ', sum);



['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'].reduce(function(acc, ele){
	let li = document.createElement('li');
	li.innerHTML = ele;
	acc.appendChild(li);
	
	return acc;
}, document.getElementById('fruit'));
