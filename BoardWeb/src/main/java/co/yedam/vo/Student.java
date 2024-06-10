package co.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data

public class Student {
	private String stdNo; // STDNO stdno
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;
}