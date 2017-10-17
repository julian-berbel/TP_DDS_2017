package controllers;


import java.util.Arrays;
import java.util.List;

import modelo.enterprise.EnterpriseIndicators;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import viewModel.AnalyzeEnterpriseVM;

public class IndicatorController {
	public ModelAndView list(Request req, Response res){
		List<Indicator> indicators = IndicatorRepository.getInstance().getList();
		return new ModelAndView(indicators, "indicators/list.hbs");		
	}
	
	public Void create(Request req, Response res){
		Indicator indicator = new Indicator(req.queryParams("name"), req.queryParams("formula"));
		IndicatorRepository.getInstance().addElement(indicator);
		res.redirect("/indicators");
		return null;
	}
	
	public Void edit(Request req, Response res){
		long indicatorId = Long.valueOf(req.queryParams("id"));
		Indicator indicator = new Indicator(req.queryParams("name"), req.queryParams("formula"), indicatorId);
		IndicatorRepository.getInstance().updateElement(indicator);
		res.redirect("/indicators", 200);
		return null;
	}
	
	public ModelAndView renderNewForm(Request req, Response res){
		return new ModelAndView(null, "indicators/new.hbs");
	}
	
	public ModelAndView renderEditForm(Request req, Response res){
		String indicatorId = req.params("id");
		res.cookie("indicatorId", indicatorId);
		Indicator indicator = IndicatorRepository.getInstance().getById(Long.valueOf(indicatorId));
		return new ModelAndView(indicator, "indicators/edit.hbs");
	}
	
	public ModelAndView show(Request req, Response res){
	
		String id = req.params("id");
		
		Indicator indicator = IndicatorRepository.getInstance().getById(Integer.valueOf(id));
		return new ModelAndView(indicator, "indicators/show.hbs");
	}
	
	public Void delete(Request req, Response res){
		String id = req.params("id");
		
		Indicator indicator = IndicatorRepository.getInstance().getById(Integer.valueOf(id));
		IndicatorRepository.getInstance().deleteElement(indicator);

		res.redirect("/indicators");
		
		return null;
	}
	
	
	public ModelAndView evaluate(Request req, Response res){
		List<String> listEnterprises = Arrays.asList(req.queryParamsValues("selected"));
		
		
		int year= Integer.parseInt(req.queryParams("quantity"));
		
		List<EnterpriseIndicators> list= new AnalyzeEnterpriseVM().reduceIndicatorsForAllEnterprises(listEnterprises, year);
		
		return new ModelAndView(list, "indicators/evaluate.hbs");
	}
}
