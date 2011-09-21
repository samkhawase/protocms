package models;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import play.data.validation.Required;
import play.modules.morphia.Model;

@Entity
public class Subject extends Model {
	
	@Id
	public ObjectId subjectId;
	
	@Required
	public String subjectName;

	// more fields, like syllabus, books recommended etc.
	
	//overridden methods for Play-Morphia	
	@Override public Object getId() {return subjectId;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}	
	
/*	#Subject doc - completed
    Subject:
        subjectId:      'M12345'
        subjectName:    'Maths'
*/	

}
