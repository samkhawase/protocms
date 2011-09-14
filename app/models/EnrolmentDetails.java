package models;

import com.google.code.morphia.annotations.Embedded;
import play.modules.morphia.Model;

@Embedded
public class EnrolmentDetails {

	public long enrolmentNumber;
	public int rollNumber; 			// can be String also
	// we need the college/institution details here
}
