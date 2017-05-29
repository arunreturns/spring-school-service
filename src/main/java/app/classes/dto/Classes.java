package app.classes.dto;

public class Classes {
	private Integer classId;
	private String className;
	private String teacherInCharge;
	private Integer studentsInClass;
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
}
