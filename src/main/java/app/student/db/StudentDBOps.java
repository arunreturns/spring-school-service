package app.student.db;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import app.student.api.IStudentDBOps;
import app.student.dto.Student;

@Service
public class StudentDBOps implements IStudentDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Student> getStudentsFromDB() {
		String query = "SELECT * FROM STUDENTS";
		List<Student> students = namedParameterJdbcTemplate.query(query, new StudentRowMapper());

		logger.info("Students " + students);
		return students;
	}
	
	@Override
	public List<Student> getStudentsByNameFromDB(String studentName) {
		String query = "SELECT * FROM STUDENTS WHERE studentName = :studentName";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentName", studentName);
		
		List<Student> students = namedParameterJdbcTemplate.query(query, param, new StudentRowMapper());

		logger.info("Students " + students);
		return students;
	}
	
	@Override
	public boolean updateStudentInDB(Integer studentId, Student student) {
		String query = "UPDATE STUDENTS SET studentName = :studentName, dateOfBirth = :dateOfBirth, "
				+ "studentEmail = :studentEmail, parentEmail = :parentEmail "
				+ "WHERE studentId = :studentId";

		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("studentName", student.getStudentName())
                .addValue("studentEmail", student.getStudentEmail())
                .addValue("parentEmail", student.getParentEmail())
                .addValue("dateOfBirth", student.getDateOfBirth())
                .addValue("studentId", studentId);

		int updateCount = namedParameterJdbcTemplate.update(query, param);

		return updateCount > 0;
	}
	@Override
	public boolean addStudentInDB(String studentName, Date dateOfBirth, String studentEmail, String parentEmail) {
		String query = "INSERT INTO STUDENTS(studentName, dateOfBirth, studentEmail, parentEmail) " + 
					   "VALUES (:studentName, :dateOfBirth, :studentEmail, :parentEmail)";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentName", studentName)
                .addValue("studentEmail", studentEmail)
                .addValue("parentEmail", parentEmail)
                .addValue("dateOfBirth", dateOfBirth);

        int updateCount = namedParameterJdbcTemplate.update(query, param);

        return updateCount > 0;
	}
	@Override
	public Student getStudentDetailsFromDB(Integer studentId) {
		String query = "SELECT * FROM STUDENTS WHERE studentId = :studentId";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentId", studentId);
		
		Student student = namedParameterJdbcTemplate.queryForObject(query, param, new StudentRowMapper());
		return student;
	}
	@Override
	public boolean deleteStudentByIDFromDB(Integer studentId) {
		String query = "DELETE FROM STUDENTS WHERE studentId = :studentId";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("studentId", studentId);
		
		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		return deletedCount > 0;
	}

}

