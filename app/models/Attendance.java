package models;

import java.util.Date;
import org.bson.types.ObjectId;
import play.modules.morphia.Model;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Attendance extends Model{
	
	public ObjectId lectureId;
	public Date lectureDate;
	public String startTime;
	public String endTime;
	public String [] rollNumbersPresent, rollNumbersAbsent;
	
	public Attendance(ObjectId lectureId, Date lectureDate, String startTime,
			String endTime, String[] rollNumbersPresent,
			String[] rollNumbersAbsent) {

		this.lectureId = lectureId;
		this.lectureDate = lectureDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rollNumbersPresent = rollNumbersPresent;
		this.rollNumbersAbsent = rollNumbersAbsent;
	}


	
/*    Attendance:
        -
          attendanceID:       _id
          lectureId:          _linkToLectureDoc
          date:               '2001-11-23'
          startTime:          '3:00 PM'
          endTime:            '4:00 PM'
          rollNumbersPresent: [1,2,3,4,5,6]
          rollNumbersAbsent:  [7,8,9,10]                
	*/
}
