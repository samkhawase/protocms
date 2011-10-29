package models;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import play.modules.morphia.Model;

@Entity
public class Course extends Model {

	public Course(String stream, String className, String courseHead,
			List<Subject> courseSubjects) {
		super();
		this.stream = stream;
		this.className = className;
		this.courseHead = courseHead;
		this.courseSubjects = courseSubjects;
	}
	@Id
	public ObjectId id;
	
	public String stream;
	public String className;
	public String courseHead;
	public List<Subject> courseSubjects = new ArrayList<Subject>();

	//overridden methods for Play-Morphia	
	@Override public Object getId() {return id;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}	
    
    
/*  #Course doc
    Course: 
        courseId:       _id
        stream:         'Computer Science'
        className :     '3rd year'
        courseHead :    'Pande'
        courseSubjects:
            - subjectOne : 
                    subjectName: 'Maths'
                    subjectId: 'M12345'
            - subjectTwo: 
                    subjectName: 'Physics'
                    subjectId: 'P12345'            
            - subjectThree: 
                    subjectName: 'Chemistry'
                    subjectId: 'C12345'            
            - subjectFour: 
                    subjectName: 'English'
                    subjectId: 'E12345'           
            - subjectFive: 
                    subjectName: 'Calculus'
                    subjectId: 'M12222'    
*/
}
