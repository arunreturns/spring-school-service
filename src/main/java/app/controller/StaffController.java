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

import app.service.StaffService;
import app.dto.Staff;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="API for Handling Staff services")
public class StaffController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StaffService staffService;

	@RequestMapping(path="/staffs", method = RequestMethod.GET)
	@ApiOperation(value = "View all the staffs", response = List.class)
	public List<Staff> getStaff() {
		logger.info("Inside getStaff");
		return staffService.getStaffService();
	}
	@RequestMapping(path="/staff", method = RequestMethod.POST)
	@ApiOperation(value = "Add a staff", response = Boolean.class)
	public boolean addStaff(@RequestBody Staff staff) {
		logger.info("Inside addStaff");
		return staffService.addStaffService(staff);
	}

	@RequestMapping(path="/staff/{staffId}", method = RequestMethod.GET)
	@ApiOperation(value = "View the details of a specific staff", response = Staff.class)
	public Staff getStaffDetails(@PathVariable Integer staffId) {
		logger.info("Inside getStaffDetails");
		return staffService.getStaffDetailsService(staffId);
	}

	@RequestMapping(path="/staff/{staffId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a single staff details", response = Boolean.class)
	public boolean updateStaff(@PathVariable Integer staffId, @RequestBody Staff staff) {
		logger.info("Inside updateStaff");
		return staffService.updateStaffByIDService(staffId, staff);
	}
	
	@RequestMapping(path="/staff/{staffId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the staff based on ID", response = Boolean.class)
	public boolean deleteStaffByID(@PathVariable Integer staffId) {
		logger.info("Inside deleteStaffByID");
		return staffService.deleteStaffByIDService(staffId);
	}
}
