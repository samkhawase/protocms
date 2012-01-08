package models;

import com.google.code.morphia.annotations.Embedded;
import play.modules.morphia.Model;

@Embedded
public class EnrolmentDetails {

	public String enrolmentNumber;
	public String rollNumber; 			// can be String also
	// we need the college/institution details here
}
