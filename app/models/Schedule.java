package models;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Schedule {
	
	public ObjectId lectureId;
	public String startTime;		// "10:00:00 AM"
	public String endTime;			// "11:00:00 AM"
	
/* Schedule Doc    
 * schedule: 
        lectureId:    _linkToLectureDoc
        startTime:    '10:00 AM'
        endTime:      '11:00 AM'
*/	

}
