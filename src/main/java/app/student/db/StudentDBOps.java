package app.student.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.ResultSetExtractor;

import app.student.api.IStudentDBOps;
import app.student.dto.Student;

@Service
public class StudentDBOps implements IStudentDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Student> getStudentsFromDB() {
		String query = "SELECT * FROM students";
		List<Student> students = namedParameterJdbcTemplate.query(query, new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student mark = new Student();
				
				mark.setStudentName(rs.getString("studentName"));
				mark.setDateOfBirth(rs.getDate("dateOfBirth"));
				
				return mark;
			}
			
		});
		
		logger.info("Students " + students);
		return students;
	}
	
	@Override
	public boolean addStudent(String studentName, Date dateOfBirth) {
		String query = "INSERT INTO STUDENTS(studentName, dateOfBirth) VALUES (:studentName, :dateOfBirth)";

	        MapSqlParameterSource param = new MapSqlParameterSource()
	                .addValue("studentName", studentName)
	                .addValue("dateOfBirth", dateOfBirth);
	
	        int updateCount = namedParameterJdbcTemplate.update(query, param);
	
	        return updateCount > 0;
	}
	
	@Override
	public Student getStudentDetailsById(Integer studentId) {
		String query = "SELECT * FROM students WHERE studentId = :studentId";

	        MapSqlParameterSource param = new MapSqlParameterSource()
	                .addValue("studentId", studentId);
	
	        Student studentDetails = namedParameterJdbcTemplate.query(query, param, new ResultSetExtractor<Student>(){
				@Override
				public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
					Student student = new Student();
					
					student.setDateOfBirth(rs.getDate("dateOfBirth"));
					student.setStudentName(rs.getString("studentname"));
					
					return student;
				}
				
			});
	
	        return studentDetails;
	}
}
