import java.util.ArrayList;
import java.util.List;

import models.Course;
import models.EnrolmentDetails;
import models.PersonalDetails;
import models.Scores;
import models.Student;
import models.User;

import org.bson.types.ObjectId;
import org.junit.Test;

import play.test.UnitTest;


public class StudentTest extends UnitTest {

	// TODO: test student
	@Test
	public void testStudent() {

		// create a student here;
		User user = new User("Sam", "secret", "sam@gmail.com");
		user.isAdmin = false;
		user.isEmployee = false;
		user.isStudent = true;

		// personal details
		PersonalDetails personalDetails = new PersonalDetails();
		personalDetails.firstName = "Sam";
		personalDetails.lastName = "Khawse";
		personalDetails.addressLine1 = "5032 EP True";
		personalDetails.city = "West Des Moines";

		// enrollment Details
		EnrolmentDetails ed = new EnrolmentDetails();
		ed.enrolmentNumber = "1234";
		ed.rollNumber = "34";

		// Scores
		Scores currentScores = Scores.find().first();
		List<Scores> listScores = new ArrayList();
		listScores.add(currentScores);

		// Course
		Course currentCourse = Course.find().first();

		// now create a student
		Student student = new Student();
		student.currentCourse = (ObjectId) currentCourse.getId();
		student.user = user;
		student.personalDetails = personalDetails;
		student.enrolmentDetails = ed;
		student.scores = listScores;

		play.Logger.info("Student created with Name: "
				+ student.personalDetails.firstName);

		student.save();

	}
	
	
}
