package controllers;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	public static ModelAndView home(Request req, Response res){
		User user = UserRepository	.getInstance()
									.getById(Long.valueOf(req.cookie("UserId")));
		
		return new ModelAndView(user, "home/home.hbs");
	}
	
}
