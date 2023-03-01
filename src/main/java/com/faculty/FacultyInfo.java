package com.faculty;

public class FacultyInfo {
	private String facultyId;
	private String f_name;
	private String f_email;
	private String dob;
	private String address;
	private String bloodgroup;
	//private String degree;
	private String course;
	private String yearJoin;
	private String mobileNum;
	private String designation;
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public FacultyInfo(String f_name, String f_email, String dob, String address, String bloodgroup,
			String designation,String course, String yearJoin,String mobileNum) {
		super();
		this.f_name = f_name;
		this.f_email = f_email;
		this.dob = dob;
		this.address = address;
		this.bloodgroup = bloodgroup;
		//this.degree = degree;
		this.course = course;
		this.yearJoin = yearJoin;
		this.mobileNum = mobileNum;
		this.designation = designation;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_email() {
		return f_email;
	}
	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
//	public String getDegree() {
//		return degree;
//	}
//	public void setDegree(String degree) {
//		this.degree = degree;
//	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getYearJoin() {
		return yearJoin;
	}
	public void setYearJoin(String yearJoin) {
		this.yearJoin = yearJoin;
	}
	@Override
	public String toString() {
		return "FacultyInfo [facultyId=" + facultyId + ", f_name=" + f_name + ", f_email=" + f_email + ", dob=" + dob
				+ ", address=" + address + ", bloodgroup=" + bloodgroup + ", course=" + course
				+ ", yearJoin=" + yearJoin + "]";
	}
	
  
}
