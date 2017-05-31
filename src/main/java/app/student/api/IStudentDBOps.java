package app.student.api;

import java.util.Date;
import java.util.List;

import app.student.dto.Student;

public interface IStudentDBOps {
	// Get all rows from DB
	public List<Student> getStudentsFromDB();
	
	// Insert a new row into DB
	public boolean addStudentInDB(Student student);
	
	// Get a specific row from DB
	public Student getStudentDetailsFromDB(Integer studentId);
	
	// Update a single row based on ID in DB
	public boolean updateStudentInDB(Integer studentId, Student student);
	
	// Delete a specific row from DB
	public boolean deleteStudentByIDFromDB(Integer studentId);
}
