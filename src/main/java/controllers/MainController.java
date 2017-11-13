package controllers;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MainController {
	public static ModelAndView main(Request req, Response res){
		return new ModelAndView(null, "main/main.hbs");
	}
}