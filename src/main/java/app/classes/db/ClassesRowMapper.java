package app.classes.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.classes.dto.Classes;

public class ClassesRowMapper implements RowMapper<Classes>{

	@Override
	public Classes mapRow(ResultSet rs, int rowNum) throws SQLException {
		Classes classes = new Classes();

		classes.setClassId(rs.getInt("classId"));
		classes.setClassName(rs.getString("className"));
		classes.setTeacherInCharge(rs.getString("teacherInCharge"));
		classes.setStudentsInClass(rs.getInt("studentsInClass"));
		
		return classes;
	}

}
