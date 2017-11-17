package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class DeadEndController extends Controller {
	
	public ModelAndView get(Request req, Response res){		
		return new ModelAndView(null, "/deadend/deadend.hbs");
	}

}
