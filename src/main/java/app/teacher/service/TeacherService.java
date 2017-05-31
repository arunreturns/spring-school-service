package app.teacher.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.teacher.api.ITeacherDBOps;
import app.teacher.api.ITeacherService;
import app.teacher.dto.Teacher;

@Service
public class TeacherService implements ITeacherService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private ITeacherDBOps dbOps;

	@Override
	public List<Teacher> getTeacherService() {
		logger.info("Inside getTeacherService");
		return dbOps.getTeachersFromDB();
	}

	@Override
	public boolean addTeacherService(Teacher teacher) {
		logger.info("Inside addTeacherService");
		logger.info("Adding " + teacher);
		return dbOps.addTeacherInDB(teacher);
	}

	@Override
	public Teacher getTeacherDetailsService(Integer teacherId) {
		logger.info("Inside getTeacherDetailsService");
		logger.info("Getting details for ID: " + teacherId);
		return dbOps.getTeacherDetailsFromDB(teacherId);
	}

	@Override
	public boolean updateTeacherByIDService(Integer teacherId, Teacher teacher) {
		logger.info("Inside updateTeacherByIDService");
		logger.info("Updating details for ID: " + teacherId);
		logger.info("Object Content to be updated" + teacher);
		return dbOps.updateTeacherInDB(teacherId, teacher);
	}

	@Override
	public boolean deleteTeacherByIDService(Integer teacherId) {
		logger.info("Inside deleteTeacherByIDService");
		logger.info("Deleting details for ID: " + teacherId);
		return dbOps.deleteTeacherByIDFromDB(teacherId);
	}
	
}
