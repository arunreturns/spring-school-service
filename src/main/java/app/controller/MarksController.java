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

import app.service.MarksService;
import app.dto.Marks;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Marks services")
public class MarksController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MarksService marksService;

	@RequestMapping(path="/marks", method = RequestMethod.GET)
	@ApiOperation(value = "View the marks of all the students", response = List.class)
	public List<Marks> getMarks() {
		logger.info("Inside getMarks");
		return marksService.getMarksService();
	}

	@RequestMapping(path="/marks/{studentName}", method = RequestMethod.GET)
	@ApiOperation(value = "View the marks of a specific student", response = List.class)
	public List<Marks> getMarksForStudent(@PathVariable String studentName) {
		logger.info("Inside getMarksForStudent");
		return marksService.getMarksForStudentService(studentName);
	}
	
	@RequestMapping(path="/mark", method = RequestMethod.POST)
	@ApiOperation(value = "Enter the mark of a specific student", response = Boolean.class)
	public boolean addMarksForStudent(@RequestBody Marks studentMarks) {
		logger.info("Inside addMarksForStudent");
		return marksService.addMarksForStudentService(studentMarks);
	}

	@RequestMapping(path="/mark/{markId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update the marks for a specific student and subject combination", response = Boolean.class)
	public boolean updateMarksForStudent(@PathVariable Integer markId, @RequestBody Marks studentMarks) {
		logger.info("Inside updateMarksForStudent");
		return marksService.updateMarksForStudentService(markId, studentMarks);
	}
	
	@RequestMapping(path="/mark/{markId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the marks based on ID", response = Boolean.class)
	public boolean deleteMarksByID(@PathVariable Integer markId) {
		logger.info("Inside deleteMarksByID");
		return marksService.deleteMarksByIDService(markId);
	}
}
