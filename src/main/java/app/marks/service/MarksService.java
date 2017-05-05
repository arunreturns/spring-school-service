package app.marks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.marks.api.IMarksDBOps;
import app.marks.api.IMarksService;
import app.marks.dto.Marks;

@Service
public class MarksService implements IMarksService {
	@Autowired
    private IMarksDBOps dbOps;

	@Override
	public List<Marks> getMarksService() {
		return dbOps.getMarksFromDB();
	}

	@Override
	public boolean addMarksForStudentService(Marks studentMarks) {
		return dbOps.addMarksForStudentInDB(studentMarks.getStudentName(), studentMarks.getSubjectName(), studentMarks.getMark(), studentMarks.getEvaluatorName());
	}

	@Override
	public List<Marks> getMarksForStudentService(String studentName) {
		return dbOps.getMarksForStudentFromDB(studentName);
	}

	@Override
	public boolean updateMarksForStudentService(Integer markId, Marks studentMarks) {
		return dbOps.updateMarksForStudentInDB(markId, studentMarks);
	}

	@Override
	public boolean deleteMarksByIDService(Integer markId) {
		return dbOps.deleteMarksByIDFromDB(markId);
	}
	
}
