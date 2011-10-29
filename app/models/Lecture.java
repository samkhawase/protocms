package models;

import java.util.List;
import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import play.modules.morphia.Model;

@Entity
public class Lecture extends Model {

	public Lecture(String teacherName, Subject subject, String className,
			String stream) {
		super();
		this.teacherName = teacherName;
		this.subject = subject;
		this.className = className;
		this.stream = stream;
	}

	@Id
	public ObjectId lectureId;
	
	public ObjectId teacherId;
	public String teacherName;
	public Subject subject;
	public String className;
	public String stream;
	
	public List<Attendance> attendance;
	
	//overridden methods, required for Play-Morphia
	@Override public Object getId() {return lectureId;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}
	
/*	#Lecture Doc    
    Lecture:
        lectureId:          _id
        teacherId:          _linkToTeacherDoc   # teacher can be fetched by using the document _id
        teacherName:        'Pande'             # redundant info       
        subject:            'Maths'
        class:              '3rd Year'
        division:           'Computers'
    # _Embedded Attendance Doc; List
        Attendance:
            -
              attendanceID:       _id
              lectureId:          _linkToLectureDoc
              date:               '2001-11-23'
              startTime:          '3:00 PM'
              endTime:            '4:00 PM'
              rollNumbersPresent: [1,2,3,4,5,6]
              rollNumbersAbsent:  [7,8,9,10]                
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
