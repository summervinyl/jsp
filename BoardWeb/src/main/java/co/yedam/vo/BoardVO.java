package co.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data //각 필드에 대해서 겟겟메소드와 toString() 자동생성
public class BoardVO {
	//VO : value object
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int clickCnt;
	private Date creationDate;
}
