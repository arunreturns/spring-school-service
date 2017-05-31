package app.staff.api;

import java.util.Date;
import java.util.List;

import app.staff.dto.Staff;

public interface IStaffDBOps {
	// Get all rows from DB
	public List<Staff> getStaffsFromDB();
	
	// Insert a new row into DB
	public boolean addStaffInDB(Staff staff);
	
	// Get a specific row from DB
	public Staff getStaffDetailsFromDB(Integer staffId);
	
	// Update a single row based on ID in DB
	public boolean updateStaffInDB(Integer staffId, Staff staff);
	
	// Delete a specific row from DB
	public boolean deleteStaffByIDFromDB(Integer staffId);
}
