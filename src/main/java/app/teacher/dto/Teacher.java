package app.teacher.dto;

import java.util.Date;
import java.util.List;
public class Teacher {
	private String teacherName;
	private Date dateOfBirth;
	private List<String> teacherSubjects;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public List<String> getTeacherSubjects() {
		return teacherSubjects;
	}
	public void setTeacherSubjects(List<String> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}
	
}
