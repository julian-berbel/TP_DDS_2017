package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	public ModelAndView render(Request req, Response res){
		return new ModelAndView(null, "login/login.hbs");
	}
	
	public Void login(Request req, Response res){
		res.cookie("Email", req.queryParams("Email"));
		res.redirect("/home");
		return null;
	}
	
}
