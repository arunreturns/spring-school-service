package app.classroom.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.classroom.api.IClassroomDBOps;
import app.classroom.api.IClassroomService;
import app.classroom.dto.Classroom;
import app.student.dto.Student;

@Service
public class ClassroomService implements IClassroomService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private IClassroomDBOps dbOps;

	@Override
	public List<Classroom> getClassroomService() {
		logger.info("Inside getClassroomService");
		return dbOps.getClassroomsFromDB();
	}

	@Override
	public boolean addClassroomService(Classroom classroom) {
		logger.info("Inside addClassroomService");
		logger.info("Adding " + classroom);
		return dbOps.addClassroomInDB(classroom);
	}

	@Override
	public Classroom getClassroomDetailsService(Integer classroomId) {
		logger.info("Inside getClassroomDetailsService");
		logger.info("Getting details for ID: " + classroomId);
		return dbOps.getClassroomDetailsFromDB(classroomId);
	}

	@Override
	public boolean updateClassroomByIDService(Integer classroomId, Classroom classroom) {
		logger.info("Inside updateClassroomByIDService");
		logger.info("Updating details for ID: " + classroomId);
		logger.info("Object Content to be updated" + classroom);
		return dbOps.updateClassroomInDB(classroomId, classroom);
	}

	@Override
	public boolean deleteClassroomByIDService(Integer classroomId) {
		logger.info("Inside deleteClassroomByIDService");
		logger.info("Deleting details for ID: " + classroomId);
		return dbOps.deleteClassroomByIDFromDB(classroomId);
	}
	
	@Override
	public List<Student> getStudentsInClassRoomService(Integer classroomId) {
		logger.info("Inside getStudentsInClassRoomService");
		logger.info("Getting students list for ID: " + classroomId);
		return dbOps.getStudentsInClassRoomFromDB(classroomId);
	}
}
