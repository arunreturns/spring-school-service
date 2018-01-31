package app.db.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.dto.Staff;

public class StaffRowMapper implements RowMapper<Staff>{

	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = new Staff();
		

    staff.setStaffId(rs.getInt("staffId"));

    staff.setStaffName(rs.getString("staffName"));

    staff.setDateOfBirth(rs.getDate("dateOfBirth"));

    staff.setStaffRole(rs.getString("staffRole"));

		
		return staff;
	}

}
