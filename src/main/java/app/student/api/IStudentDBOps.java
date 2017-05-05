package app.student.api;

import java.util.List;
import java.util.Date;

import app.student.dto.Student;

public interface IStudentDBOps {
	public List<Student> getStudentsFromDB();
	public boolean addStudent(String studentName, Date dateOfBirth);
	public Student getStudentDetailsById(Integer studentId);
}
