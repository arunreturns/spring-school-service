package app.teacher.api;

import java.util.List;

import app.teacher.dto.Teacher;

public interface ITeacherService {
	// Returns all the rows from DB as a List
	public List<Teacher> getTeacherService();
	
	// Add a single teacher into DB
	public boolean addTeacherService(Teacher teacher);
	
	// Returns a single Teacher entity from DB
	public Teacher getTeacherDetailsService(Integer teacherId);

	// Updates a single Teacher entity in DB
	public boolean updateTeacherByIDService(Integer teacherId, Teacher teacher);

	// Deletes a single Teacher entity in DB
	public boolean deleteTeacherByIDService(Integer markId);
}
