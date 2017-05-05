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
		List<Teacher> teachers = namedParameterJdbcTemplate.query(query, new TeacherRowMapper());

		logger.info("Teachers " + teachers);
		return teachers;
	}
	
	@Override
	public List<Teacher> getTeachersByNameFromDB(String teacherName) {
		String query = "SELECT * FROM TEACHERS WHERE teacherName = :teacherName";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("teacherName", teacherName);
		
		List<Teacher> teachers = namedParameterJdbcTemplate.query(query, param, new TeacherRowMapper());

		logger.info("Teachers " + teachers);
		return teachers;
	}
	
	@Override
	public boolean updateTeacherInDB(Integer teacherId, Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addTeacherInDB(String teacherName, Date dateOfBirth, String teacherSubject, Integer yearsOfExperience) {
		String query = "INSERT INTO TEACHERS(teacherName, dateOfBirth, teacherSubject, yearsOfExperience) " + 
					   "VALUES (:teacherName, :dateOfBirth, :teacherSubject, :yearsOfExperience)";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("teacherName", teacherName)
                .addValue("teacherSubject", teacherSubject)
                .addValue("yearsOfExperience", yearsOfExperience)
                .addValue("dateOfBirth", dateOfBirth);

        int updateCount = namedParameterJdbcTemplate.update(query, param);

        return updateCount > 0;
	}
	@Override
	public Teacher getTeacherDetailsFromDB(Integer teacherId) {
		String query = "SELECT * FROM TEACHERS WHERE teacherId = :teacherId";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("teacherId", teacherId);
		
		Teacher teacher = namedParameterJdbcTemplate.queryForObject(query, param, new TeacherRowMapper());
		return teacher;
	}
	@Override
	public boolean deleteTeacherByIDFromDB(Integer teacherId) {
		String query = "DELETE FROM TEACHERS WHERE teacherId = :teacherId";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("teacherId", teacherId);
		
		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		return deletedCount > 0;
	}

}

