package app.student.api;

import java.util.List;
import java.util.Date;
import app.student.dto.Student;

public interface IStudentService {
	public List<Student> getStudents();
	public boolean addStudent(Student student);
}
