package models;

import java.util.HashMap;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Scores {

	@Id
	public ObjectId scoreCardId;
	
	public ObjectId studentId;
	public ObjectId courseId;
	
	public String stream;
	public String className;
	public HashMap<Subject, Integer> scoresEarned; 	

/*	#ScoreCard doc in Json
    ScoreCard:
        scoreCardId:    _id
        studentId:      _linkToStudentDoc
        courseId:       _linkToCourseDoc        
        stream:         'Computer Science'
        className :     '3rd year'
        Subjects:
            - Maths :       '15'
            - Physics:      '14'
            - Chemistry:    '13'            
            - Calculus:     '13'
*/	
}
