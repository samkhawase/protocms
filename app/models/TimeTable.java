package models;

import java.util.HashMap;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import play.modules.morphia.Model;

@Entity
public class TimeTable extends Model {

	public TimeTable(String stream, String className,
			HashMap<String, Schedule> schedule) {
		super();
		this.stream = stream;
		this.className = className;
		this.schedule = schedule;
	}
	@Id
	public ObjectId timetableId;
	
	public String stream;
	public String className;
	public HashMap<String, Schedule> schedule;		// "Monday": {ObjId, startTime, EndTime}	
		
	
/*	#Timetable doc
    TimeTable:
        stream: 'Computer Science'
        class: '3rd year'
        Monday :
            lecture1: 
              lectureId:    _linkToLectureDoc
              startTime:    '10:00 AM'
              endTime:      '11:00 AM'
            lecture2:
              lectureId:    _linkToLectureDoc
              startTime:    '11:00 AM'
              endTime:      '12:00 PM'
            lecture3:
              lectureId:    _linkToLectureDoc
              startTime:    '01:00 PM'
              endTime:      '02:00 PM'
            lecture4:
              lectureId:    _linkToLectureDoc
              startTime:    '02:00 PM'
              endTime:      '03:00 PM'            
            lecture5:
              lectureId:    _linkToLectureDoc
              startTime:    '03:00 PM'
              endTime:      '04:00 PM'                          
        Tuesday: 
            # ...
        Wednesday: 
            # ...
        Thursday: 
            # ...
        Friday: 
            # ...
*/            	
	
}
