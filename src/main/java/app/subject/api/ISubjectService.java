package app.subject.api;

import java.util.List;

import app.subject.dto.Subject;

public interface ISubjectService {
	// Returns all the rows from DB as a List
	public List<Subject> getSubjectService();
	
	// Add a single subject into DB
	public boolean addSubjectService(Subject subject);
	
	// Returns a single Subject entity from DB
	public Subject getSubjectDetailsService(Integer subjectId);

	// Updates a single Subject entity in DB
	public boolean updateSubjectByIDService(Integer subjectId, Subject subject);

	// Deletes a single Subject entity in DB
	public boolean deleteSubjectByIDService(Integer markId);
}
