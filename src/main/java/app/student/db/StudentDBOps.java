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
import app.classroom.api.IClassroomDBOps;
import app.student.dto.Student;

@Service
public class StudentDBOps implements IStudentDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private IClassroomDBOps classRoomDBOps;
	
	@Override
	public List<Student> getStudentsFromDB() {
		String query = "SELECT * FROM STUDENTS";
		logger.info("Running query " + query);
		List<Student> students = namedParameterJdbcTemplate.query(query, new StudentRowMapper());

		logger.info("Students " + students);
		
		return students;
	}
	
	@Override
	public boolean addStudentInDB(Student student) {
		
        String query = "INSERT INTO STUDENTS(studentName, studentClass, studentEmail, parentEmail, dateOfBirth) "
    				 + "VALUES (:studentName, :studentClass, :studentEmail, :parentEmail, :dateOfBirth)";
        logger.info("Running query " + query);
        
    	MapSqlParameterSource param = new MapSqlParameterSource()
    	             .addValue("studentName", student.getStudentName()).addValue("studentClass", student.getStudentClass()).addValue("studentEmail", student.getStudentEmail()).addValue("parentEmail", student.getParentEmail()).addValue("dateOfBirth", student.getDateOfBirth());

		int insertCount = namedParameterJdbcTemplate.update(query, param);
		
		boolean updatedInClass = classRoomDBOps.updateStudentsInClassRoom(student.getStudentClass(), 1);

		logger.info("No of rows inserted: " + insertCount);
		logger.info("No of rows updated in classroom: " + updatedInClass);
		return insertCount > 0 & updatedInClass;
	}

	@Override
	public Student getStudentDetailsFromDB(Integer studentId) {
		String query = "SELECT * FROM STUDENTS WHERE studentId = :studentId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("studentId", studentId);

		Student student = namedParameterJdbcTemplate.queryForObject(query, param, new StudentRowMapper());
		logger.info("Student Object obtained: " + student.toString());
		return student;
	}

	@Override
	public boolean updateStudentInDB(Integer studentId, Student student) {
		
        String query = "UPDATE STUDENTS SET studentName = :studentName, studentClass = :studentClass, studentEmail = :studentEmail, parentEmail = :parentEmail, dateOfBirth = :dateOfBirth "
				     + "WHERE studentId = :studentId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource()
				     .addValue("studentId", student.getStudentId()).addValue("studentName", student.getStudentName()).addValue("studentClass", student.getStudentClass()).addValue("studentEmail", student.getStudentEmail()).addValue("parentEmail", student.getParentEmail()).addValue("dateOfBirth", student.getDateOfBirth());


		int updateCount = namedParameterJdbcTemplate.update(query, param);
		logger.info("No of rows updated: " + updateCount);
		return updateCount > 0;
	}

	@Override
	public boolean deleteStudentByIDFromDB(Integer studentId) {
		String query = "DELETE FROM STUDENTS WHERE studentId = :studentId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("studentId", studentId);

		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		logger.info("No of rows deleted: " + deletedCount);
		return deletedCount > 0;
	}

}
