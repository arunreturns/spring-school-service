package app.subject.db;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import app.subject.api.ISubjectDBOps;
import app.subject.dto.Subject;

@Service
public class SubjectDBOps implements ISubjectDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Subject> getSubjectsFromDB() {
		String query = "SELECT * FROM SUBJECT";
		logger.info("Running query " + query);
		List<Subject> subjects = namedParameterJdbcTemplate.query(query, new SubjectRowMapper());

		logger.info("Subjects " + subjects);
		
		return subjects;
	}
	
	@Override
	public boolean addSubjectInDB(Subject subject) {
		
        String query = "INSERT INTO SUBJECT(subjectId, subjectName) "
    				 + "VALUES (:subjectId, :subjectName)";
        logger.info("Running query " + query);
        
    	MapSqlParameterSource param = new MapSqlParameterSource()
    	             .addValue("subjectId", subject.getSubjectId()).addValue("subjectName", subject.getSubjectName());


		int insertCount = namedParameterJdbcTemplate.update(query, param);
		
		logger.info("No of rows inserted: " + insertCount);
		return insertCount > 0;
	}

	@Override
	public Subject getSubjectDetailsFromDB(Integer subjectId) {
		String query = "SELECT * FROM SUBJECT WHERE subjectId = :subjectId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("subjectId", subjectId);

		Subject subject = namedParameterJdbcTemplate.queryForObject(query, param, new SubjectRowMapper());
		logger.info("Subject Object obtained: " + subject.toString());
		return subject;
	}

	@Override
	public boolean updateSubjectInDB(Integer subjectId, Subject subject) {
		
        String query = "UPDATE SUBJECT subjectId = :subjectId, subjectName = :subjectName "
				     + "WHERE subjectId = :subjectId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource()
				     .addValue("subjectId", subject.getSubjectId()).addValue("subjectName", subject.getSubjectName());


		int updateCount = namedParameterJdbcTemplate.update(query, param);
		logger.info("No of rows updated: " + updateCount);
		return updateCount > 0;
	}

	@Override
	public boolean deleteSubjectByIDFromDB(Integer subjectId) {
		String query = "DELETE FROM SUBJECT WHERE subjectId = :subjectId";
		logger.info("Running query " + query);
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("subjectId", subjectId);

		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		logger.info("No of rows deleted: " + deletedCount);
		return deletedCount > 0;
	}

}
