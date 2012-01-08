package models;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import play.data.validation.Required;
import play.modules.morphia.Model;

@Entity
public class Subject extends Model {
		
	@Required
	public String subjectName;

	// TODO: more fields, like syllabus, books recommended etc.
	
	public Subject(String subjectName) {
		//super();
		this.subjectName = subjectName;
	}
		
/*	#Subject doc - completed
    Subject:
        subjectId:      'M12345'
        subjectName:    'Maths'
*/	

}
