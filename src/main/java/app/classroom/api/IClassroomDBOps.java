package app.classroom.api;

import java.util.Date;
import java.util.List;

import app.classroom.dto.Classroom;
import app.student.dto.Student;

public interface IClassroomDBOps {
	// Get all rows from DB
	public List<Classroom> getClassroomsFromDB();
	
	// Insert a new row into DB
	public boolean addClassroomInDB(Classroom classroom);
	
	// Get a specific row from DB
	public Classroom getClassroomDetailsFromDB(Integer classroomId);
	
	// Update a single row based on ID in DB
	public boolean updateClassroomInDB(Integer classroomId, Classroom classroom);
	
	// Delete a specific row from DB
	public boolean deleteClassroomByIDFromDB(Integer classroomId);
	
	// Update number of students in classroom
	public boolean updateStudentsInClassRoom(String classroomName, Integer studentsInClass);
	
	// Returns all the students in a classroom
	public List<Student> getStudentsInClassRoomFromDB(Integer classroomId);
}
