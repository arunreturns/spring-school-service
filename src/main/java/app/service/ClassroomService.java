package app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.db.ClassroomDBOps;
import app.dto.Classroom;
import app.dto.Student;

@Service
public class ClassroomService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private ClassroomDBOps dbOps;

	public List<Classroom> getClassroomsService() {
		logger.info("Inside getClassroomsService");
		return dbOps.getClassroomsFromDB();
	}

	public boolean addClassroomService(Classroom classroom) {
		logger.info("Inside addClassroomService");
		logger.info("Adding " + classroom);
		return dbOps.addClassroomInDB(classroom);
	}

	public Classroom getClassroomDetailsService(Integer classroomId) {
		logger.info("Inside getClassroomDetailsService");
		logger.info("Getting details for ID: " + classroomId);
		return dbOps.getClassroomDetailsFromDB(classroomId);
	}

	public boolean updateClassroomByIDService(Integer classroomId, Classroom classroom) {
		logger.info("Inside updateClassroomByIDService");
		logger.info("Updating details for ID: " + classroomId);
		logger.info("Object Content to be updated" + classroom);
		return dbOps.updateClassroomInDB(classroomId, classroom);
	}

	public boolean deleteClassroomByIDService(Integer classroomId) {
		logger.info("Inside deleteClassroomByIDService");
		logger.info("Deleting details for ID: " + classroomId);
		return dbOps.deleteClassroomByIDFromDB(classroomId);
	}
	
	public List<Student> getStudentsInClassRoomService(Integer classroomId) {
		logger.info("Inside getStudentsInClassRoomService");
		logger.info("Getting students list for ID: " + classroomId);
		return dbOps.getStudentsInClassRoomFromDB(classroomId);
	}
}
