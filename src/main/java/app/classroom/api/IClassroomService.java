package app.classroom.api;

import java.util.List;

import app.classroom.dto.Classroom;

public interface IClassroomService {
	// Returns all the rows from DB as a List
	public List<Classroom> getClassroomService();
	
	// Add a single classroom into DB
	public boolean addClassroomService(Classroom classroom);
	
	// Returns a single Classroom entity from DB
	public Classroom getClassroomDetailsService(Integer classroomId);

	// Updates a single Classroom entity in DB
	public boolean updateClassroomByIDService(Integer classroomId, Classroom classroom);

	// Deletes a single Classroom entity in DB
	public boolean deleteClassroomByIDService(Integer markId);
}
