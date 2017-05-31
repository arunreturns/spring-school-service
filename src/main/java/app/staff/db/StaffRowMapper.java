package app.staff.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.staff.dto.Staff;

public class StaffRowMapper implements RowMapper<Staff>{

	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = new Staff();
		

    staff.setStaffId(rs.getInt("staffId"));

    staff.setStaffName(rs.getString("staffName"));

    staff.setDateOfBirth(rs.getDate("dateOfBirth"));

    staff.setStaffRole(rs.getString("staffRole"));

		
		return staff;
	}

}
