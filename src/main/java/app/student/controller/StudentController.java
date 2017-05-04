package app.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.student.api.IStudentService;
import app.student.dto.Student;

@RestController
public class StudentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private IStudentService studentService;

	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(path="/students", method = RequestMethod.GET)
	public List<Student> getStudents() {
		logger.info("Inside getStudents");
		return studentService.getStudents();
	}
	
	@RequestMapping(path="/student", method = RequestMethod.POST)
	public boolean addStudent(@RequestBody Student student) {
		logger.info("Inside addStudent");
		return studentService.addStudent(student);
	}
}
