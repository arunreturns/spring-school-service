package app.teacher.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
		String query = "SELECT * FROM teachers";
		List<Teacher> teachers = namedParameterJdbcTemplate.query(query, new RowMapper<Teacher>(){
			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher mark = new Teacher();
				
				mark.setTeacherName(rs.getString("teacherName"));
				mark.setDateOfBirth(rs.getDate("dateOfBirth"));
				
				return mark;
			}
			
		});
		
		logger.info("Teachers " + teachers);
		return teachers;
	}
	
	
	@Override
	public boolean addTeacher(String teacherName, Date dateOfBirth, String teacherSubjects) {
		String query = "INSERT INTO TEACHERS(teacherName, dateOfBirth, teacherSubjects) VALUES (:teacherName, :dateOfBirth, string_to_array(:teacherSubjects,','))";

	        MapSqlParameterSource param = new MapSqlParameterSource()
	                .addValue("teacherName", teacherName)
	                .addValue("teacherSubjects", teacherSubjects)
	                .addValue("dateOfBirth", dateOfBirth);
	
	        int updateCount = namedParameterJdbcTemplate.update(query, param);
	
	        return updateCount > 0;
	}
}
