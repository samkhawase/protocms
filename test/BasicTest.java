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
		Course course = new Course("Computer", "Third Year", "Pande", listOfSubjects);
		course.save();
		
		// tests
		assertNotNull(course);
		
		Course anotherCourse = Course.find("byClassName","Third Year").first();
		
		assertNotNull(anotherCourse);
		assertEquals("Third Year", anotherCourse.className);
		assertEquals("Pande", anotherCourse.courseHead);
		assertEquals("Chemistry",anotherCourse.courseSubjects.get(0).subjectName);
		
	}
	
	// test lecture - also testing attendance with it
	@Test
	public void testLecture(){
		Subject english = new Subject("English").save();
		
		Lecture lecture = new Lecture("Pande", english, "Third Year", "Computer").save();
		
		//	create an attendace doc and update lecture with it.	
		Attendance dummyAttendance = new Attendance();
		dummyAttendance.lectureId = new ObjectId();
		dummyAttendance.lectureDate = new Date();
		dummyAttendance.startTime = "10:00:00";
		dummyAttendance.endTime = "11:00:00";
		dummyAttendance.rollNumbersPresent = new String[] {"1","2","3","4","5","9","10"};
		dummyAttendance.rollNumbersAbsent = new String [] {"6","7","8"};
		lecture.attendance = new ArrayList(); 
		lecture.attendance.add(dummyAttendance);		

		// Update lecture and test
		lecture.save();
		// check if saved lecture is valid
		Lecture newLecture = Lecture.find("byTeacherName", "Pande").first();
		
		assertNotNull(newLecture);
		
		assertEquals("Pande", newLecture.teacherName);
		assertEquals("Third Year", newLecture.className);
		assertEquals("Computer", newLecture.stream);
		assertEquals(english, newLecture.subject);
		
	}
	 
	// TODO: test timetable
	@Test
	public void testTimetable(){

//		first create a Schedule
		Lecture testLecture = Lecture.find("byTeacherName", "Pande").first();
		
		Schedule dummySchedule = new Schedule();
		dummySchedule.lectureId = testLecture.lectureId;
		dummySchedule.startTime = "10:00:00 AM";
		dummySchedule.endTime = "11:00:00 AM";
		
		HashMap schedules = new HashMap();
		schedules.put("Monday", dummySchedule);

		TimeTable timeTable = new TimeTable("Computer", "Third Year", schedules);
		timeTable.save();
		
		
	}
	
	// TODO: test scorecard
	@Test
	public void testScoreCard(){
		// new score card
		Scores scoreCard = new Scores();
		// fill in the details of the card
		scoreCard.studentId = null;
		scoreCard.courseId = null;
		scoreCard.stream = "Computer";
		scoreCard.className = "Third Year";
		// getand create some subjects
		Subject physics = new Subject("Physics");
		Subject maths = Subject.find("bySubjectName", "Maths").first();
		// create a HashMap with subjects and the scores
		HashMap<ObjectId, Integer> subjects = new HashMap();
		subjects.put(physics.subjectId, new Integer(12));
		subjects.put(maths.subjectId, new Integer(13));
		//assign it to the score card object
		
		scoreCard.save();
		
//		scoreCard.scoresEarned = subjects;
//		scoreCard.save();
		
//		String stream;                          
//		String className;                       
//		HashMap<ObjectId, Integer> scoresEarned;
	}
	
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
