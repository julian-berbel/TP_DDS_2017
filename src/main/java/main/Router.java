package main;

import controllers.HomeController;
import controllers.LoginController;
import controllers.EnterpriseController;
import controllers.IndicatorController;
import controllers.MethodController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();

		Spark.staticFiles.location("/public");

		LoginController loginController = new LoginController();
		EnterpriseController enterpriseController = new EnterpriseController();
		MethodController methodController = new MethodController();
		IndicatorController indicatorController = new IndicatorController();
		
		Spark.get("/", HomeController::home, engine);
		
		Spark.get("/login", loginController::render, engine);
		Spark.post("/login", loginController::login);
		
		Spark.get("/enterprises", enterpriseController::list, engine);
		Spark.get("/enterprises/:id", enterpriseController::show, engine);
		
		Spark.get("/indicators", indicatorController::list, engine);
		Spark.post("/indicators", indicatorController::create);
		Spark.get("/indicators/new", indicatorController::renderNewForm, engine);
		Spark.get("/indicators/:id", indicatorController::show, engine);
		
		Spark.get("/methods", methodController::list, engine);
		Spark.post("/methods", methodController::create);
		Spark.get("/methods/new", methodController::renderNewForm, engine);
		Spark.get("/methods/:id", methodController::show, engine);
		
	}

}