package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.db.MarksDBOps;
import app.dto.Marks;

@Service
public class MarksService {
	@Autowired
    private MarksDBOps dbOps;

	public List<Marks> getMarksService() {
		return dbOps.getMarksFromDB();
	}

	public boolean addMarksForStudentService(Marks studentMarks) {
		return dbOps.addMarksForStudentInDB(studentMarks.getStudentName(), studentMarks.getSubjectName(), studentMarks.getMark(), studentMarks.getEvaluatorName());
	}

	public List<Marks> getMarksForStudentService(String studentName) {
		return dbOps.getMarksForStudentFromDB(studentName);
	}

	public boolean updateMarksForStudentService(Integer markId, Marks studentMarks) {
		return dbOps.updateMarksForStudentInDB(markId, studentMarks);
	}

	public boolean deleteMarksByIDService(Integer markId) {
		return dbOps.deleteMarksByIDFromDB(markId);
	}
	
}
