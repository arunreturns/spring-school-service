package app.dto;

import java.util.Date;

public class Classroom {
    
	private Integer classroomId;
	private String classroomName;
	private String teacherInCharge;
	private Integer studentsInClass;
	
	public Classroom(){
		
	}

	public Classroom(Integer classroomId, String classroomName, String teacherInCharge, Integer studentsInClass){
		this.classroomId = classroomId;
		this.classroomName = classroomName;
		this.teacherInCharge = teacherInCharge;
		this.studentsInClass = studentsInClass;
	}

    public Integer getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

    public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

    public String getTeacherInCharge() {
		return teacherInCharge;
	}
	public void setTeacherInCharge(String teacherInCharge) {
		this.teacherInCharge = teacherInCharge;
	}

    public Integer getStudentsInClass() {
		return studentsInClass;
	}
	public void setStudentsInClass(Integer studentsInClass) {
		this.studentsInClass = studentsInClass;
	}

    
	public String toString(){
		return "Classroom: Classroom Id: " + classroomId + "," + "Classroom Name: " + classroomName + "," + "Teacher In Charge: " + teacherInCharge + "," + "Students In Class: " + studentsInClass;
	}

}
