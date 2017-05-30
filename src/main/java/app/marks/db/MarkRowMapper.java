package app.marks.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.marks.dto.Marks;

public class MarkRowMapper implements RowMapper<Marks> {
	public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
		Marks mark = new Marks();
		
		mark.setMark(rs.getInt("markId"));
		mark.setEvaluatorName(rs.getString("evaluatorName"));
		mark.setMark(rs.getInt("mark"));
		mark.setStudentName(rs.getString("studentName"));
		mark.setSubjectName(rs.getString("subjectName"));
		
		return mark;
	}
}
