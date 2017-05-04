package app.teacher.api;

import java.util.List;
import java.util.Date;
import app.teacher.dto.Teacher;

public interface ITeacherService {
	public List<Teacher> getTeachers();
	public boolean addTeacher(Teacher teacher);
}
