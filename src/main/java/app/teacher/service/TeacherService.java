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
	public List<Teacher> getTeachers() {
		return dbOps.getTeachersFromDB();
	}
	
	@Override
	public boolean addTeacher(Teacher teacher) {
		return dbOps.addTeacher(teacher.getTeacherName(), teacher.getDateOfBirth(), String.join(",",teacher.getTeacherSubjects()));
	}
}
