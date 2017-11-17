package controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseIndicators;
import modelo.enterprise.EnterpriseRepository;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import modelo.user.User;
import modelo.user.UserRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicatorController extends Controller {
	public ModelAndView list(Request req, Response res){
		List<Indicator> indicators = withTransaction(()-> currentUser(req).getIndicators());
		return new ModelAndView(indicators, "indicators/list.hbs");		
	}
	
	public Response create(Request req, Response res){
		Indicator indicator = new Indicator(req.queryParams("name"), req.queryParams("formula"));
		
		withTransaction(()-> {
			User currentUser = currentUser(req);
			currentUser.addIndicator(indicator);
			UserRepository.getInstance().updateElement(currentUser);
		});
		
		res.redirect("/indicators");
		
		return res;
	}
	
	public Response edit(Request req, Response res){
		Indicator indicator = new Indicator(req.queryParams("name"), req.queryParams("formula"), id(req));
		withTransaction(()-> IndicatorRepository.getInstance().updateElement(indicator));
		return res;
	}
	
	public ModelAndView renderNewForm(Request req, Response res){
		return new ModelAndView(null, "indicators/new.hbs");
	}
	
	public ModelAndView renderEditForm(Request req, Response res){
		Indicator indicator = withTransaction(()-> IndicatorRepository.getInstance().getById(id(req)));
		return new ModelAndView(indicator, "indicators/edit.hbs");
	}
	
	public ModelAndView show(Request req, Response res){		
		Indicator indicator = withTransaction(()-> IndicatorRepository.getInstance().getById(id(req)));
		return new ModelAndView(indicator, "indicators/show.hbs");
	}
	
	public Response delete(Request req, Response res){
		withTransaction(()-> {
			Indicator indicator = IndicatorRepository.getInstance().getById(id(req));
			IndicatorRepository.getInstance().deleteElement(indicator);
		});		
		return res;
	}
	
	public ModelAndView evaluate(Request req, Response res){
		List<String> listEnterprises = Arrays.asList(req.queryParamsValues("selected"));
		
		int year = Integer.parseInt(req.queryParams("quantity"));
		
		List<EnterpriseIndicators> list = reduceIndicatorsForAllEnterprises(listEnterprises, year);
		
		return new ModelAndView(list, "indicators/evaluate.hbs");
	}
	
	private List<EnterpriseIndicators> reduceIndicatorsForAllEnterprises(List<String> list,int year)
	{
		return EnterpriseRepository.getInstance().getList().stream()
				.map(enterprise->new EnterpriseIndicators(enterprise.getName(), list, year)).collect(Collectors.toList());	
	}
	public ModelAndView filter(Request req, Response res){		
		List<Indicator> indicators = withTransaction(() -> IndicatorRepository.getInstance().filterByName(req.queryParams("name")));
		return new ModelAndView(indicators, "indicators/filter.hbs");
	}
}
