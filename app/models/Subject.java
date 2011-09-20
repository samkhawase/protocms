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
	
	// more fields, if reqd.
	
/*	#Subject doc - completed
    Subject:
        subjectId:      'M12345'
        subjectName:    'Maths'
*/	

}
