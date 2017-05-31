package app.subject.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.subject.dto.Subject;

public class SubjectRowMapper implements RowMapper<Subject>{

	@Override
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subject subject = new Subject();
		

    subject.setSubjectId(rs.getInt("subjectId"));

    subject.setSubjectName(rs.getString("subjectName"));

		
		return subject;
	}

}
