package app.db.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.dto.Classroom;

public class ClassroomRowMapper implements RowMapper<Classroom>{

	public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
		Classroom classroom = new Classroom();
		

    classroom.setClassroomId(rs.getInt("classroomId"));

    classroom.setClassroomName(rs.getString("classroomName"));

    classroom.setTeacherInCharge(rs.getString("teacherInCharge"));

    classroom.setStudentsInClass(rs.getInt("studentsInClass"));

		
		return classroom;
	}

}
