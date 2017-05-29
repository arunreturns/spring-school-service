package app.classes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.classes.api.IClassesDBOps;
import app.classes.api.IClassesService;
import app.classes.dto.Classes;

@Service
public class ClassesService implements IClassesService {
	@Autowired
    private IClassesDBOps dbOps;

	@Override
	public List<Classes> getClassesService() {
		return dbOps.getClassesFromDB();
	}

	@Override
	public boolean addClassesService(Classes classesDetails) {
		return dbOps.addClassesInDB(classesDetails.getClassName(), classesDetails.getTeacherInCharge(), classesDetails.getStudentsInClass());
	}

	@Override
	public Classes getClassesDetailsService(Integer classesId) {
		return dbOps.getClassesDetailsFromDB(classesId);
	}

	@Override
	public boolean updateClassesByIDService(Integer markId, Classes classesClasses) {
		return dbOps.updateClassesInDB(markId, classesClasses);
	}

	@Override
	public boolean deleteClassesByIDService(Integer markId) {
		return dbOps.deleteClassesByIDFromDB(markId);
	}
	
}
