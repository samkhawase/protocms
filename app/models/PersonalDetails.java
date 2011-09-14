package models;

import java.util.Date;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Embedded;
import play.modules.morphia.Model;

@Embedded
public class PersonalDetails {
	
//	// default bson doc. id
//	public ObjectId objectId;
	
	// other personal details
	public String firstName;
	public String middleName;
	public String lastName;
	public String addressLine1;
	public String addressLine2;
	public String city;
	public String state;
	public String zipCode;
	public int phoneNumber;
	public Date dateofBirth;
	public String sex;
	public String bloodGroup;
	
}
