package app.staff.api;

import java.util.List;

import app.staff.dto.Staff;

public interface IStaffService {
	// Returns all the rows from DB as a List
	public List<Staff> getStaffService();
	
	// Add a single staff into DB
	public boolean addStaffService(Staff staff);
	
	// Returns a single Staff entity from DB
	public Staff getStaffDetailsService(Integer staffId);

	// Updates a single Staff entity in DB
	public boolean updateStaffByIDService(Integer staffId, Staff staff);

	// Deletes a single Staff entity in DB
	public boolean deleteStaffByIDService(Integer markId);
}
