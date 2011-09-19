package models;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Scores {

	public Scores(String courseName, String teacherName, long scoresEarned) {
		super();
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.scoresEarned = scoresEarned;
	}
	
	public String courseName;
	public String teacherName;
	public long scoresEarned; 
	
}
