package com.student;

public class StudentInfo {
	private String rollNo;
	private String stu_name;
	private String stu_email;
	private String year;
	private String degree;
	private String department;
	private String dob;
	private String age;
	private String address;
	private String mobileNum;
	private String bloodgroup;
	public StudentInfo()
	{
		
	}
	
	public StudentInfo( String stu_name, String stu_email, String year, String degree, String department,
			String dob,String address, String mobileNum, String bloodgroup) {
		super();
		//this.rollNo = rollNo;
		this.stu_name = stu_name;
		this.stu_email = stu_email;
		this.year = year;
		this.degree = degree;
		this.department = department;
		this.dob = dob;
		//this.age = age;
		this.address = address;
		this.mobileNum = mobileNum;
		this.bloodgroup = bloodgroup;
	}
	@Override
	public String toString() {
		return "StudentInfo [rollNo=" + rollNo + ", stu_name=" + stu_name + ", stu_email=" + stu_email + ", year="
				+ year + ", degree=" + degree + ", department=" + department + ", dob=" + dob + ", age=" + age
				+ ", address=" + address + ", mobileNum=" + mobileNum + ", bloodgroup=" + bloodgroup + "]";
	}

	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	
	
	
	

}
