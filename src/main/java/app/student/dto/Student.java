package app.student.dto;

import java.util.Date;

public class Student {
    
	private Integer studentId;
	private String studentName;
	private String studentClass;
	private String studentEmail;
	private String parentEmail;
	private Date dateOfBirth;

    public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

    public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

    public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

    public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

    public String getParentEmail() {
		return parentEmail;
	}
	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

    public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

    
    @Override
	public String toString(){
		return "Student: Student Id: " + studentId + "," + "Student Name: " + studentName + "," + "Student Class: " + studentClass + "," + "Student Email: " + studentEmail + "," + "Parent Email: " + parentEmail + "," + "Date Of Birth: " + dateOfBirth;
	}

}
