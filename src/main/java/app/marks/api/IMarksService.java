package app.marks.api;

import java.util.List;

import app.marks.dto.Marks;

public interface IMarksService {
	public List<Marks> getMarks();
	
	public boolean updateMarksForStudent(Marks studentMarks);
	
	public boolean addMarksForStudent(Marks studentMarks);
	
	public List<Marks> getMarksForStudent(String studentName);
}
