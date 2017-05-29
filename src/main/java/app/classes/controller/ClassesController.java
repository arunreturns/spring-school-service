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
	@ApiOperation(value = "View the all the classess", response = List.class)
	public List<Classes> getClasses() {
		logger.info("Inside getClasses");
		return classesService.getClassesService();
	}

	@RequestMapping(path="/classes/{classesId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific class", response = Classes.class)
	public Classes getClassesDetails(@PathVariable Integer classesId) {
		logger.info("Inside getClassesDetails");
		return classesService.getClassesDetailsService(classesId);
	}
	
	@RequestMapping(path="/classes", method = RequestMethod.POST)
	@ApiOperation(value = "Add a Class", response = Boolean.class)
	public boolean addClasses(@RequestBody Classes classesClasses) {
		logger.info("Inside addClasses");
		return classesService.addClassesService(classesClasses);
	}

	@RequestMapping(path="/classes/{classesId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a class details", response = Boolean.class)
	public boolean updateClasses(@PathVariable Integer classesId, @RequestBody Classes classesClasses) {
		logger.info("Inside updateClasses");
		return classesService.updateClassesByIDService(classesId, classesClasses);
	}
	
	@RequestMapping(path="/classes/{classesId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the class based on ID", response = Boolean.class)
	public boolean deleteClassesByID(@PathVariable Integer classesId) {
		logger.info("Inside deleteClassesByID");
		return classesService.deleteClassesByIDService(classesId);
	}
}
