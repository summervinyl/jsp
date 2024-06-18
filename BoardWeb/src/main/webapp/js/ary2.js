/**
 * js/ary2.js
 */
//filter 메소드에 정의되어있는 함수 실행
//처리된 결과 값을 새로운 배열에 담아주는 기능
//형태는 똑같지만 결과만 다름(필터링되이ㅓ서) = [A, A, A] -> [A, A]
//forEach는 리턴 값이 없음

let result = [23, 45, 22, 39, 10, 56].filter(function(ele, idx, ary){
	//짝수 값만 필터링해서 담기
	if(ele % 2 == 0){
		return true; //반대로 하고 싶다면 - return false;
	}
	//return true;
});
console.log(result);


//샘플데이터 - mockaroo
//안 되면 새로고침 꾹 누르면 강력 새로고침 : ctrl + shift + r
//console.log(employees);
//employees.forEach(console.log);

//급여가 5000이 넘는 여자만 필터링
let s5000 = employees.filter(function(ele){	
	if(ele.salary > 5000 && ele.gender == 'Female'){
		return true;
	}	
});
console.log(s5000);

//간략히
let salary5000 = [];
salary5000 = employees.filter(ele => ele.salary > 5000);
console.log(salary5000);


let s5000fe = [];
let filterFnc = emp => emp.salary > 5000 && emp.gender == 'Female';
filterFnc = function(emp){
	return emp.salary > 5000 && emp.gender == 'Female';
}

let over500sum = 0;
employees.filter(filterFnc).forEach(function(emp){
	over500sum += emp.salary;
});
console.log('500이 넘은 급여의 합 : ' + over500sum);


//map메소드 = 매개값으로 함수
//개수는 그대로지만 형태만 바뀜
//[A, A, A] -> [A', A', A']
employees.map(function(ele, idx, ary){
	const obj = {}
	obj.name = ele.first_name + '-' + ele.lsat_name;
	obj.no = ele.id;
	obj.salary = ele.salary;
	return obj;
}).forEach(console.log);
