package app.teacher.api;

import java.util.Date;
import java.util.List;

import app.teacher.dto.Teacher;

public interface ITeacherDBOps {
	public List<Teacher> getTeachersFromDB();
	
	public List<Teacher> getTeachersByNameFromDB(String teacherName);
	
	public boolean updateTeacherInDB(Integer teacherId, Teacher teacher);
	
	public boolean addTeacherInDB(String teacherName, Date dateOfBirth, String teacherSubject, Integer yearsOfExperience);
	
	public Teacher getTeacherDetailsFromDB(Integer teacherId);

	public boolean deleteTeacherByIDFromDB(Integer teacherId);
}
