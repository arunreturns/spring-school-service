package app.subject.dto;

import java.util.Date;

public class Subject {
    
	private Integer subjectId;
	private String subjectName;

    

    public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

    public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

    
    @Override
	public String toString(){
		return "Subject: Subject Id: " + subjectId + "," + "Subject Name: " + subjectName;
	}

}
