package controllers;

import java.util.NoSuchElementException;

import exceptions.WrongCredentialsException;
import modelo.user.User;
import modelo.user.UserRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController extends Controller{
	public ModelAndView render(Request req, Response res){
		return new ModelAndView(null, "login/login.hbs");
	}
	
	public Void login(Request req, Response res){
		try{
			User user = withTransaction(()-> UserRepository.getInstance().getByEmail(req.queryParams("Email")));
			
			if(!user.validatePassword(req.queryParams("Password"))) throw new WrongCredentialsException();
			
			res.cookie("UserId", String.valueOf(user.getId()));
			res.redirect("/");
		}catch(NoSuchElementException | WrongCredentialsException e){
			//TODO mostrar un mensaje de credenciales invalidas
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ModelAndView logout(Request req, Response res){
		res.removeCookie("UserId");
		res.redirect("/login");
		return null;
	}
	
}
