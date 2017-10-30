package controllers;

import java.util.List;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EnterpriseController extends Controller {
	public ModelAndView list(Request req, Response res){
		List<Enterprise> enterprises = withTransaction(() -> currentUser(req).getEnterprises());
		return new ModelAndView(enterprises, "enterprises/list.hbs");
	}
	
	public ModelAndView show(Request req, Response res){		
		Enterprise enterprise = withTransaction(() -> EnterpriseRepository.getInstance().getById(id(req)));
		return new ModelAndView(enterprise, "enterprises/show.hbs");
	}
	
	public Response delete(Request req, Response res){
		withTransaction(() -> {
			Enterprise enteprise = EnterpriseRepository.getInstance().getById(id(req));
			EnterpriseRepository.getInstance().deleteElement(enteprise);
		});
		return res;
	}
}
