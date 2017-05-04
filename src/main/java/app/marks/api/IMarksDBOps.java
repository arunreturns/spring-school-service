package app.marks.api;

import java.util.List;

import app.marks.dto.Marks;

public interface IMarksDBOps {
	public List<Marks> getMarksFromDB();
	
	public boolean updateMarksForStudent(String studentName, String subjectName, Integer marks);
	
	public boolean addMarksForStudent(String studentName, String subjectName, Integer marks, String evaluatorName);
	
	public List<Marks> getMarksForStudent(String studentName);
}
