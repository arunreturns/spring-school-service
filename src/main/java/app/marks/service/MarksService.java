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
	public List<Marks> getMarks() {
		return dbOps.getMarksFromDB();
	}

	@Override
	public boolean updateMarksForStudent(Marks studentMarks) {
		return dbOps.updateMarksForStudent(studentMarks.getStudentName(), studentMarks.getSubjectName(), studentMarks.getMark());
	}

	@Override
	public boolean addMarksForStudent(Marks studentMarks) {
		return dbOps.addMarksForStudent(studentMarks.getStudentName(), studentMarks.getSubjectName(), studentMarks.getMark(), studentMarks.getEvaluatorName());
	}

	@Override
	public List<Marks> getMarksForStudent(String studentName) {
		return dbOps.getMarksForStudent(studentName);
	}
	
}
