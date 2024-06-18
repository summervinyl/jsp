/**
 * data.js 
 */
//JS 배열 선언 ---  or new Array[]
const myMembers = [
	{id: 'user01', name: '홍길동', phone:'010-0000-0000', point: 90}, //배열 객체 or new Object()
	{id: 'user02', name: '정도전', phone:'010-0000-0000', point: 97},
	{id: 'user03', name: '이성계', phone:'010-0000-0000', point: 91}	
];


//json 문자열
const json = `[{"id":1,"first_name":"Aguistin","last_name":"Simkovich","email":"asimkovich0@tripod.com","gender":"Male","salary":3921},
{"id":2,"first_name":"Gottfried","last_name":"Damarell","email":"gdamarell1@time.com","gender":"Male","salary":4913},
{"id":3,"first_name":"Debbie","last_name":"Lemm","email":"dlemm2@i2i.jp","gender":"Female","salary":4431},
{"id":4,"first_name":"Kendall","last_name":"Calvey","email":"kcalvey3@dailymail.co.uk","gender":"Male","salary":6707},
{"id":5,"first_name":"Mahalia","last_name":"Joutapaitis","email":"mjoutapaitis4@princeton.edu","gender":"Female","salary":7264},
{"id":6,"first_name":"Brittani","last_name":"Swadlen","email":"bswadlen5@hatena.ne.jp","gender":"Female","salary":5357},
{"id":7,"first_name":"Perren","last_name":"Keays","email":"pkeays6@cbsnews.com","gender":"Male","salary":4460},
{"id":8,"first_name":"Kevyn","last_name":"Haggett","email":"khaggett7@etsy.com","gender":"Female","salary":6868},
{"id":9,"first_name":"Caye","last_name":"Olivia","email":"colivia8@rambler.ru","gender":"Female","salary":6921},
{"id":10,"first_name":"Jervis","last_name":"Charon","email":"jcharon9@lulu.com","gender":"Male","salary":3478},
{"id":11,"first_name":"Towny","last_name":"Baylie","email":"tbayliea@mlb.com","gender":"Male","salary":4519},
{"id":12,"first_name":"Garrott","last_name":"Canfield","email":"gcanfieldb@webnode.com","gender":"Male","salary":6249},
{"id":13,"first_name":"Hyman","last_name":"Capnor","email":"hcapnorc@sohu.com","gender":"Male","salary":3058},
{"id":14,"first_name":"Jo","last_name":"Calleja","email":"jcallejad@vistaprint.com","gender":"Female","salary":4860},
{"id":15,"first_name":"Graeme","last_name":"Worsell","email":"gworselle@mediafire.com","gender":"Male","salary":4120}]`;

//json 문자열을 
const employees = JSON.parse(json);