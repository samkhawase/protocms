package models;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import play.modules.morphia.Model;

@Entity
public class Teacher extends Model {

	@Id
	public ObjectId teacherId;
	
	@Embedded
	public User loginDetails;
	
	@Embedded
	public PersonalDetails personalDetails;
	
	@Embedded
	public EmploymentDetails employmentDetails;
	
	@Embedded
	public List<ObjectId> lectureDetails;
	
	//overridden methods, required for Play-Morphia
	@Override public Object getId() {return teacherId;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}
	
	
/*	#Teacher doc
    Teacher:
        teacherId:              _id
        loginDetails:           _Embedded
        personalDetails:        _Embedded
        enrollmentDetails:      _Embedded
        teachingDetails:        
            lectures:
                - _linkToLecture1
                - _linkToLecture2
                - _linkToLecture3
*/
}
