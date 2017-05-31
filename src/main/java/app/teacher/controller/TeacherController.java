package app.teacher.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.teacher.api.ITeacherService;
import app.teacher.dto.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Teacher services")
public class TeacherController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ITeacherService teacherService;

	@Autowired
	public TeacherController(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping(path="/teachers", method = RequestMethod.GET)
	@ApiOperation(value = "View all the teachers", response = List.class)
	public List<Teacher> getTeacher() {
		logger.info("Inside getTeacher");
		return teacherService.getTeacherService();
	}
	@RequestMapping(path="/teacher", method = RequestMethod.POST)
	@ApiOperation(value = "Add a teacher", response = Boolean.class)
	public boolean addTeacher(@RequestBody Teacher teacher) {
		logger.info("Inside addTeacher");
		return teacherService.addTeacherService(teacher);
	}

	@RequestMapping(path="/teacher/{teacherId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific teacher", response = Teacher.class)
	public Teacher getTeacherDetails(@PathVariable Integer teacherId) {
		logger.info("Inside getTeacherDetails");
		return teacherService.getTeacherDetailsService(teacherId);
	}

	@RequestMapping(path="/teacher/{teacherId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a single teacher details", response = Boolean.class)
	public boolean updateTeacher(@PathVariable Integer teacherId, @RequestBody Teacher teacher) {
		logger.info("Inside updateTeacher");
		return teacherService.updateTeacherByIDService(teacherId, teacher);
	}
	
	@RequestMapping(path="/teacher/{teacherId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the teacher based on ID", response = Boolean.class)
	public boolean deleteTeacherByID(@PathVariable Integer teacherId) {
		logger.info("Inside deleteTeacherByID");
		return teacherService.deleteTeacherByIDService(teacherId);
	}
}
