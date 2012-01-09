package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	
    	Student student = Student.find().first();
    	Course currentCourse = Course.findById(student.currentCourse);
    	render(student,currentCourse);
    }
    
    public static void bootstrap(){
    	
    	render();
    }

}