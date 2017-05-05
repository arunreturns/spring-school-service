package app.teacher.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.teacher.dto.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher>{

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher teacher = new Teacher();

		teacher.setTeacherId(rs.getInt("teacherId"));
		teacher.setTeacherName(rs.getString("teacherName"));
		teacher.setDateOfBirth(rs.getDate("dateOfBirth"));
		teacher.setYearsOfExperience(rs.getInt("yearsOfExperience"));
		teacher.setTeacherSubject(rs.getString("teacherSubject"));
		return teacher;
	}

}
