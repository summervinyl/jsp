package co.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//검색 조건을 담아놓기 위한 클래스
//롬복 설정 - @Data : 게터 세터 toString
//@AllArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor //기본 생성자
public class SearchVO {
	private int page;
	private String searchCondition;
	private String keyword;

}
