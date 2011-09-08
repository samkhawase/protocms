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

	@Required
	public String password;
	
	@Email
	@Required
	public String emailId;
	
	public boolean isStudent;
	public boolean isEmployee;
	public boolean isAdmin;

	public Date createdOn;
	public Date lastUpdate;
	
// salted passwords are coming in next version	
//	@Required
//	public String saltedPass;
//	@Required
//	public String salt;
//	@Required
//	public String recoveryString;
	
	public User(String userId, String password, String email){
		this.userId = userId;
		this.emailId = email;
		this.password = password;
		
	}

}
