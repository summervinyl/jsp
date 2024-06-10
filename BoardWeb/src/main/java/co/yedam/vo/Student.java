package co.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
//lombok으로 인해 게터세터 자동 생성

public class Student {
	private String stdNo; // STDNO stdno
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;
}