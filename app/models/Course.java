package models;

import java.util.List;

import play.modules.morphia.Model;

public class Course extends Model {

	public String courseName;
	public String courseHead;
	public List<String>[] courseSubjects;
	
}
