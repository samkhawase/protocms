import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

//	private Logger logger = LogManager.getLogger(BasicTest.class);
/*	@Before
	public void setup(){
		play.Logger.info("Inside @Before method()");
		Fixtures.deleteAllModels();
		
	}
	*/
	
	// test subjects 
	@Test
	public void testSubject(){
		// create and save new Subject
		Subject maths = new Subject("Maths").save();
		// test the subject Name created
		Subject anotherSubject = Subject.find("bySubjectName", "Maths").first();
		assertEquals("Maths",anotherSubject.subjectName);
		//test if the objectId is not null
		assertNotNull(maths.subjectId);
		assertEquals(maths.subjectId, anotherSubject.subjectId);
		
//		play.Logger.info("inside testSubject()");
	}
	
	// test course
	@Test
	public void testCourse(){
		// create few subjects and get one from DB
		Subject physics = new Subject("Physics").save();
		Subject chemistry = new Subject("Chemistry").save();
		Subject maths = Subject.find("bySubjectName", "Maths").first();
		
		List<Subject> listOfSubjects = new ArrayList();
		listOfSubjects.add(chemistry);
		listOfSubjects.add(maths);
		listOfSubjects.add(physics);
		
		// create a Course object and persist
		Course course = new Course("Computer", "3rd Year", "Pande", listOfSubjects).save();
		
		// tests
		assertNotNull(course);
		
		Course anotherCourse = Course.find("byStream", "Computer").first();
		
		assertNotNull(anotherCourse);
		assertEquals("3rd Year", anotherCourse.className);
		assertEquals("Pande", anotherCourse.courseHead);
		assertEquals("Chemistry",anotherCourse.courseSubjects.get(0).subjectName);
		
	}
	
	// test lecture
	@Test
	public void testLecture(){
		Subject english = new Subject("English").save();
		
		Lecture lecture = new Lecture("Pande", english, "3rd Year", "Computer").save();
		
		
/*	TODO: create an attendace doc and update lecture with it.	
 * ObjectId one = new ObjectId("xyzf123");
		ObjectId two = new ObjectId("xyzf1234");
		List<ObjectId> dummyAttendance = new ArrayList();
		dummyAttendance.add(one);
		dummyAttendance.add(two);
		
		lecture.attendance = dummyAttendance;
*/		
		
	}
	 
	// TODO: test timetable
	
	// TODO: test scorecard
	
	// TODO: test student
	
	//TODO: test teacher
	
     @Test 
     public void testStudentAndRelated(){
		
/*    	// create a student here;
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
		ed.rollNumber = 34;

		// Scores
		Scores scores = new Scores();
		scores.className = "3rd semester";
		
		// Course
		List<String> subjects = new ArrayList();
		subjects.add("Maths");
		subjects.add("Physics");
		subjects.add("Chemistry");
		
 		// now create a student
		Student student = new Student();
		student.currentCourse = course.id;  // currentCourse is now _id
		student.user = user;
		student.personalDetails = personalDetails;
		student.enrolmentDetails = ed;
		student.scores = scoresList;

		logger.info("Student created with Name: "+ student.personalDetails.firstName);
		//manually assign ObjectId to Student
    	

		student.save();
*/    	
    }

}
