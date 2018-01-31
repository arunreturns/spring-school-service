package app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.db.StaffDBOps;
import app.dto.Staff;

@Service
public class StaffService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private StaffDBOps dbOps;

	public List<Staff> getStaffService() {
		logger.info("Inside getStaffService");
		return dbOps.getStaffsFromDB();
	}

	public boolean addStaffService(Staff staff) {
		logger.info("Inside addStaffService");
		logger.info("Adding " + staff);
		return dbOps.addStaffInDB(staff);
	}

	public Staff getStaffDetailsService(Integer staffId) {
		logger.info("Inside getStaffDetailsService");
		logger.info("Getting details for ID: " + staffId);
		return dbOps.getStaffDetailsFromDB(staffId);
	}

	public boolean updateStaffByIDService(Integer staffId, Staff staff) {
		logger.info("Inside updateStaffByIDService");
		logger.info("Updating details for ID: " + staffId);
		logger.info("Object Content to be updated" + staff);
		return dbOps.updateStaffInDB(staffId, staff);
	}

	public boolean deleteStaffByIDService(Integer staffId) {
		logger.info("Inside deleteStaffByIDService");
		logger.info("Deleting details for ID: " + staffId);
		return dbOps.deleteStaffByIDFromDB(staffId);
	}
	
}
