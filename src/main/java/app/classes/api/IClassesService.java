package app.classes.api;

import java.util.List;

import app.classes.dto.Classes;

public interface IClassesService {
	public List<Classes> getClassesService();
	
	public boolean addClassesService(Classes classes);
	
	public Classes getClassesDetailsService(Integer classesId);

	public boolean updateClassesByIDService(Integer markId, Classes classesClasses);

	public boolean deleteClassesByIDService(Integer markId);
}
