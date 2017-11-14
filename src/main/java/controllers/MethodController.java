package controllers;

import java.util.List;

import modelo.enterprise.EnterpriseRepository;
import modelo.method.Method;
import modelo.method.MethodRepository;
import modelo.method.result.MethodReport;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MethodController extends Controller {
	public ModelAndView list(Request req, Response res){
		List<Method> methods = withTransaction(()-> currentUser(req).getMethods());
		return new ModelAndView(methods, "methods/list.hbs");
	}
	
	public Response create(Request req, Response res){
		return res;
	}
	
	public ModelAndView renderNewForm(Request req, Response res){
		return new ModelAndView(null, "methods/new.hbs");
	}
	
	public ModelAndView show(Request req, Response res){
		Method method = withTransaction(()-> MethodRepository.getInstance().getById(id(req)));
		return new ModelAndView(method, "methods/show.hbs");
	}
	
	public ModelAndView eval(Request req, Response res){
		MethodReport report = withTransaction(()-> {
			Method method = MethodRepository.getInstance().getById(id(req));
			return method.eval(EnterpriseRepository.getInstance().getList());
		});
		return new ModelAndView(report, "methods/eval.hbs");
	}
	
	public Response delete(Request req, Response res){
		withTransaction(()-> {
			Method method = MethodRepository.getInstance().getById(id(req));
			MethodRepository.getInstance().deleteElement(method);
		});
		return res;
	}
}
