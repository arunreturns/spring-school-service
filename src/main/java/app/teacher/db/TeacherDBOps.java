package app.teacher.db;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import app.teacher.api.ITeacherDBOps;
import app.teacher.dto.Teacher;

@Service
public class TeacherDBOps implements ITeacherDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Teacher> getTeachersFromDB() {
		String query = "SELECT * FROM TEACHERS";
		logger.info("Running query " + query);
		List<Teacher> teachers = namedParameterJdbcTemplate.query(query, new TeacherRowMapper());

		logger.info("Teachers " + teachers);
		
		return teachers;
	}
	
	@Override
	public boolean addTeacherInDB(Teacher teacher) {
		
        String query = "INSERT INTO TEACHERS(teacherId, teacherName, yearsOfExperience, dateOfBirth, joiningDate) "
    				 + "VALUES (:teacherId, :teacherName, :yearsOfExperience, :dateOfBirth, :joiningDate)";
        logger.info("Running query " + query);
        
    	MapSqlParameterSource param = new MapSqlParameterSource()
    	             .addValue("teacherId", teacher.getTeacherId()).addValue("teacherName", teacher.getTeacherName()).addValue("yearsOfExperience", teacher.getYearsOfExperience()).addValue("dateOfBirth", teacher.getDateOfBirth()).addValue("joiningDate", teacher.getJoiningDate());


		int insertCount = namedParameterJdbcTemplate.update(query, param);
		
		logger.info("No of rows inserted: " + insertCount);
		return insertCount > 0;
	}

	@Override
	public Teacher getTeacherDetailsFromDB(Integer teacherId) {
		String query = "SELECT * FROM TEACHERS WHERE teacherId = :teacherId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("teacherId", teacherId);

		Teacher teacher = namedParameterJdbcTemplate.queryForObject(query, param, new TeacherRowMapper());
		logger.info("Teacher Object obtained: " + teacher.toString());
		return teacher;
	}

	@Override
	public boolean updateTeacherInDB(Integer teacherId, Teacher teacher) {
		
        String query = "UPDATE TEACHERS teacherId = :teacherId, teacherName = :teacherName, yearsOfExperience = :yearsOfExperience, dateOfBirth = :dateOfBirth, joiningDate = :joiningDate "
				     + "WHERE teacherId = :teacherId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource()
				     .addValue("teacherId", teacher.getTeacherId()).addValue("teacherName", teacher.getTeacherName()).addValue("yearsOfExperience", teacher.getYearsOfExperience()).addValue("dateOfBirth", teacher.getDateOfBirth()).addValue("joiningDate", teacher.getJoiningDate());


		int updateCount = namedParameterJdbcTemplate.update(query, param);
		logger.info("No of rows updated: " + updateCount);
		return updateCount > 0;
	}

	@Override
	public boolean deleteTeacherByIDFromDB(Integer teacherId) {
		String query = "DELETE FROM TEACHERS WHERE teacherId = :teacherId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("teacherId", teacherId);

		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		logger.info("No of rows deleted: " + deletedCount);
		return deletedCount > 0;
	}

}
