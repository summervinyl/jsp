package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//페이지 숫자버큰 클릭시
	//boardlist 클래스에서 사용
	
	//field
	private int startPage, endPage;
	// 현재 페이지 기준으로 첫 페이지와 마지막 페이지 계산
	private boolean prev, next;
	
	private int page;
	
	
	
	//constructor :: 프로젝트 때 참고 카피
	public PageDTO(int page, int totalCnt) {
		this.page = page; // ex) 첫 페이지 1page ~ 현재 페이지 4 page ~ 마지막 페이지 10page
		this.endPage = (int) (Math.ceil(page / 10.0) * 10); // 4/10.0 =1 *10= 10
		//endPage 토탈 건수에 의해서 계산됨.
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil(totalCnt / 5.0));
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		//this.endPage = 계산에 의해서 나온 페이지
		
		
		//이전 페이지 여부 체크
		this.prev = this.startPage > 1;
//		this.next = this.endPage < realEnd;
		this.next = this.endPage == realEnd ? false : true;
	}
}
