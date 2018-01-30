package app.classroom.db;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import app.classroom.api.IClassroomDBOps;
import app.classroom.db.ClassroomRowMapper;
import app.classroom.dto.Classroom;
import app.student.dto.Student;
import app.student.db.StudentRowMapper;

@Service
public class ClassroomDBOps implements IClassroomDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Classroom> getClassroomsFromDB() {
		String query = "SELECT * FROM CLASSROOM";
		logger.info("Running query " + query);
		List<Classroom> classrooms = namedParameterJdbcTemplate.query(query, new ClassroomRowMapper());

		logger.info("Classrooms " + classrooms);
		
		return classrooms;
	}
	
	@Override
	public boolean addClassroomInDB(Classroom classroom) {
		
        String query = "INSERT INTO CLASSROOM(classroomName, teacherInCharge, studentsInClass) "
    				 + "VALUES (:classroomName, :teacherInCharge, :studentsInClass)";
        logger.info("Running query " + query);
        
    	MapSqlParameterSource param = new MapSqlParameterSource()
    	             .addValue("classroomName", classroom.getClassroomName()).addValue("teacherInCharge", classroom.getTeacherInCharge()).addValue("studentsInClass", classroom.getStudentsInClass());


		int insertCount = namedParameterJdbcTemplate.update(query, param);
		
		logger.info("No of rows inserted: " + insertCount);
		return insertCount > 0;
	}

	@Override
	public Classroom getClassroomDetailsFromDB(Integer classroomId) {
		String query = "SELECT * FROM CLASSROOM WHERE classroomId = :classroomId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("classroomId", classroomId);

		Classroom classroom = namedParameterJdbcTemplate.queryForObject(query, param, new ClassroomRowMapper());
		logger.info("Classroom Object obtained: " + classroom.toString());
		return classroom;
	}

	@Override
	public boolean updateClassroomInDB(Integer classroomId, Classroom classroom) {
		
        String query = "UPDATE CLASSROOM SET classroomName = :classroomName, teacherInCharge = :teacherInCharge, studentsInClass = :studentsInClass "
				     + "WHERE classroomId = :classroomId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource()
				     .addValue("classroomId", classroom.getClassroomId()).addValue("classroomName", classroom.getClassroomName()).addValue("teacherInCharge", classroom.getTeacherInCharge()).addValue("studentsInClass", classroom.getStudentsInClass());


		int updateCount = namedParameterJdbcTemplate.update(query, param);
		logger.info("No of rows updated: " + updateCount);
		return updateCount > 0;
	}
	
	@Override
	public boolean updateStudentsInClassRoom(String classroomName, Integer studentsInClass) {
		
        String query = "UPDATE CLASSROOM SET studentsInClass = :studentsInClass WHERE classroomName = :classroomName";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource()
				     .addValue("classroomName", classroomName).addValue("studentsInClass", studentsInClass);

		int updateCount = namedParameterJdbcTemplate.update(query, param);
		logger.info("No of rows updated: " + updateCount);
		return updateCount > 0;
	}

	@Override
	public boolean deleteClassroomByIDFromDB(Integer classroomId) {
		String query = "DELETE FROM CLASSROOM WHERE classroomId = :classroomId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("classroomId", classroomId);

		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		logger.info("No of rows deleted: " + deletedCount);
		return deletedCount > 0;
	}
	
	@Override
	public List<Student> getStudentsInClassRoomFromDB(Integer classroomId) {
		String query = "SELECT * FROM STUDENT s, CLASSROOM c WHERE c.classroomId = :classroomId AND s.studentClass = c.classroomName";
		logger.info("Running query " + query);
		
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("classroomId", classroomId);
		
		List<Student> students = namedParameterJdbcTemplate.query(query, param, new StudentRowMapper());

		logger.info("Students " + students);
		
		return students;
	}

}
