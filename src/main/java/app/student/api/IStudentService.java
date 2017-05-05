package app.student.api;

import java.util.List;

import app.student.dto.Student;

public interface IStudentService {
	public List<Student> getStudentService();
	
	public boolean addStudentService(Student student);
	
	public Student getStudentDetailsService(Integer studentId);

	public boolean updateStudentByIDService(Integer markId, Student studentStudent);

	public boolean deleteStudentByIDService(Integer markId);
}
