package app.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.teacher.api.ITeacherDBOps;
import app.teacher.api.ITeacherService;
import app.teacher.dto.Teacher;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
    private ITeacherDBOps dbOps;

	@Override
	public List<Teacher> getTeacherService() {
		return dbOps.getTeachersFromDB();
	}

	@Override
	public boolean addTeacherService(Teacher teacherDetails) {
		return dbOps.addTeacherInDB(teacherDetails.getTeacherName(),teacherDetails.getDateOfBirth(), teacherDetails.getTeacherSubject(), teacherDetails.getYearsOfExperience());
	}

	@Override
	public Teacher getTeacherDetailsService(Integer teacherId) {
		return dbOps.getTeacherDetailsFromDB(teacherId);
	}

	@Override
	public boolean updateTeacherByIDService(Integer markId, Teacher studentTeacher) {
		return dbOps.updateTeacherInDB(markId, studentTeacher);
	}

	@Override
	public boolean deleteTeacherByIDService(Integer markId) {
		return dbOps.deleteTeacherByIDFromDB(markId);
	}
	
}
