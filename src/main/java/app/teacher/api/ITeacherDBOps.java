package app.teacher.api;

import java.util.Date;
import java.util.List;

import app.teacher.dto.Teacher;

public interface ITeacherDBOps {
	// Get all rows from DB
	public List<Teacher> getTeachersFromDB();
	
	// Insert a new row into DB
	public boolean addTeacherInDB(Teacher teacher);
	
	// Get a specific row from DB
	public Teacher getTeacherDetailsFromDB(Integer teacherId);
	
	// Update a single row based on ID in DB
	public boolean updateTeacherInDB(Integer teacherId, Teacher teacher);
	
	// Delete a specific row from DB
	public boolean deleteTeacherByIDFromDB(Integer teacherId);
}
