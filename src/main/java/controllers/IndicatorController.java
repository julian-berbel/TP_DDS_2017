package controllers;

import java.util.List;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicatorController {
	public ModelAndView list(Request req, Response res){
		List<Indicator> indicators = IndicatorRepository.getInstance().getList();
		return new ModelAndView(indicators, "indicators/list.hbs");
	}
	
	public Void create(Request req, Response res){
		Indicator indicator = new Indicator(req.queryParams("name"), req.queryParams("formula"));
		IndicatorRepository.getInstance().addElement(indicator);
		return null;
	}
	
	public ModelAndView renderNewForm(Request req, Response res){
		return new ModelAndView(null, "indicators/new.hbs");
	}
	
	public ModelAndView show(Request req, Response res){
		String id = req.params("id");
		
		Indicator indicator = IndicatorRepository.getInstance().getById(Integer.valueOf(id));
		return new ModelAndView(indicator, "indicators/show.hbs");
	}
}
