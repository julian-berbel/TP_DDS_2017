package controllers;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	public static ModelAndView home(Request req, Response res){
		Email email = new Email(req.cookie("Email"));
		
		return new ModelAndView(email, "home/home.hbs");
	}
	
}
