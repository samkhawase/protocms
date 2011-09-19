package models;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import play.modules.morphia.Model;

@Entity
public class Course extends Model {

	public Course(String courseName, String courseHead,
			List<Subject> courseSubjects) {
		super();
		this.courseName = courseName;
		this.courseHead = courseHead;
		this.courseSubjects = courseSubjects;
	}
	@Id
	public ObjectId id;
	
	public String courseName;
	public String courseHead;
	public List<Subject> courseSubjects;

	//overridden methods for Play-Morphia
	
	@Override public Object getId() {return id;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}	
	
}
