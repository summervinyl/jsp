package co.yedam;

import java.util.Date;

public class Student {
	//객체 생성 클래스
	
	//필드
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;
		
	
	//필드의 객체가 private이므로 getter, setter가 값 통로 역할을 해줌.
	//겟 셋 메소드 : get-외부로 값을 전달, set-내부
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBldType() {
		return bldType;
	}
	public void setBldType(String bldType) {
		this.bldType = bldType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}	
	
	//toString 오버라이딩
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", phone=" + phone + ", bldType=" + bldType
				+ ", createDate=" + createDate + "]";
	}	

}
