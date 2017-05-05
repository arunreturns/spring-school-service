package app.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.student.api.IStudentDBOps;
import app.student.api.IStudentService;
import app.student.dto.Student;

@Service
public class StudentService implements IStudentService {
	@Autowired
    private IStudentDBOps dbOps;

	@Override
	public List<Student> getStudents() {
		return dbOps.getStudentsFromDB();
	}
	
	@Override
	public boolean addStudent(Student student) {
		return dbOps.addStudent(student.getStudentName(), student.getDateOfBirth());
	}
	
	@Override
	public Student getStudentDetailsById(Integer studentId) {
		return dbOps.getStudentDetailsById(studentId);
	}
}
