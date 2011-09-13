package models;

import java.util.Date;

import play.data.validation.Required;
import play.modules.morphia.Model;


/* this class has Student related details */

public class Student extends Model {
	
	// User details, user details are fetched as Student.user.userId; 
	@Required
	public User user;
	
	// personalDetails
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
	
	// enrolment details
	public long enrolmentNumber;
	public int rollNumber; 			// can be String also

	// Course details
	public Course currentCourse;
//	public String[] subjects;
//	public String currentClass;
	

}
