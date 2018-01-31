package app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.db.SubjectDBOps;
import app.dto.Subject;

@Service
public class SubjectService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private SubjectDBOps dbOps;

	public List<Subject> getSubjectService() {
		logger.info("Inside getSubjectService");
		return dbOps.getSubjectsFromDB();
	}

	public boolean addSubjectService(Subject subject) {
		logger.info("Inside addSubjectService");
		logger.info("Adding " + subject);
		return dbOps.addSubjectInDB(subject);
	}

	public Subject getSubjectDetailsService(Integer subjectId) {
		logger.info("Inside getSubjectDetailsService");
		logger.info("Getting details for ID: " + subjectId);
		return dbOps.getSubjectDetailsFromDB(subjectId);
	}

	public boolean updateSubjectByIDService(Integer subjectId, Subject subject) {
		logger.info("Inside updateSubjectByIDService");
		logger.info("Updating details for ID: " + subjectId);
		logger.info("Object Content to be updated" + subject);
		return dbOps.updateSubjectInDB(subjectId, subject);
	}

	public boolean deleteSubjectByIDService(Integer subjectId) {
		logger.info("Inside deleteSubjectByIDService");
		logger.info("Deleting details for ID: " + subjectId);
		return dbOps.deleteSubjectByIDFromDB(subjectId);
	}
	
}
