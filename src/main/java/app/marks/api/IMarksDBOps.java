package app.marks.api;

import java.util.List;

import app.marks.dto.Marks;

public interface IMarksDBOps {
	public List<Marks> getMarksFromDB();
	
	public boolean updateMarksForStudentInDB(Integer markId, Marks marks);
	
	public boolean addMarksForStudentInDB(String studentName, String subjectName, Integer marks, String evaluatorName);
	
	public List<Marks> getMarksForStudentFromDB(String studentName);

	public boolean deleteMarksByIDFromDB(Integer markId);
}
