package app.teacher.api;

import java.util.List;

import app.teacher.dto.Teacher;

public interface ITeacherService {
	public List<Teacher> getTeacherService();
	
	public boolean addTeacherService(Teacher teacher);
	
	public Teacher getTeacherDetailsService(Integer teacherId);

	public boolean updateTeacherByIDService(Integer markId, Teacher studentTeacher);

	public boolean deleteTeacherByIDService(Integer markId);
}
