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

import app.service.SubjectService;
import app.dto.Subject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Subject services")
public class SubjectController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SubjectService subjectService;

	@RequestMapping(path="/subjects", method = RequestMethod.GET)
	@ApiOperation(value = "View all the subjects", response = List.class)
	public List<Subject> getSubject() {
		logger.info("Inside getSubject");
		return subjectService.getSubjectService();
	}
	@RequestMapping(path="/subject", method = RequestMethod.POST)
	@ApiOperation(value = "Add a subject", response = Boolean.class)
	public boolean addSubject(@RequestBody Subject subject) {
		logger.info("Inside addSubject");
		return subjectService.addSubjectService(subject);
	}

	@RequestMapping(path="/subject/{subjectId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific subject", response = Subject.class)
	public Subject getSubjectDetails(@PathVariable Integer subjectId) {
		logger.info("Inside getSubjectDetails");
		return subjectService.getSubjectDetailsService(subjectId);
	}

	@RequestMapping(path="/subject/{subjectId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a single subject details", response = Boolean.class)
	public boolean updateSubject(@PathVariable Integer subjectId, @RequestBody Subject subject) {
		logger.info("Inside updateSubject");
		return subjectService.updateSubjectByIDService(subjectId, subject);
	}
	
	@RequestMapping(path="/subject/{subjectId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the subject based on ID", response = Boolean.class)
	public boolean deleteSubjectByID(@PathVariable Integer subjectId) {
		logger.info("Inside deleteSubjectByID");
		return subjectService.deleteSubjectByIDService(subjectId);
	}
}
