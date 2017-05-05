package app.marks.api;

import java.util.List;

import app.marks.dto.Marks;

public interface IMarksService {
	public List<Marks> getMarksService();
	
	public boolean addMarksForStudentService(Marks studentMarks);
	
	public List<Marks> getMarksForStudentService(String studentName);

	public boolean updateMarksForStudentService(Integer markId, Marks studentMarks);

	public boolean deleteMarksByIDService(Integer markId);
}
