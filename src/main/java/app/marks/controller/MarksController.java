package app.marks.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.marks.api.IMarksService;
import app.marks.dto.Marks;
import io.swagger.annotations.ApiOperation;

@RestController
public class MarksController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private IMarksService marksService;

	@Autowired
	public MarksController(IMarksService marksService) {
		this.marksService = marksService;
	}

	@RequestMapping(path="/marks", method = RequestMethod.GET)
	@ApiOperation(value = "View the marks of all the students", response = List.class)
	public List<Marks> getMarks() {
		logger.info("Inside getMarks");
		return marksService.getMarks();
	}

	@RequestMapping(path="/marks/{studentName}", method = RequestMethod.GET)
	@ApiOperation(value = "View the marks of a specific student", response = List.class)
	public List<Marks> getMarksForStudent(@PathVariable String studentName) {
		logger.info("Inside getMarksForStudent");
		return marksService.getMarksForStudent(studentName);
	}
	
	@RequestMapping(path="/mark", method = RequestMethod.POST)
	@ApiOperation(value = "Enter the mark of a specific student", response = Boolean.class)
	public boolean addMarksForStudent(@RequestBody Marks studentMarks) {
		logger.info("Inside addMarksForStudent");
		return marksService.addMarksForStudent(studentMarks);
	}

	
	@RequestMapping(path="/update", method = RequestMethod.POST)
	@ApiOperation(value = "Update the marks for a specific student and subject combination", response = Boolean.class)
	public boolean updateMarksForStudent(@RequestBody Marks studentMarks) {
		logger.info("Inside updateMarksForStudent");
		return marksService.updateMarksForStudent(studentMarks);
	}
}
