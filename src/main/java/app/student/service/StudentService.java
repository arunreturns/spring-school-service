package app.student.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.student.api.IStudentDBOps;
import app.student.api.IStudentService;
import app.student.dto.Student;

@Service
public class StudentService implements IStudentService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private IStudentDBOps dbOps;

	@Override
	public List<Student> getStudentService() {
		logger.info("Inside getStudentService");
		return dbOps.getStudentsFromDB();
	}

	@Override
	public boolean addStudentService(Student student) {
		logger.info("Inside addStudentService");
		logger.info("Adding " + student);
		return dbOps.addStudentInDB(student);
	}

	@Override
	public Student getStudentDetailsService(Integer studentId) {
		logger.info("Inside getStudentDetailsService");
		logger.info("Getting details for ID: " + studentId);
		return dbOps.getStudentDetailsFromDB(studentId);
	}

	@Override
	public boolean updateStudentByIDService(Integer studentId, Student student) {
		logger.info("Inside updateStudentByIDService");
		logger.info("Updating details for ID: " + studentId);
		logger.info("Object Content to be updated" + student);
		return dbOps.updateStudentInDB(studentId, student);
	}

	@Override
	public boolean deleteStudentByIDService(Integer studentId) {
		logger.info("Inside deleteStudentByIDService");
		logger.info("Deleting details for ID: " + studentId);
		return dbOps.deleteStudentByIDFromDB(studentId);
	}
	
}
