package main;

import controllers.HomeController;
import controllers.LoginController;
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
		
		Spark.get("/home", HomeController::home, engine);
		Spark.get("/login", loginController::render, engine);
		Spark.post("/login", loginController::login);
	}

}