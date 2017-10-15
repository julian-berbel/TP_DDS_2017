package controllers;

import java.util.List;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EnterpriseController {
	public ModelAndView list(Request req, Response res){
		List<Enterprise> enterprises = EnterpriseRepository.getInstance().getList();
		return new ModelAndView(enterprises, "enterprises/list.hbs");
	}
	
	public ModelAndView show(Request req, Response res){
		String id = req.params("id");
		
		Enterprise enterprise = EnterpriseRepository.getInstance().getById(Integer.valueOf(id));
		return new ModelAndView(enterprise, "enterprises/show.hbs");
	}
}
