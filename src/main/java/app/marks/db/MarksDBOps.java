package app.marks.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import app.marks.api.IMarksDBOps;
import app.marks.dto.Marks;

@Service
public class MarksDBOps implements IMarksDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Marks> getMarksFromDB() {
		String query = "SELECT * FROM Marks";
		List<Marks> marks = namedParameterJdbcTemplate.query(query, new RowMapper<Marks>(){
			@Override
			public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
				Marks mark = new Marks();
				
				mark.setMark(rs.getInt("marks"));
				mark.setStudentName(rs.getString("studentname"));
				mark.setSubjectName(rs.getString("subjectname"));
				
				return mark;
			}
			
		});
		
		logger.info("Marks " + marks);
		return marks;
	}
	
	@Override
	public List<Marks> getMarksForStudent(String studentName) {
		String query = "SELECT * FROM Marks WHERE studentName = :studentName";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentName", studentName);

		List<Marks> marks = namedParameterJdbcTemplate.query(query, param, new RowMapper<Marks>(){
			@Override
			public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
				Marks mark = new Marks();
				
				mark.setMark(rs.getInt("marks"));
				mark.setStudentName(rs.getString("studentname"));
				mark.setSubjectName(rs.getString("subjectname"));
				
				return mark;
			}
			
		});
		
		logger.info("Marks " + marks);
		return marks;
	}

	@Override
	public boolean updateMarksForStudent(String studentName, String subjectName, Integer marks) {
		String query = "UPDATE MARKS SET marks = :marks WHERE subjectName = :subjectName AND studentName = :studentName";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("marks", marks)
                .addValue("subjectName", subjectName)
                .addValue("studentName", studentName);

        int updateCount = namedParameterJdbcTemplate.update(query, param);

        return updateCount > 0;
	}
	
	@Override
	public boolean addMarksForStudent(String studentName, String subjectName, Integer marks) {
		Integer studentId = getStudentId(studentName);
		String query = "INSERT INTO MARKS(subjectName, marks, studentName, studentId) VALUES (:subjectName, :marks, :studentName, :studentId)";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("marks", marks)
                .addValue("subjectName", subjectName)
                .addValue("studentId", studentId)
                .addValue("studentName", studentName);

        int updateCount = namedParameterJdbcTemplate.update(query, param);

        return updateCount > 0;
	}

	private Integer getStudentId(String studentName) {
		String query = "SELECT studentId FROM STUDENTS WHERE studentName = :studentName";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentName", studentName);

        Integer studentId = namedParameterJdbcTemplate.queryForObject(query, param, Integer.class);
        logger.info("Inside getStudentId => studentId is " + studentId);
        return studentId;
		
	}
}