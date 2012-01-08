package models;

import java.util.HashMap;

import org.bson.types.ObjectId;

import play.modules.morphia.Model;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Scores extends Model {

	public ObjectId studentId;
	public ObjectId courseId;
	public String stream;
	public String className;
	
	// Hashmap of Subject.Id and Int isn't that good idea. need to find another way  
	public HashMap<ObjectId, Integer> scoresEarned; // ObjectId of the Subject.class
	
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
