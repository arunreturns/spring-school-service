package app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.db.TeacherDBOps;
import app.dto.Teacher;

@Service
public class TeacherService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private TeacherDBOps dbOps;

	public List<Teacher> getTeacherService() {
		logger.info("Inside getTeacherService");
		return dbOps.getTeachersFromDB();
	}

	public boolean addTeacherService(Teacher teacher) {
		logger.info("Inside addTeacherService");
		logger.info("Adding " + teacher);
		return dbOps.addTeacherInDB(teacher);
	}

	public Teacher getTeacherDetailsService(Integer teacherId) {
		logger.info("Inside getTeacherDetailsService");
		logger.info("Getting details for ID: " + teacherId);
		return dbOps.getTeacherDetailsFromDB(teacherId);
	}
	
	public List<Teacher> getTeacherDetailsByNameService(String teacherName) {
		logger.info("Inside getTeacherDetailsByNameService");
		logger.info("Getting details for : " + teacherName);
		return dbOps.getTeacherDetailsByNameFromDB(teacherId);
	}

	public boolean updateTeacherByIDService(Integer teacherId, Teacher teacher) {
		logger.info("Inside updateTeacherByIDService");
		logger.info("Updating details for ID: " + teacherId);
		logger.info("Object Content to be updated" + teacher);
		return dbOps.updateTeacherInDB(teacherId, teacher);
	}

	public boolean deleteTeacherByIDService(Integer teacherId) {
		logger.info("Inside deleteTeacherByIDService");
		logger.info("Deleting details for ID: " + teacherId);
		return dbOps.deleteTeacherByIDFromDB(teacherId);
	}
	
}
