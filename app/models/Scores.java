package models;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Scores {

	public Scores(String courseName, String teacherName, long[] scoresEarned) {
		super();
		this.courseName = courseName;
		TeacherName = teacherName;
		this.scoresEarned = scoresEarned;
	}
	
	public String courseName;
	public String TeacherName;
	public long [] scoresEarned; 
	
}
