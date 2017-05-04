package app.teacher.api;

import java.util.List;
import java.util.Date;

import app.teacher.dto.Teacher;

public interface ITeacherDBOps {
	public List<Teacher> getTeachersFromDB();
	public boolean addTeacher(String teacherName, Date dateOfBirth, String teacherSubjects);
}
