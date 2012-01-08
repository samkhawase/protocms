import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import models.Attendance;
import models.Course;
import models.EmploymentDetails;
import models.EnrolmentDetails;
import models.Lecture;
import models.PersonalDetails;
import models.Schedule;
import models.Scores;
import models.Student;
import models.Subject;
import models.Teacher;
import models.TimeTable;
import models.User;


public class LoadData {

	public static void createBasic(){
	
		// Subjects
		Subject physics = new Subject("Physics").save();
		Subject chemistry = new Subject("Chemistry").save();
		Subject maths = new Subject("Maths").save();
		Subject english = new Subject("English").save();
		
		
		// course
		Map<String, Subject> listOfSubjects = new HashMap<String, Subject>();
		listOfSubjects.put(chemistry.getId().toString(), chemistry);
		listOfSubjects.put(maths.getId().toString(), maths);
		listOfSubjects.put(physics.getId().toString(), physics);

		// create a Course object and persist
		Course course = new Course("Computer", "Third Year", "Pande", listOfSubjects).save();
		
		// Lecture 
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
		
		
		// Time table
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
		
		// scorecard
		Scores scoreCard = new Scores();

		// fill in the details of the card
		scoreCard.studentId = new ObjectId();
		Course anotherCourse = Course.find("byClassName", "Third Year").first();
		if (null == anotherCourse)
			scoreCard.courseId = new ObjectId();	// Create a new Course
		scoreCard.stream = "Computer";
		scoreCard.className = "Third Year";

		// create a HashMap with subjects and the scores
		scoreCard.scoresEarned = new HashMap<ObjectId, Integer>();

		scoreCard.scoresEarned.put((ObjectId)physics.getId(), new Integer(12));
		scoreCard.scoresEarned.put((ObjectId)maths.getId(), new Integer(13));

		// assign it to the score card object
		scoreCard.save();
		
		
	}
	
	public static void createStudent(){
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
	
	public static void createTeacher(){
		
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
	}
}
