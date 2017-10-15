package controllers;

import java.util.List;

import modelo.method.Method;
import modelo.method.MethodRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MethodController {
	public ModelAndView list(Request req, Response res){
		List<Method> methods = MethodRepository.getInstance().getList();
		return new ModelAndView(methods, "methods/list.hbs");
	}
	
	public Void create(Request req, Response res){
		
		return null;
	}
	
	public ModelAndView renderNewForm(Request req, Response res){
		return new ModelAndView(null, "methods/new.hbs");
	}
	
	public ModelAndView show(Request req, Response res){
		String id = req.params("id");
		
		Method method = MethodRepository.getInstance().getById(Integer.valueOf(id));
		return new ModelAndView(method, "methods/show.hbs");
	}
}
