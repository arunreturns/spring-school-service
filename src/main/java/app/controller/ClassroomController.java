package app.controller;

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

import app.service.ClassroomService;
import app.dto.Classroom;
import app.dto.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Classroom services")
public class ClassroomController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ClassroomService classroomService;

	@RequestMapping(path="/classrooms", method = RequestMethod.GET)
	@ApiOperation(value = "View all the classrooms", response = List.class)
	public List<Classroom> getClassroom() {
		logger.info("Inside getClassroom");
		return classroomService.getClassroomsService();
	}
	@RequestMapping(path="/classroom", method = RequestMethod.POST)
	@ApiOperation(value = "Add a classroom", response = Boolean.class)
	public boolean addClassroom(@RequestBody Classroom classroom) {
		logger.info("Inside addClassroom");
		return classroomService.addClassroomService(classroom);
	}

	@RequestMapping(path="/classroom/{classroomId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific classroom", response = Classroom.class)
	public Classroom getClassroomDetails(@PathVariable Integer classroomId) {
		logger.info("Inside getClassroomDetails");
		return classroomService.getClassroomDetailsService(classroomId);
	}

	@RequestMapping(path="/classroom/{classroomId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a single classroom details", response = Boolean.class)
	public boolean updateClassroom(@PathVariable Integer classroomId, @RequestBody Classroom classroom) {
		logger.info("Inside updateClassroom");
		return classroomService.updateClassroomByIDService(classroomId, classroom);
	}
	
	@RequestMapping(path="/classroom/{classroomId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the classroom based on ID", response = Boolean.class)
	public boolean deleteClassroomByID(@PathVariable Integer classroomId) {
		logger.info("Inside deleteClassroomByID");
		return classroomService.deleteClassroomByIDService(classroomId);
	}
	
	@RequestMapping(path="/classroom/{classroomId}/students", method = RequestMethod.GET)
	@ApiOperation(value = "Gets the list of students in the classroom", response = List.class)
	public List<Student> getStudentsInClassRoom(@PathVariable Integer classroomId) {
		logger.info("Inside getStudentsInClassRoom");
		return classroomService.getStudentsInClassRoomService(classroomId);
	}
}
