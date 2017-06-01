package app.staff.dto;

import java.util.Date;

public class Staff {
    
	private Integer staffId;
	private String staffName;
	private Date dateOfBirth;
	private String staffRole;

    

    public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

    public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

    public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

    public String getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

    
    @Override
	public String toString(){
		return "Staff: Staff Id: " + staffId + "," + "Staff Name: " + staffName + "," + "Date Of Birth: " + dateOfBirth + "," + "Staff Role: " + staffRole;
	}

}
