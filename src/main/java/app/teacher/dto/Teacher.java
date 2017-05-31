package app.teacher.dto;

import java.util.Date;

public class Teacher {
    
	private Integer teacherId;
	private String teacherName;
	private String yearsOfExperience;
	private Date dateOfBirth;
	private Date joiningDate;

    

    public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

    public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

    public String getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

    public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

    public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

    
    @Override
	public String toString(){
		return "Teacher: Teacher Id: " + teacherId + "," + "Teacher Name: " + teacherName + "," + "Years Of Experience: " + yearsOfExperience + "," + "Date Of Birth: " + dateOfBirth + "," + "Joining Date: " + joiningDate;
	}

}
