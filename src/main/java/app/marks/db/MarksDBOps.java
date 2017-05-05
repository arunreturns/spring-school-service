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
		String query = "SELECT * FROM MARKS";
		List<Marks> marks = namedParameterJdbcTemplate.query(query, new RowMapper<Marks>() {
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
	public List<Marks> getMarksForStudentFromDB(String studentName) {
		String query = "SELECT * FROM MARKS WHERE studentName = :studentName";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("studentName", studentName);

		List<Marks> marks = namedParameterJdbcTemplate.query(query, param, new RowMapper<Marks>() {
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
	public boolean updateMarksForStudentInDB(Integer markId, Marks studentMarks) {
		Marks mark = getRecordFromDB(markId);
		String query = "UPDATE MARKS SET marks = :marks, subjectName = :subjectName, studentName = :studentName WHERE markId = :markId";
		
		String subjectName = mark.getSubjectName() != studentMarks.getSubjectName() ? studentMarks.getSubjectName() : mark.getSubjectName();
		String studentName = mark.getStudentName() != studentMarks.getStudentName() ? studentMarks.getStudentName() : mark.getStudentName();
		Integer marks = mark.getMark() != studentMarks.getMark() ? studentMarks.getMark() : mark.getMark();
		
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("marks", marks)
				.addValue("subjectName", subjectName)
				.addValue("studentName", studentName);

		int updateCount = namedParameterJdbcTemplate.update(query, param);

		return updateCount > 0;
	}

	private Marks getRecordFromDB(Integer markId) {
		String query = "SELECT * FROM MARKS WHERE markId = :markId";
		
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("markId", markId);
		
		Marks mark = (Marks) namedParameterJdbcTemplate.query(query, param, new RowMapper<Marks>(){

			@Override
			public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
				Marks mark = new Marks();
				
				mark.setMark(rs.getInt("markId"));
				mark.setEvaluatorName(rs.getString("evaluatorName"));
				mark.setMark(rs.getInt("mark"));
				mark.setStudentName(rs.getString("studentName"));
				mark.setSubjectName(rs.getString("subjectName"));
				
				return mark;
			}
			
		});
		
		return mark;
	}

	@Override
	public boolean addMarksForStudentInDB(String studentName, String subjectName, Integer marks, String evaluatorName) {
		Integer studentId = getStudentId(studentName);
		Integer evaluatorId = getTeacherId(evaluatorName);
		String query = "INSERT INTO MARKS(subjectName, marks, studentName, studentId, evaluatorId, evaluatorName) "
				+ "VALUES (:subjectName, :marks, :studentName, :studentId, :evaluatorId, :evaluatorName)";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("marks", marks)
				.addValue("subjectName", subjectName).addValue("studentId", studentId)
				.addValue("evaluatorId", evaluatorId).addValue("evaluatorName", evaluatorName)
				.addValue("studentName", studentName);

		int updateCount = namedParameterJdbcTemplate.update(query, param);

		return updateCount > 0;
	}

	@Override
	public boolean deleteMarksByIDFromDB(Integer markId) {
		String query = "DELETE FROM MARKS WHERE markId = :markId";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("markId", markId);

		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);
		return deletedCount > 0;
	}

	private Integer getStudentId(String studentName) {
		String query = "SELECT studentId FROM STUDENTS WHERE studentName = :studentName";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("studentName", studentName);

		Integer studentId = namedParameterJdbcTemplate.queryForObject(query, param, Integer.class);
		logger.info("Inside getStudentId => studentId is " + studentId);
		return studentId;

	}

	private Integer getTeacherId(String teacherName) {
		String query = "SELECT teacherId FROM TEACHERS WHERE teacherName = :teacherName";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("teacherName", teacherName);

		Integer teacherId = namedParameterJdbcTemplate.queryForObject(query, param, Integer.class);
		logger.info("Inside getTeacherId => teacherId is " + teacherId);
		return teacherId;

	}
}

