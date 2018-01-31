package app.db.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.dto.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher>{

	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher teacher = new Teacher();
		

    teacher.setTeacherId(rs.getInt("teacherId"));

    teacher.setTeacherName(rs.getString("teacherName"));

    teacher.setYearsOfExperience(rs.getInt("yearsOfExperience"));

    teacher.setDateOfBirth(rs.getDate("dateOfBirth"));

    teacher.setJoiningDate(rs.getDate("joiningDate"));

		
		return teacher;
	}

}
