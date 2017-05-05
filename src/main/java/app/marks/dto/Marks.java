package app.marks.dto;

public class Marks {
	private String markId;
	private String studentName;
	private String subjectName;
	private Integer mark;
	private String evaluatorName;
	
	public String getMarkId() {
		return markId;
	}
	public void setMarkId(String markId) {
		this.markId = markId;
	}
	public String getEvaluatorName() {
		return evaluatorName;
	}
	public void setEvaluatorName(String evaluatorName) {
		this.evaluatorName = evaluatorName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}
