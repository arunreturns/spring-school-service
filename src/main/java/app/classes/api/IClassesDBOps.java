package app.classes.api;

import java.util.List;

import app.classes.dto.Classes;

public interface IClassesDBOps {
	public List<Classes> getClassesFromDB();
	
	public List<Classes> getClassesByNameFromDB(String classesName);
	
	public boolean updateClassesInDB(Integer classesId, Classes classes);
	
	public boolean addClassesInDB(String classesName, String teacherInCharge, Integer studentsInClass);
	
	public Classes getClassesDetailsFromDB(Integer classesId);

	public boolean deleteClassesByIDFromDB(Integer classesId);
}
