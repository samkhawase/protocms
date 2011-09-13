package models;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Id;
import play.modules.morphia.Model;

public class Course extends Model {

	public Course(String courseName, String courseHead,
			List<String> courseSubjects) {
		super();
		this.courseName = courseName;
		this.courseHead = courseHead;
		this.courseSubjects = courseSubjects;
	}
	@Id
	public ObjectId id;
	
	public String courseName;
	public String courseHead;
	public List<String> courseSubjects;
	
}
