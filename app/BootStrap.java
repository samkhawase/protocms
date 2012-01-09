import java.util.ArrayList;
import java.util.List;
import play.*;
import play.jobs.*;
import play.test.*;
import models.*;

import org.apache.log4j.*;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

@OnApplicationStart
public class BootStrap extends Job {


	public void doJob() {
		
		Fixtures.deleteAllModels();
		
		// create the basic information
		LoadData.createBasic();
		// student
		LoadData.createStudent();
		// teacher
		LoadData.createTeacher();
		
	}

}
