package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.modules.morphia.Model;
import com.google.code.morphia.annotations.Entity;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Id;

@Entity
public class Course extends Model {

	public String stream;
	public String className;
	public String courseHead;
	public Map<String, Subject> courseSubjects;	
	
	public Course(String stream, String className, String courseHead,
			Map<String, Subject> courseSubjects) {

		this.stream = stream;
		this.className = className;
		this.courseHead = courseHead;
		this.courseSubjects = courseSubjects;
	}
    
    
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
