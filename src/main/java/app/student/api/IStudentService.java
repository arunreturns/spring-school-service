package app.student.api;

import java.util.List;

import app.student.dto.Student;

public interface IStudentService {
	// Returns all the rows from DB as a List
	public List<Student> getStudentService();
	
	// Add a single student into DB
	public boolean addStudentService(Student student);
	
	// Returns a single Student entity from DB
	public Student getStudentDetailsService(Integer studentId);

	// Updates a single Student entity in DB
	public boolean updateStudentByIDService(Integer studentId, Student student);

	// Deletes a single Student entity in DB
	public boolean deleteStudentByIDService(Integer markId);
}
