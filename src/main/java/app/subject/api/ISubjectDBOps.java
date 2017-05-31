package app.subject.api;

import java.util.Date;
import java.util.List;

import app.subject.dto.Subject;

public interface ISubjectDBOps {
	// Get all rows from DB
	public List<Subject> getSubjectsFromDB();
	
	// Insert a new row into DB
	public boolean addSubjectInDB(Subject subject);
	
	// Get a specific row from DB
	public Subject getSubjectDetailsFromDB(Integer subjectId);
	
	// Update a single row based on ID in DB
	public boolean updateSubjectInDB(Integer subjectId, Subject subject);
	
	// Delete a specific row from DB
	public boolean deleteSubjectByIDFromDB(Integer subjectId);
}
