package app.classes.db;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import app.classes.api.IClassesDBOps;
import app.classes.dto.Classes;
import app.teacher.api.ITeacherDBOps;

@Service
public class ClassesDBOps implements IClassesDBOps {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private ITeacherDBOps teacherDBOps;
	
	@Override
	public List<Classes> getClassesFromDB() {
		String query = "SELECT * FROM CLASSES";
		List<Classes> classess = namedParameterJdbcTemplate.query(query, new ClassesRowMapper());

		logger.info("Classess " + classess);
		return classess;
	}
	
	@Override
	public List<Classes> getClassesByNameFromDB(String className) {
		String query = "SELECT * FROM CLASSES WHERE className = :className";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("className", className);
		
		List<Classes> classess = namedParameterJdbcTemplate.query(query, param, new ClassesRowMapper());

		logger.info("Classess " + classess);
		return classess;
	}
	
	@Override
	public boolean updateClassesInDB(Integer classId, Classes classes) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addClassesInDB(String className, String teacherInCharge, Integer studentsInClass) {
		if ( teacherDBOps.getTeachersByNameFromDB(teacherInCharge).size() <= 0 ){
			logger.info("The Teacher is not added");
			return false;
		}
		
		String query = "INSERT INTO CLASSES(className, teacherInCharge, studentsInClass) " + 
					   "VALUES (:className, :teacherInCharge, :studentsInClass)";

        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("className", className)
                .addValue("teacherInCharge", teacherInCharge)
                .addValue("studentsInClass", studentsInClass);

        int updateCount = namedParameterJdbcTemplate.update(query, param);

        return updateCount > 0;
	}
	@Override
	public Classes getClassesDetailsFromDB(Integer classId) {
		String query = "SELECT * FROM CLASSES WHERE classId = :classId";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("classId", classId);
		
		Classes classes = namedParameterJdbcTemplate.queryForObject(query, param, new ClassesRowMapper());
		return classes;
	}
	@Override
	public boolean deleteClassesByIDFromDB(Integer classId) {
		String query = "DELETE FROM CLASSES WHERE classId = :classId";
		
		MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("classId", classId);
		
		Integer deletedCount = namedParameterJdbcTemplate.update(query, param);

		return deletedCount > 0;
	}

}

