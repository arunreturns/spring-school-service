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
	public List<Student> getStudentService() {
		return dbOps.getStudentsFromDB();
	}

	@Override
	public boolean addStudentService(Student studentDetails) {
		return dbOps.addStudentInDB(studentDetails.getStudentName(),studentDetails.getDateOfBirth(), studentDetails.getStudentEmail(), studentDetails.getParentEmail());
	}

	@Override
	public Student getStudentDetailsService(Integer studentId) {
		return dbOps.getStudentDetailsFromDB(studentId);
	}

	@Override
	public boolean updateStudentByIDService(Integer markId, Student studentStudent) {
		return dbOps.updateStudentInDB(markId, studentStudent);
	}

	@Override
	public boolean deleteStudentByIDService(Integer markId) {
		return dbOps.deleteStudentByIDFromDB(markId);
	}
	
}
