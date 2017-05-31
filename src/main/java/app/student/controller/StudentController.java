package app.student.controller;

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

import app.student.api.IStudentService;
import app.student.dto.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Student services")
public class StudentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private IStudentService studentService;

	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(path="/students", method = RequestMethod.GET)
	@ApiOperation(value = "View all the students", response = List.class)
	public List<Student> getStudent() {
		logger.info("Inside getStudent");
		return studentService.getStudentService();
	}
	@RequestMapping(path="/student", method = RequestMethod.POST)
	@ApiOperation(value = "Add a student", response = Boolean.class)
	public boolean addStudent(@RequestBody Student student) {
		logger.info("Inside addStudent");
		return studentService.addStudentService(student);
	}

	@RequestMapping(path="/student/{studentId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific student", response = Student.class)
	public Student getStudentDetails(@PathVariable Integer studentId) {
		logger.info("Inside getStudentDetails");
		return studentService.getStudentDetailsService(studentId);
	}

	@RequestMapping(path="/student/{studentId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a single student details", response = Boolean.class)
	public boolean updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
		logger.info("Inside updateStudent");
		return studentService.updateStudentByIDService(studentId, student);
	}
	
	@RequestMapping(path="/student/{studentId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the student based on ID", response = Boolean.class)
	public boolean deleteStudentByID(@PathVariable Integer studentId) {
		logger.info("Inside deleteStudentByID");
		return studentService.deleteStudentByIDService(studentId);
	}
}
