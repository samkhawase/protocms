import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;

import models.EmploymentDetails;
import models.Lecture;
import models.PersonalDetails;
import models.Teacher;
import models.User;
import play.test.UnitTest;

public class TestTeacher extends UnitTest {

	// TODO: test teacher

	@Test
	public void testTeacher() {

		// create a teacher here;
		User user = new User("Pande", "secret", "pande@gmail.com");
		user.isEmployee = true;
		user.isStudent = false;

		// personal details
		PersonalDetails personalDetails = new PersonalDetails();
		personalDetails.firstName = "Makarand";
		personalDetails.lastName = "Pande";
		personalDetails.addressLine1 = "Katraj- Ambegaon";
		personalDetails.city = "Pune";
		personalDetails.phoneNumber = 99988876;

		// employmentdetails
		EmploymentDetails employmentDetails = new EmploymentDetails();
		employmentDetails.employeeNumber = "123ZQ";

		// get lectures
		Lecture firstLecture = Lecture.find().first();
		List<ObjectId> lectureList = new ArrayList();
		lectureList.add((ObjectId) firstLecture.getId());

		// save the teacher to db
		Teacher pande = new Teacher();

		pande.loginDetails = user;
		pande.personalDetails = personalDetails;
		pande.employmentDetails = employmentDetails;
		pande.lectureDetails = lectureList;

		pande.save();
		
		play.Logger.info("Teacher created: ", pande.personalDetails.firstName);

		// @Embedded public User loginDetails;
		// @Embedded public PersonalDetails personalDetails;
		// @Embedded public EmploymentDetails employmentDetails;
		// @Embedded public List<ObjectId> lectureDetails;

	}

}
