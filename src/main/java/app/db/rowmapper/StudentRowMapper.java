package app.db.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.dto.Student;

public class StudentRowMapper implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		

    student.setStudentId(rs.getInt("studentId"));

    student.setStudentName(rs.getString("studentName"));

    student.setStudentClass(rs.getString("studentClass"));

    student.setStudentEmail(rs.getString("studentEmail"));

    student.setParentEmail(rs.getString("parentEmail"));

    student.setDateOfBirth(rs.getDate("dateOfBirth"));

		
		return student;
	}

}
