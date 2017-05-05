package app.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import app.student.api.IStudentService;
import app.student.dto.Student;
import io.swagger.annotations.ApiOperation;

@RestController
public class StudentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private IStudentService studentService;

	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(path="/students", method = RequestMethod.GET)
	@ApiOperation(value = "View a list of students", response = List.class)
	public List<Student> getStudents() {
		logger.info("Inside getStudents");
		return studentService.getStudents();
	}

	@RequestMapping(path="/students/{studentId}", method = RequestMethod.GET)
	@ApiOperation(value = "View details for a specific student", response = List.class)
	public Student getStudentDetailsById(@PathVariable Integer studentId) {
		logger.info("Inside getStudents");
		return studentService.getStudentDetailsById(studentId);
	}
	
	@RequestMapping(path="/student", method = RequestMethod.POST)
	@ApiOperation(value = "Add a student", response = Boolean.class)
	public boolean addStudent(@RequestBody Student student) {
		logger.info("Inside addStudent");
		return studentService.addStudent(student);
	}
}
