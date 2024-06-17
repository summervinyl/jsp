/**
 * 
 */

	//요소 생성 삭제 수정 스타일 지정 가능
  //DOM 연습.
  /* document.querySelector('ul#fruit>li').innerHTML = '사과'; */
  document.querySelector('#fruit>li').innerHTML = '사과';
  
  //LI 요소 생성
  let li = document.createElement('li');
  //innerText or innerHTML ,
  li.innerHTML = '<b>오렌지</b>'; //<li><b>오렌지</b></li>
  //li를 자식요소로 붙이겠다.
  document.querySelector('ul#fruit').appendChild(li);
 
  
 
  //삭제
  document.querySelector('#fruit>li').remove();
  document.querySelector('#fruit>li').style.background = 'yellow';
  document.querySelector('#fruit>li').style.color = 'blue';

  
  //잘 모르겠으면 console에 찍어보기.
  console.log(document.querySelectorAll('#fruit>li'));
  //반복문 사용해서 버튼 적용해주기.
  let lists = document.querySelectorAll('#fruit>li');
  for(let list of lists){
	  //list = li
	  console.log(list);
	  //dom을 활용해서 버튼 태그 만들기
	  let btn = document.createElement('button');
	  btn.innerText = '삭제';
	  
	  //속성 지정 = 어트리뷰트 등록 - 스타일 아이디
	  //btn.setAttribute('class', 'btn'); //클래스 이름을 btn으로 설정
	  btn.setAttribute('class', 'btn btn-primary'); //클래스 이름을 btn으로 설정
	  
	  //버튼에 이벤트 생성
	  btn.addEventListener('click', function(){
		  //btn.remove(); //버튼 자기 자신이 삭제
		  btn.parentElement.remove(); //부모요소 삭제		  
	  }); //이벤트유형, 실행코드(함수형태로) (클릭하면, 실행할 함수)
	  list.appendChild(btn);
  }