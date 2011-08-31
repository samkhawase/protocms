package models;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.modules.morphia.Model;

@Entity
public class User extends Model {
	
	@Required
	public String userId;
	
	@Email
	@Required
	public String emailId;
	
	public boolean isStudent;
	public boolean isEmployee;
	public boolean isAdmin;
	
	@Required
	public String saltedPass;
	@Required
	public String salt;
	@Required
	public String recoveryString;
	
	public Date createdOn;
	public Date lastUpdate;

	public User(String userId, String password, String email){
		this.userId = userId;
		this.emailId = email;
		
		// create a salted password here
		
	}
}
