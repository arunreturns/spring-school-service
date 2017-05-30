package app.classes.controller;

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

import app.classes.api.IClassesService;
import app.classes.dto.Classes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Classes services")
public class ClassesController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private IClassesService classesService;

	@Autowired
	public ClassesController(IClassesService classesService) {
		this.classesService = classesService;
	}

	@RequestMapping(path="/classes", method = RequestMethod.GET)
	@ApiOperation(value = "View the all the classes", response = List.class)
	public List<Classes> getClasses() {
		logger.info("Inside getClasses");
		return classesService.getClassesService();
	}

	@RequestMapping(path="/classes/{classId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific class", response = Classes.class)
	public Classes getClassesDetails(@PathVariable Integer classId) {
		logger.info("Inside getClassesDetails");
		return classesService.getClassesDetailsService(classId);
	}
	
	@RequestMapping(path="/classes", method = RequestMethod.POST)
	@ApiOperation(value = "Add a Class", response = Boolean.class)
	public boolean addClasses(@RequestBody Classes classDetails) {
		logger.info("Inside addClasses");
		return classesService.addClassesService(classDetails);
	}

	@RequestMapping(path="/classes/{classId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a class details", response = Boolean.class)
	public boolean updateClasses(@PathVariable Integer classId, @RequestBody Classes classDetails) {
		logger.info("Inside updateClasses");
		return classesService.updateClassesByIDService(classId, classDetails);
	}
	
	@RequestMapping(path="/classes/{classId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the class based on ID", response = Boolean.class)
	public boolean deleteClassesByID(@PathVariable Integer classId) {
		logger.info("Inside deleteClassesByID");
		return classesService.deleteClassesByIDService(classId);
	}
}
