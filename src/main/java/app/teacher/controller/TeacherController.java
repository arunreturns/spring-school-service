package app.teacher.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.teacher.api.ITeacherService;
import app.teacher.dto.Teacher;

@RestController
public class TeacherController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ITeacherService teacherService;

	@Autowired
	public TeacherController(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping(path="/teachers", method = RequestMethod.GET)
	public List<Teacher> getTeachers() {
		logger.info("Inside getTeachers");
		return teacherService.getTeachers();
	}
	
	@RequestMapping(path="/teacher", method = RequestMethod.POST)
	public boolean addTeacher(@RequestBody Teacher teacher) {
		logger.info("Inside addTeacher");
		return teacherService.addTeacher(teacher);
	}
}
