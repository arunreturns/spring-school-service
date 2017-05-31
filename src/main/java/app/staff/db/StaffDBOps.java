package app.staff.db;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import app.staff.api.IStaffDBOps;
import app.staff.dto.Staff;

@Service
public class StaffDBOps implements IStaffDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Staff> getStaffsFromDB() {
		String query = "SELECT * FROM STAFF";
		logger.info("Running query " + query + " inside getStaffsFromDB");
		List<Staff> staffs = namedParameterJdbcTemplate.query(query, new StaffRowMapper());

		logger.info("Staffs " + staffs);
		
		return staffs;
	}
	
	@Override
	public boolean addStaffInDB(Staff staff) {
		
        String query = "INSERT INTO STAFF(staffId, staffName, dateOfBirth, staffRole) "
    				 + "VALUES (:staffId, :staffName, :dateOfBirth, :staffRole)";
        logger.info("Running query " + query);
        
    	MapSqlParameterSource param = new MapSqlParameterSource()
    	             .addValue("staffId", staff.getStaffId()).addValue("staffName", staff.getStaffName()).addValue("dateOfBirth", staff.getDateOfBirth()).addValue("staffRole", staff.getStaffRole());


		int insertCount = namedParameterJdbcTemplate.update(query, param);
		
		logger.info("No of rows inserted: " + insertCount);
		return insertCount > 0;
	}

	@Override
	public Staff getStaffDetailsFromDB(Integer staffId) {
		String query = "SELECT * FROM STAFF WHERE staffId = :staffId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);

		Staff staff = namedParameterJdbcTemplate.queryForObject(query, param, new StaffRowMapper());
		logger.info("Staff Object obtained: " + staff.toString());
		return staff;
	}

	@Override
	public boolean updateStaffInDB(Integer staffId, Staff staff) {
		
        String query = "UPDATE STAFF staffId = :staffId, staffName = :staffName, dateOfBirth = :dateOfBirth, staffRole = :staffRole "
				     + "WHERE staffId = :staffId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource()
				     .addValue("staffId", staff.getStaffId()).addValue("staffName", staff.getStaffName()).addValue("dateOfBirth", staff.getDateOfBirth()).addValue("staffRole", staff.getStaffRole());


		int updateCount = namedParameterJdbcTemplate.update(query, param);
		logger.info("No of rows updated: " + updateCount);
		return updateCount > 0;
	}

	@Override
	public boolean deleteStaffByIDFromDB(Integer staffId) {
		String query = "DELETE FROM STAFF WHERE staffId = :staffId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);

		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		logger.info("No of rows deleted: " + deletedCount);
		return deletedCount > 0;
	}

}
