/**
 * js/ary.js
 * forEach, filter, map, reduce
 */
//배열선언
const numAry = [23, 17, 5, 41, 30, 12];
//forEach=메소드 / 매개값은 함수

let result = 0;

numAry.forEach(function(ele, idx, ary) {
	console.log(`요소: ${ele} 인덱스: ${idx} 배열: ${ary}`);
	if (ele % 2 == 0) {
		result += ele;
	}
});
console.log('짝수합: ' + result);

let evenSum = function(ele, idx, ary) {
	if (ele % 2 == 0) {		
		result += ele;
	}
}
result = 0;
numAry.forEach(evenSum)
console.log('짝수: ' + result);

let oddSum = function(ele, idx, ary) {
	if (idx % 2 == 0) { //인덱스 나눈 값 홀수
		result += ele;
	}
}
result = 0;
numAry.forEach(oddSum);
console.log('홀수: ' + result);
//console.log('35보다 작은 값들의 합: ' + numAry.forEach(less35));

//35보다 작은 값들의 합을 저장
/*let less35 = function(ele, idx, ary){
	if(ele < 35){
		result += ele;
	}
}*/

const dupAry = [10, 27, 32, 55, 27, 10];
//중복된 값은 제거하고, 나머지 값을 ary배열에 담기
//indexOf() 있으면 값을, 없으면 -1을 반환
const ary = [];
dupAry.forEach(function(ele) {
	if (ary.indexOf(ele) == -1) {
		ary.push(ele);
	}
});
console.log(ary);