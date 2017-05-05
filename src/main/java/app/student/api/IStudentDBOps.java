package app.student.api;

import java.util.Date;
import java.util.List;

import app.student.dto.Student;

public interface IStudentDBOps {
	public List<Student> getStudentsFromDB();
	
	public List<Student> getStudentsByNameFromDB(String studentName);
	
	public boolean updateStudentInDB(Integer studentId, Student student);
	
	public boolean addStudentInDB(String studentName, Date dateOfBirth, String studentClass);
	
	public Student getStudentDetailsFromDB(Integer studentId);

	public boolean deleteStudentByIDFromDB(Integer studentId);
}
