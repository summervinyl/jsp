package co.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo;
	private String reply;
	private String replyer;
	private Date replyDate;
	private int boardNo;

}
