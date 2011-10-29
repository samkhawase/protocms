package models;

import java.util.Date;

import org.bson.types.ObjectId;

import play.modules.morphia.Model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Attendance extends Model{
	
	@Id
	public ObjectId attendaceSheetId;
	
	public ObjectId lectureId;
	public Date lectureDate;
	public String startTime;
	public String endTime;
	public String [] rollNumbersPresent, rollNumbersAbsent;
	
	//overridden methods, required for Play-Morphia
	@Override public Object getId() {return attendaceSheetId;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}

	
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
