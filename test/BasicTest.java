import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.*;

import com.google.code.morphia.annotations.Embedded;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	/*
	 * @Before public void setup(){ play.Logger.info("Inside @Before method()");
	 * Fixtures.deleteAllModels();
	 * 
	 * }
	 */

	// test subjects
	/*
	 * @Test public void testSubject(){ // create and save new Subject Subject
	 * maths = new Subject("Maths").save();
	 * 
	 * play.Logger.info(maths.getId()+" : maths.Id");
	 * 
	 * // test the subject Name created assertEquals("Maths",maths.subjectName);
	 * assertEquals(maths, Subject.find("bySubjectName", "Maths").first());
	 * //test if the objectId is not null assertNotNull(maths.getId()); }
	 */

	// test course
	
	@Test
	public void testCourse() {

		// create few subjects and get one from DB
		Subject physics = new Subject("Physics").save();
		Subject chemistry = new Subject("Chemistry").save();

		Subject maths = Subject.find("bySubjectName", "Maths").first();
		if (maths == null)
			maths = new Subject("Maths").save();

		Map<String, Subject> listOfSubjects = new HashMap<String, Subject>();
		listOfSubjects.put(chemistry.getId().toString(), chemistry);
		listOfSubjects.put(maths.getId().toString(), maths);
		listOfSubjects.put(physics.getId().toString(), physics);

		// create a Course object and persist
		Course course = new Course("Computer", "Third Year", "Pande",
				listOfSubjects);
		course.save();

		// tests assertNotNull(course);

		Course anotherCourse = Course.find("byClassName", "Third Year").first();

		assertNotNull(anotherCourse);
		assertEquals("Third Year", anotherCourse.className);
		assertEquals("Pande", anotherCourse.courseHead);
		// assertEquals("Chemistry",anotherCourse.courseSubjects.get(0).subjectName);
		// assertTrue(anotherCourse.courseSubjects.containsKey("Chemistry"));

	}


	// test lecture - also testing attendance with it
	@Test
	public void testLecture() {
		Subject english = new Subject("English").save();

		// Teacher pande = new Teacher(); 	Complete this when Teacher is ready

		Lecture lecture = new Lecture(new ObjectId(), "Pande", english,
				"Third Year", "Computer").save();

		// create an attendace doc and update lecture with it.
		String[] rollNumbersPresent = new String[] { "1", "2", "3", "4", "5", "9", "10" };
		String[] rollNumbersAbsent = new String[] { "6", "7", "8" };

		Attendance attendance122411 
				= new Attendance(new ObjectId(), new Date(), "10:00:00", "11:00:00", 
						rollNumbersPresent, rollNumbersAbsent).save();

		attendance122411.lectureId = (ObjectId) lecture.getId();

		lecture.attendance = new ArrayList();
		lecture.attendance.add(attendance122411);

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
	public void testTimetable() {

		// first create a Schedule
		Lecture testLecture = Lecture.find("byTeacherName", "Pande").first();

		if (testLecture != null) {

			Schedule dummySchedule = new Schedule();
			dummySchedule.lectureId = (ObjectId) testLecture.getId();
			dummySchedule.startTime = "10:00:00 AM";
			dummySchedule.endTime = "11:00:00 AM";

			HashMap<String, Schedule> schedules = new HashMap<String, Schedule>();
			schedules.put("Monday", dummySchedule);

			TimeTable timeTable = new TimeTable("Computer", "Third Year",
					schedules);
			timeTable.save();			
		}

	}
 
 		// TODO: test scorecard
	  
	@Test
	public void testScoreCard() {
		// new score card
		Scores scoreCard = new Scores();

		// fill in the details of the card
		scoreCard.studentId = new ObjectId();
		Course anotherCourse = Course.find("byClassName", "Third Year").first();
		if (null == anotherCourse)
			scoreCard.courseId = new ObjectId();	// Create a new Course
		scoreCard.stream = "Computer";
		scoreCard.className = "Third Year";

		// get and create some subjects
		Subject physics = new Subject("Physics").save();
		Subject maths = Subject.find("bySubjectName", "Maths").first(); 
		if (maths == null) 
			maths = new Subject("Maths").save();

		// create a HashMap with subjects and the scores
		scoreCard.scoresEarned = new HashMap<ObjectId, Integer>();

		scoreCard.scoresEarned.put((ObjectId)physics.getId(), new Integer(12));
		scoreCard.scoresEarned.put((ObjectId)maths.getId(), new Integer(13));

		// assign it to the score card object
		scoreCard.save();

	}

}
